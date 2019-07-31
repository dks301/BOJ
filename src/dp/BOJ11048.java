package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 이동하기
 */
public class BOJ11048 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] d = new int[N][M];
		d[0][0] = map[0][0];
		for (int j = 1; j < M; j++) {
			d[0][j] = d[0][j - 1] + map[0][j];
		}
		
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (j == 0) {
					d[i][j] = d[i - 1][j] + map[i][j];
				} else {
					d[i][j] = max(d[i - 1][j], d[i][j - 1], d[i - 1][j - 1]) + map[i][j];
				}
			}
		}
		
		System.out.println(d[N - 1][M - 1]);
	}
	
	
	public static int max(int a, int b, int c) {
		return a > b ? (a > c ? a : c) : (b > c ? b : c); 
	}
}
