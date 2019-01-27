package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10844 {
	public static final int MOD = 1_000_000_000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] d = new int[N + 1][10]; //0<=j<=9: 마지막자리가 j인 갯수
		d[1][0] = 0;
		for (int i = 1; i < 10; i++) {
			d[1][i] = 1;
		}
		
		for (int i = 2; i <= N; i++) {
			d[i][0] = d[i - 1][1] % MOD;
			for (int j = 1; j <= 8; j++) {
				d[i][j] = ((d[i - 1][j - 1] % MOD) + (d[i - 1][j + 1] % MOD)) % MOD;
			}
			d[i][9] = d[i - 1][8] % MOD;
		}
		int result = 0;
		for (int i = 0; i < 10; i++) {
			result = (result + d[N][i]) % MOD;
		}
		System.out.println(result);
	}
}
