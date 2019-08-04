package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1520 {
	private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	private static final int ROW = 0;
	private static final int COL = 1;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[][] map = new int[M + 1][N + 1];
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] d = new int[M + 1][N + 1];
		d[M][N] = 1;
		for (int i = M; i >= 1; i--) {
			for (int j = N; j >= 1; j--) {
				for (final int[] DIRECTION : DIRECTIONS) {
					int beforeRow = i + DIRECTION[ROW];
					int beforeCol = j + DIRECTION[COL];
					if (beforeRow < 1 || beforeRow > M || beforeCol < 1 || beforeCol > N) {
						continue;
					}
					if (map[beforeRow][beforeCol] > map[i][j]) {
						d[beforeRow][beforeCol] += d[i][j];
					}
				}
			}
		}
		
		for(int i = 1; i <= M; i++) {
			for (int j = 1; j <= N; j++) {
				System.out.print(d[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
		System.out.println(d[1][1]);
	}
}
