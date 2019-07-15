package bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 소수 경로
 * 소수인 네자리수 비밀번호를 소수인 번호로 바꿔야한다
 * 변환은 한번에 한 자릿수씩 가능하다
 * 소수 A를 소수 B로 바꾸는 과정에서도 항상 네 자리 소수임을 유지해야 한다
 * 
 * 입력
 * 첫째줄: 테스트 케이스 T
 * 다음 T개줄: 한 쌍씩 네 자리 소수가 주어진다
 * 
 * 출력
 * 각 테스트 케이스에 대해 도 소수 사이에 변환에 필요한 최소 횟수 출력
 * 불가능한 경우 Impossible 출력
 */
public class BOJ1963 {
	private static int A, B;
	private static boolean[] isNotPrime;
	
	private static final String IMP = "Impossible";
	private static final char NEW_LINE = '\n';
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		isNotPrime = new boolean[10000];
		isNotPrime[0] = true;
		isNotPrime[1] = true;
		int  cnt = 0;
		for (int i = 2; i < 10000; i++) {
			if (!isNotPrime[i]) {
				for (int j = i * i; j < 10000; j += i) {
					isNotPrime[j] = true;
				}
			}
		}
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			int ans = bfs();
			sb.append(ans != -1 ? ans : IMP).append(NEW_LINE);
		}
		System.out.print(sb);
	}
	
	public static int bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(A);
		int[] check = new int[10000];
		check[A] = 1;
		
		while (!q.isEmpty()) {
			int x = q.remove();
			
			for (int i = 1; i <= 4; i++) {
				for (int j = 0; j <= 9; j++) {
					int next = change(x, i, j);
					if (next < 1000 || next >= 10000) {
						continue;
					}
					
					if (!isNotPrime[next] && check[next] == 0) {
						q.add(next);
						check[next] = check[x] + 1;
					}
					
				}
			}
		}
		return check[B] - 1;
	}
	
	public static int change(int val, int i, int j) {
		int thousand = val / 1000; val %= 1000;
		int hundred = val / 100; val %= 100;
		int ten = val / 10; val %= 10;
		int one = val;
		
		switch (i) {
		case 1:
			return (j * 1000) + (hundred * 100) + (ten * 10) + one;
		case 2:
			return (thousand * 1000) + (j * 100) + (ten * 10) + one;
		case 3:
			return (thousand * 1000) + (hundred * 100) + (j * 10) + one;
		case 4:
			return (thousand * 1000) + (hundred * 100) + (ten * 10) + j;
		}
		return -1;
	}
}
