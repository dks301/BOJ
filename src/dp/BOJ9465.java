package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ9465 {
	private static final String NEW_LINE = "\n";
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			
			int[][] s = new int[2][n + 1];
			for (int j = 1; j <= n; j++) {
				s[0][j] = Integer.parseInt(st1.nextToken());
			}
			for (int j = 1; j <= n; j++) {
				s[1][j] = Integer.parseInt(st2.nextToken());
			}
			
			int[][] d = new int[n + 1][3];
			d[0][0] = 0;
			d[0][1] = 0;
			d[0][2] = 0;
			
			for (int j = 1; j <= n; j++) {
				d[j][0] = max(d[j - 1][0], d[j - 1][1], d[j - 1][2]);
				d[j][1] = Math.max(d[j - 1][0], d[j - 1][2]) + s[0][j];
				d[j][2] = Math.max(d[j - 1][0], d[j - 1][1]) + s[1][j];
			}
			sb.append(max(d[n][0], d[n][1], d[n][2])).append(NEW_LINE);
		}
		System.out.println(sb);
	}
	
	public static int max(int a, int b, int c) {
		return a > b ? (a > c ? a : c) : (b > c ? b : c);
	}
}
