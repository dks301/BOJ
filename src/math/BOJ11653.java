package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
 * 소인수분해
 */
public class BOJ11653 {
	private static final String NEW_LINE = "\n";
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for (int i = 2; i * i <= N; i++) {
			while (N % i == 0) {
				sb.append(i).append(NEW_LINE);
				N /= i;
			}
		}
		if (N > 1) {
			sb.append(N).append(NEW_LINE);
		}
		System.out.println(sb.toString());
	}
}
