package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11057 {
	private static final int MOD = 10_007;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] d = new int[N + 1][10];
		for (int i = 0; i < 10; i++) {
			d[1][i] = 1;
		}
		
		for (int i = 2; i <= N; i++) {
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k <= j; k++) {
					d[i][j] += d[i - 1][k] % MOD;
				}
			}
		}
		int result = 0;
		for (int i = 0; i < 10; i++) {
			result = (result + d[N][i]) % MOD;
		}
		System.out.println(result);
		
	}
}
