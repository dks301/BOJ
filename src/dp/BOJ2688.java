package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 줄어들지 않아
 * 그 숫자의 각 자리수보다 그 왼쪽 자리수가 작거나 같을 때 (ex, 1234)
 * 0000, 0001, 0002도 올바른 줄어들지않는 4자리수
 * n이 주어졌을때, 줄어들지 않는 n자리 수의 개수를 출력
 */
public class BOJ2688 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		long[][] d = new long[65][10];
		for (int i = 0; i <= 9; i++) {
			d[1][i] = 1;
		}

		for (int i = 2; i <= 64; i++) {
			d[i][0] = 1;
			for (int j = 1; j <= 9; j++) {
				for (int k = 0; k <= j; k++) {
					d[i][j] += d[i - 1][k];
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			int n = Integer.parseInt(br.readLine());
			long ans = 0;
			for (int i = 0; i <= 9; i++) {
				ans += d[n][i];
			}
			sb.append(ans).append("\n");
		}
		System.out.print(sb);
	}
}
