package bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * DSLR
 * 계산기 레지스터에 0이상 10,000 미만의 십진수를 저장 가능
 * 저장된 값 n의 네 자릿수를 d1, d2, d3, d4라고 하자
 * 즉 n = ((d1 x 10 + d2) x 10 + d3) + d4
 * 1. D: 2n mod 10000을 레지스터에 저장
 * 2. S: n-1 (-1이면 9999로 저장)
 * 3. L: 왼쪽 회전 시켜 d2, d3, d4, d1으로 저장
 * 4. R: 오른쪽 회전 시켜 d4, d1, d2, d3로 저장
 * 
 * 입력
 * 첫째줄: 테스트 케이스 T
 * 다음T개줄: 두 개의 정수 A와 B(A!=B, A는 초기값, B는 최종값)
 * 
 * 출력
 * A에서 B로 변환하기 위해 필요한 최소한의 명령어 나열
 */
public class BOJ9019 {
	private static int A, B;
	
	private static final char[] CMD = {'D', 'S', 'L', 'R'};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			bfs();
		}
	}
	
	public static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(A);
		boolean[] check = new boolean[10000];
		check[A] = true;
		
		int[] from = new int[10000];
		char[] how = new char[10000];
		
		while (!q.isEmpty()) {
			int cur = q.remove();
			
			for (int i = 0; i < 4; i++) {
				int next = cur;
				switch (i) {
					case 0:
						next = d(cur);
						break;
						
					case 1:
						next = s(cur);
						break;
						
					case 2:
						next = l(cur);
						break;
						
					case 3:
						next = r(cur);
						break;
				}
				if (!check[next]) {
					q.add(next);
					check[next] = true;
					from[next] = cur;
					how[next] = CMD[i];
				}
				
			}
		}
		StringBuilder sb = new StringBuilder();
		int before = from[B];
		sb.append(how[B]);
		while (before != A) {
			int cur = from[before];
			sb.append(how[before]);
			before = cur;
		}
		System.out.println(sb.reverse());
	}
	
	public static int d(int val) {
		return (2 * val) % 10000;
	}
	
	public static int s(int val) {
		return val != 0 ? val - 1 : 9999;
	}
	
	public static int l(int val) {
		int d1 = val / 1000; val %= 1000;
		int d2 = val / 100; val %= 100;
		int d3 = val / 10; val %= 10;
		int d4 = val;
		
		return (d2 * 1000) + (d3 * 100) + (d4 * 10) + d1;
	}
	
	public static int r(int val) {
		int d1 = val / 1000; val %= 1000;
		int d2 = val / 100; val %= 100;
		int d3 = val / 10; val %= 10;
		int d4 = val;
		
		return (d4 * 1000) + (d1 * 100) + (d2 * 10) + d3;
	}
}
