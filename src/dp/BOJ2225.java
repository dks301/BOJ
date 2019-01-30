package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2225 {
	private static final int MOD = 1_000_000_000;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] d = new int[K + 1][N + 1];
		d[0][0] = 1;
		for (int i = 1; i <= K; i++) {
			for (int j = 0; j <= N; j++) {
				for (int l = 0; l <= j; l++) {
					d[i][j] += d[i - 1][j - l];
					d[i][j] = d[i][j] % MOD;
				}
			}
		}
		System.out.println(d[K][N]);
	}
}
