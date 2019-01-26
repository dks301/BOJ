package success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2156 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] podo = new int[n + 1];
		
		for (int i = 1; i <= n; i++) {
			podo[i] = Integer.parseInt(br.readLine());
		}
		
		int[][] d = new int[n + 1][2];
		d[0][0] = 0;
		d[0][1] = 0;
		d[1][0] = 0;
		d[1][1] = podo[1];
		for (int i = 2; i <= n; i++) {
			d[i][0] = d[i - 1][1];
			d[i][1] = max(d[i - 2][0] + podo[i - 1] + podo[i], d[i - 1][0] + podo[i], d[i - 1][1]);
		}
		System.out.println(d[n][1]);
	}
	
	public static int max(int a, int b, int c) {
		return a > b ? (a > c ? a : c) : (b > c ? b : c);
	}
}
