package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 1, 2, 3 더하기3
 * 정수 n이 주어졌을때, n을 1,2,3의 합으로 나타내는 방법의 수구하기
 * 
 * 입력
 * 첫째줄: 테스트케이스 개수T
 * 다음T개줄: 정수n(n<=1000000인 양수)
 * 
 * 출력
 * 각 테스트 케이스마다 n을 1,2,3의 합으로 나타내는 방법의 수를 1,000,000,009로 나눈 나머지 출력
 */
public class BOJ15988 {
	private static final int INF = 1_000_000;
	private static final long MOD = 1_000_000_009L;
	private static final char NEW_LINE = '\n';
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long[] d = new long[INF + 1];
		d[0] = d[1] = 1L;
		d[2] = 2L;
		for (int i = 3; i <= INF; i++) {
			d[i] = (d[i - 3] + d[i - 2] + d[i - 1]) % MOD;
		}
		
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int n = Integer.parseInt(br.readLine());
			sb.append(d[n]).append(NEW_LINE);
		}
		System.out.print(sb);
	}
}
