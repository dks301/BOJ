package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11066 {
	private static int[] novel, s;
	private static int[][] d;
	private static int K;

	private static final char NEW_LINE = '\n';

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			K = Integer.parseInt(br.readLine());
			novel = new int[K + 1];
			s = new int[K + 1];
			d = new int[K + 1][K + 1];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= K; i++) {
				novel[i] = Integer.parseInt(st.nextToken());
				s[i] = s[i - 1] + novel[i];
				Arrays.fill(d[i], -1);
			}

			sb.append(go(1, K)).append(NEW_LINE);
		}

		System.out.print(sb);
	}

	public static int go(int i, int j) {
		if (i == j) {
			return 0;
		}
		if (d[i][j] != -1) {
			return d[i][j];
		}

		for (int k = i; k < j; k++) {
			int temp = go(i, k) + go(k + 1, j) + s[j] - s[i - 1];
			if (d[i][j] == -1 || d[i][j] > temp) {
				d[i][j] = temp;
			}
		}

		return d[i][j];
	}
}
