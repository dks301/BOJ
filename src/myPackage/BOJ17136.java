package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17136 {
	private static int ans = Integer.MAX_VALUE;
	private static int[][] board;
	private static final int[][][] PAPER = {{{0, 0}},
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
		dfs(board, 0, 0, 0, 0, 0, 0, 0);
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
	
	public static void dfs(int[][] map, int row, int col, int a, int b, int c, int d, int e) {
		int val = a + b + c + d + e;
		System.out.println(a + " " + b + " " + c + " " + d + " " + e + " ");
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
		for (int k = 0; k < 5; k++) {
			int[][] m = map.clone();
			boolean isTrue = true;
			
			for (final int[] p : PAPER[k]) {
				int nextRow = row + p[0];
				int nextCol = col + p[1];
				if (nextRow > 9 || nextCol > 9 || board[nextRow][nextCol] == 0) {
					isTrue = false;
					break;
				}
			}
			
			if (isTrue) {
				for (final int[] p : PAPER[k]) {
					int nextRow = row + p[0];
					int nextCol = col + p[1];
					m[nextRow][nextCol] = 0;
				}
				
				for (int i = 0; i < 10; i++) {
					for (int j = 0; j < 10; j++) {
						if (m[i][j] == 1) {
							if (k == 4 && e < 5) {
								val++;
								dfs(m, i, j, a, b, c, d, e + 1);
							} else if (k == 3 && d < 5) {
								val++;
								dfs(m, i, j, a, b, c, d + 1, e);
							} else if (k == 2 && c < 5) {
								val++;
								dfs(m, i, j, a, b, c + 1, d, e);
							} else if (k == 1 && b < 5) {
								val++;
								dfs(m, i, j, a, b + 1, c, d, e);
							} else if (k == 0 && a < 5) {
								val++;
								dfs(m, i, j, a + 1, b, c, d, e);
							} else {
								return;
							}
						}
					}
				}
			}
			if (check(m)) {
				if (val < ans) {
					ans = val;
				}
			}
		}
	}
	
	public static int bfs(int[][] map, int a, int b, int c, int d, int e) {
		int[][] m = map.clone();
		
		int ans = 0;
		
		for (int k = 4; k >= 0; k--) {
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					if (k == 4 && e > 4) {
						continue;
					} else if (k == 3 && d > 4) {
						continue;
					} else if (k == 2 && c > 4) {
						continue;
					} else if (k == 1 && b > 4) {
						continue;
					} else if (k == 0 && a > 4) {
						continue;
					}
					
					boolean isTrue = true;
					
					for (final int[] p : PAPER[k]) {
						int nextRow = i + p[0];
						int nextCol = j + p[1];
						if (nextRow > 9 || nextCol > 9 || board[nextRow][nextCol] == 0) {
							isTrue = false;
							break;
						}
					}
					
					if (isTrue) {
						ans++;
						for (final int[] p : PAPER[k]) {
							int nextRow = i + p[0];
							int nextCol = j + p[1];
							m[nextRow][nextCol] = 0;
						}
						
						if (k == 4) {
							e++;
						} else if (k == 3) {
							d++;
						} else if (k == 2) {
							c++;
						} else if (k == 1) {
							b++;
						} else if (k == 0) {
							a++;
						}
					}
				}
			}
		}
		
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println();
		}
		if (check(m)) {
			return ans;
		} else {
			return -1;
		}
	}
}
