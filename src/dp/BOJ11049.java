package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11049 {
	private static int N;
	private static int[][] a, d;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		a = new int[N][2];
		d = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			a[i][0] = r;
			a[i][1] = c;
			Arrays.fill(d[i], -1);
		}
		
		System.out.println(go(0, N - 1));
	}

	public static int go(int i, int j) {
		if (i == j) {
			return 0;
		}
		if (i + 1 == j) {
			return a[i][0] * a[i][1] * a[j][1];
		}
		if (d[i][j] != -1) {
			return d[i][j];
		}

		for (int k = i; k < j; k++) {
			int A = go(i, k);
			int B = go(k + 1, j);
			int C = a[i][0] * a[k][1] * a[j][1];
			
			if (d[i][j] == -1 || d[i][j] > A + B + C) {
				d[i][j] = A + B + C;
			}
		}

		return d[i][j];
	}
}
