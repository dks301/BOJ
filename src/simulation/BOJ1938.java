package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ1938 {
	private static int N;
	private static int[][] map;
	private static int[][][] check;
	private static Tree start, end;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		boolean isCenterB = false;
		boolean isCenterE = false;

		start = end = null;

		for (int i = 0; i < N; i++) {
			char[] in = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				map[i][j] = in[j] - '0';
				if (map[i][j] == 18) {
					if (!isCenterB) {
						isCenterB = true;
					} else {
						if (i - 1 >= 0 && map[i - 1][j] == 18) {
							start = new Tree(i, j, true);
						} else if (j - 1 >= 0 && map[i][j - 1] == 18) {
							start = new Tree(i, j, false);
						}
						isCenterB = false;
					}
				} else if (map[i][j] == 21) {
					if (!isCenterE) {
						isCenterE = true;
					} else {
						if (i - 1 >= 0 && map[i - 1][j] == 21) {
							end = new Tree(i, j, true);
						} else if (j - 1 >= 0 && map[i][j - 1] == 21) {
							end = new Tree(i, j, false);
						}
						isCenterE = false;
					}
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 18 || map[i][j] == 21) {
					map[i][j] = 0;
				}
			}
		}
		check = new int[N][N][2];
		
		bfs();
		if (end.isVertical) {
			System.out.println(check[end.row][end.col][0] == 0 ? 0 : check[end.row][end.col][0] - 1);
		} else {
			System.out.println(check[end.row][end.col][1] == 0 ? 0 : check[end.row][end.col][1] - 1);
		}
	}
	
	public static void bfs() {
		Queue<Tree> q = new LinkedList<>();
		q.add(start);
		if (start.isVertical) {
			check[start.row][start.col][0] = 1;
		} else {
			check[start.row][start.col][1] = 1;
		}
		
		while (!q.isEmpty()) {
			Tree t = q.remove();
			
			if (t.isVertical) {
				if (canTurn(t)) {
					if (check[t.row][t.col][1] == 0) {
						q.add(new Tree(t.row, t.col, !t.isVertical));
						check[t.row][t.col][1] = check[t.row][t.col][0] + 1;
					}
				}
				
				if (canUp(t)) {
					if (check[t.row - 1][t.col][0] == 0) {
						q.add(new Tree(t.row - 1, t.col, t.isVertical));
						check[t.row - 1][t.col][0] = check[t.row][t.col][0] + 1;
					}
				}
				
				if (canDown(t)) {
					if (check[t.row + 1][t.col][0] == 0) {
						q.add(new Tree(t.row + 1, t.col, t.isVertical));
						check[t.row + 1][t.col][0] = check[t.row][t.col][0] + 1;
					}
				}
				
				if (canLeft(t)) {
					if (check[t.row][t.col - 1][0] == 0) {
						q.add(new Tree(t.row, t.col - 1, t.isVertical));
						check[t.row][t.col - 1][0] = check[t.row][t.col][0] + 1;
					}
				}
				
				if (canRight(t)) {
					if (check[t.row][t.col + 1][0] == 0) {
						q.add(new Tree(t.row, t.col + 1, t.isVertical));
						check[t.row][t.col + 1][0] = check[t.row][t.col][0] + 1;
					}
				}
				
			} else {
				if (canTurn(t)) {
					if (check[t.row][t.col][0] == 0) {
						q.add(new Tree(t.row, t.col, !t.isVertical));
						check[t.row][t.col][0] = check[t.row][t.col][1] + 1;
					}
				}
				
				if (canUp(t)) {
					if (check[t.row - 1][t.col][1] == 0) {
						q.add(new Tree(t.row - 1, t.col, t.isVertical));
						check[t.row - 1][t.col][1] = check[t.row][t.col][1] + 1;
					}
				}
				
				if (canDown(t)) {
					if (check[t.row + 1][t.col][1] == 0) {
						q.add(new Tree(t.row + 1, t.col, t.isVertical));
						check[t.row + 1][t.col][1] = check[t.row][t.col][1] + 1;
					}
				}
				
				if (canLeft(t)) {
					if (check[t.row][t.col - 1][1] == 0) {
						q.add(new Tree(t.row, t.col - 1, t.isVertical));
						check[t.row][t.col - 1][1] = check[t.row][t.col][1] + 1;
					}
				}
				
				if (canRight(t)) {
					if (check[t.row][t.col + 1][1] == 0) {
						q.add(new Tree(t.row, t.col + 1, t.isVertical));
						check[t.row][t.col + 1][1] = check[t.row][t.col][1] + 1;
					}
				}
			}
		}
	}

	public static boolean canUp(Tree t) {
		if (t.isVertical) {
			if (t.row - 2 < 0) {
				return false;
			} else if (map[t.row - 2][t.col] == 1) {
				return false;
			} else {
				return true;
			}
			
		} else {
			if (t.row - 1 < 0) {
				return false;
			} else if (map[t.row - 1][t.col] == 1 || map[t.row - 1][t.col - 1] == 1 || map[t.row - 1][t.col + 1] == 1) {
				return false;
			} else {
				return true;
			}
		}
	}

	public static boolean canDown(Tree t) {
		if (t.isVertical) {
			if (t.row + 2 > N - 1) {
				return false;
			} else if (map[t.row + 2][t.col] == 1) {
				return false;
			} else {
				return true;
			}
			
		} else {
			if (t.row + 1 > N - 1) {
				return false;
			} else if (map[t.row + 1][t.col] == 1 || map[t.row + 1][t.col - 1] == 1 || map[t.row + 1][t.col + 1] == 1) {
				return false;
			} else {
				return true;
			}
		}
	}

	public static boolean canLeft(Tree t) {
		if (t.isVertical) {
			if (t.col - 1 < 0) {
				return false;
			} else if (map[t.row - 1][t.col - 1] == 1 || map[t.row][t.col - 1] == 1 || map[t.row + 1][t.col - 1] == 1) {
				return false;
			} else {
				return true;
			}
			
		} else {
			if (t.col - 2 < 0) {
				return false;
			} else if (map[t.row][t.col - 2] == 1) {
				return false;
			} else {
				return true;
			}
		}
	}

	public static boolean canRight(Tree t) {
		if (t.isVertical) {
			if (t.col + 1 > N - 1) {
				return false;
			} else if (map[t.row - 1][t.col + 1] == 1 || map[t.row][t.col + 1] == 1 || map[t.row + 1][t.col + 1] == 1) {
				return false;
			} else {
				return true;
			}
			
		} else {
			if (t.col + 2 > N - 1) {
				return false;
			} else if (map[t.row][t.col + 2] == 1) {
				return false;
			} else {
				return true;
			}
		}
	}

	public static boolean canTurn(Tree t) {
		for (int i = t.row - 1; i <= t.row + 1; i++) {
			for (int j = t.col - 1; j <= t.col + 1; j++) {
				if (i < 0 || j < 0 || i > N - 1 || j > N - 1) {
					return false;
				}

				if (map[i][j] == 1) {
					return false;
				}
			}
		}

		return true;
	}

	public static class Tree {
		int row, col;
		boolean isVertical;

		public Tree(int row, int col, boolean isVertical) {
			this.row = row;
			this.col = col;
			this.isVertical = isVertical;
		}
	}
}
