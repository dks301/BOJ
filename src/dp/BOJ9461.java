package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
 * 파도반 수열
 * 문제 그림참고, P(1 ~ 10) = 1, 1, 1, 2, 2, 3, 4, 5, 7, 9
 * P(N) 출력
 */
public class BOJ9461 {
	private static final String NEW_LINE = "\n";
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		long[] P = new long[101];
		P[1] = P[2] = P[3] = 1;
		P[4] = P[5] = 2;
		for (int i = 6; i <= 100; i++) {
			P[i] = P[i - 1] + P[i - 5];
		}
		
		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			sb.append(P[N]).append(NEW_LINE);
		}
		System.out.println(sb.toString());
	}
}
