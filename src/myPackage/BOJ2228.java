package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2228 {
	private static int N, M;
	private static int[] A;
	private static int[][] d;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		A = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}
		
		d = new int[N + 1][(int)Math.ceil((N + 1) / 2)];
		
	}
	
	public static int go(int i, int j, int k) {
		if (j == M) {
			return 0;
		}
		if (i == N) {
			return 0;
		}
		
		if (A[i] > 0) {
			d[i][j] = d[i - 1][j];
		}
	}
}
