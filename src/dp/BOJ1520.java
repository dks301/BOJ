package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1520 {
	private static int M, N;
	private static int[][] map, d;

	private static final int[][] DIRECTIONS = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	private static final int ROW = 0;
	private static final int COL = 1;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[M + 1][N + 1];
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		d = new int[M + 1][N + 1];
		for (int i = 0; i <= M; i++) {
			Arrays.fill(d[i], -1);
		}

		System.out.println(dfs(1, 1));
	}

	public static int dfs(int row, int col) {
		if (row == M && col == N) {
			return 1;
		}
		if (d[row][col] != -1) {
			return d[row][col];
		}
		
		d[row][col] = 0; // 방문체크
		
		for (final int[] DIRECTION : DIRECTIONS) {
			int nextRow = row + DIRECTION[ROW];
			int nextCol = col + DIRECTION[COL];
			if (nextRow < 1 || nextRow > M || nextCol < 1 || nextCol > N) {
				continue;
			}
			if (map[nextRow][nextCol] < map[row][col]) {
				d[row][col] += dfs(nextRow, nextCol);
			}
		}
		
		return d[row][col];
	}
}
