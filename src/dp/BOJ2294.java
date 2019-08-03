package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 동전 2
 */
public class BOJ2294 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] A = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}

		int[] d = new int[k + 1];
		for (int i = 0; i < n; i++) {
			if (A[i] <= k) {
				d[A[i]] = 1;
			}
		}
		for (int i = 1; i <= k; i++) {
			for (int j = 0; j < n; j++) {
				if (i - A[j] >= 0) {
					int temp = d[i - A[j]] + 1;
					if (d[i - A[j]] != 0) {
						if (d[i] == 0) {
							d[i] = temp;
						} else if (d[i] != 0 && d[i] > temp) {
							d[i] = temp;
						}
					}
				}
			}
		}

		if (d[k] == 0) {
			System.out.println("-1");
		} else {
			System.out.println(d[k]);
		}
	}
}
