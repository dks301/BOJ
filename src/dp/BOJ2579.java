package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2579 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			a[i] = Integer.parseInt(br.readLine());
		}
		
		int[][] d = new int[n + 1][3];
		d[1][0] = 0;
		d[1][1] = a[1];
		d[1][2] = 0;
		for (int i = 2; i <= n; i++) {
			d[i][0] = Math.max(d[i - 1][1], d[i - 1][2]);
			d[i][1] = d[i - 1][0] + a[i];
			d[i][2] = d[i - 1][1] + a[i];
		}
		System.out.println(Math.max(d[n][1], d[n][2]));
	}
}
