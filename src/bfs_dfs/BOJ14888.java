package bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 연산자 끼워넣기
 * N개의 수로 이루어진 수열 Ai, 연산자 N-1개(+,-,x,/)
 * 수의 순서를 바꾸면 안됨, 연산자 우선 순위를 무시하고 앞에서부터 계산
 * N개의 수와 N-1개의 연산자가 주어졌을 때, 만들수 있는 수식의 최대값과 최솟값 출력
 * 
 * 첫째줄: N(2<=N<=11)
 * 둘째줄: A1, A1, ..., An(1<=Ai<=100)
 * 셋째줄: 차례대로 +,-,x,/의 갯수(갯수합이 N-1)
 */
public class BOJ14888 {
	private static int N;
	private static int[] A;
	private static int[] O;
	private static int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		O = new int[4];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			O[i] = Integer.parseInt(st.nextToken());	
		}
		
		for (int i = 0; i < 4; i++) {
			if (O[i] != 0) {
				dfs(A[0], i, 1);
			}
		}
		System.out.println(max);
		System.out.println(min);
	}

	public static void dfs(int val, int select, int depth) {
		if (depth == N) {
			if (val < min) {
				min = val;
			} else if (val > max) {
				max = val;
			}
			return;
		}
		if (O[select] == 0) {
			return;
		}

		int nextVal = 0;
		switch (select) {
		case 0:
			nextVal = val + A[depth];
			O[0]--;
			break;
		case 1:
			nextVal = val - A[depth];
			O[1]--;
			break;
		case 2:
			nextVal = val * A[depth];
			O[2]--;
			break;
		case 3:
			nextVal = val / A[depth];
			O[3]--;
			break;
		}
		
		for (int i = 0; i < 4; i++) {
			dfs(nextVal, i, depth + 1);
		}
		
		O[select]++;
	}
}
