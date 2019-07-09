package bitmask;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 집합
 * 공집합 S가 주어진다.
 * add x: S에 x를 추가한다 (1<=x<=20), x가 이미 있는 경우 무시
 * remove x: S에서 x를 제거한다.(1<=x<=20), x가 없는 경우 무시
 * check x: S에 x가 있으면 1을, 없으면 0을 출력
 * toggle x: S에 x가 있으면 x를 제거, 없으면 x를 추가(1<=x<=20)
 * all: S를 {1, 2, ..., 20}으로 바꾼다.
 * empty: S를 공집합으로 바꾼다.
 * 
 * 입력
 * 첫째줄: 수행해야 하는 연산의 수 M(1<=M<=3,000,000)
 * 둘째줄~M개의줄: 연산이 하나씩 주어진다
 * 
 * 출력
 * check 연산이 주어질 때마다, 결과를 출력
 */
public class BOJ11723 {
	private static int S;
	
	private static final char NEW_LINE = '\n';
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		S = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			int x;
			switch (cmd) {
			case "add":
				x = Integer.parseInt(st.nextToken());
				S = (S | (1 << x));
				break;
				
			case "remove":
				x = Integer.parseInt(st.nextToken());
				S = (S & ~(1 << x));
				break;
				
			case "check":
				x = Integer.parseInt(st.nextToken());
				sb.append((S & (1 << x)) > 0 ? 1 : 0).append(NEW_LINE);
				break;
				
			case "toggle":
				x = Integer.parseInt(st.nextToken());
				S = (S ^ (1 << x));
				break;
				
			case "all":
				for (int j = 1; j <= 20; j++) {
					S = (S | (1 << j));
				}
				break;
				
			case "empty":
				S = 0;
				break;
			}
		}
		System.out.print(sb);
	}
}
