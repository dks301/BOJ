package backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17136 {
	private static int ans = Integer.MAX_VALUE;
	private static int[][] board;
	private static final int[][][] PAPERS = {{{0, 0}},
			{{0, 0}, {1, 0}, {0, 1}, {1, 1}},
			{{0, 0}, {1, 0}, {2, 0}, {0, 1}, {0, 2}, {1, 1}, {1, 2}, {2, 1}, {2, 2}},
			{{0, 0}, {1, 0}, {2, 0}, {3, 0}, {0, 1}, {0, 2}, {0, 3}, {1, 1}, {1, 2}, {1, 3}, {2, 1}, {2, 2}, {2, 3}, {3, 1}, {3, 2}, {3, 3}},
			{{0, 0}, {1, 0}, {2, 0}, {3, 0}, {4, 0}, {0, 1}, {0, 2}, {0, 3}, {0, 4}, {1, 1}, {1, 2}, {1, 3}, {1, 4}, {2, 1}, {2, 2}, {2, 3}, {2, 4}, {3, 1}, {3, 2}, {3, 3}, {3, 4}, {4, 1}, {4, 2}, {4, 3}, {4, 4}}};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		board = new int[10][10];
		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[] p = new int[5];
		dfs(board, p, 0);
		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
	}
	
	public static boolean check(int[][] map) {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (map[i][j] == 1) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static void dfs(int[][] map, int[] p, int depth) {
		for (int i = 0; i < 4; i++) {
			if (p[i] > 5) {
				return;
			}
		}
		
		boolean isFirst = false;
		int startRow = -1, startCol = -1;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (map[i][j] == 1) {
					startRow = i;
					startCol = j;
					isFirst = true;
					break;
				}
			}
			if (isFirst) {
				break;
			}
		}
		
		if (!isFirst) {
			if (ans > depth) {
				ans = depth;
			}
			return;
		}
		
		for (int k = 4; k >= 0; k--) {
			int[][] m = map.clone();
			boolean isTrue = true;
			
			for (final int[] PAPER : PAPERS[k]) {
				int nextRow = startRow + PAPER[0];
				int nextCol = startCol + PAPER[1];
				if (nextRow > 9 || nextCol > 9) {
					isTrue = false;
					break;
				}
				if (m[nextRow][nextCol] == 0) {
					isTrue = false;
					break;
				}
			}
			
			if (isTrue) {
				p[k]++;
				
				for (final int[] PAPER : PAPERS[k]) {
					int nextRow = startRow + PAPER[0];
					int nextCol = startCol + PAPER[1];
					m[nextRow][nextCol] = 0;
				}
				dfs(m, p, depth + 1);
				
				p[k]--;
				for (final int[] PAPER : PAPERS[k]) {
					int nextRow = startRow + PAPER[0];
					int nextCol = startCol + PAPER[1];
					m[nextRow][nextCol] = 1;
				}
			}
		}
	}
}
