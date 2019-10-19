package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ9376 {
	private static int h, w;
	private static char[][] map;
	private static int[][][] check;

	private static final int[][] DIRECTIONS = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	private static final int ROW = 0;
	private static final int COL = 1;

	private static final char WALL = '*';
	private static final char DOOR = '#';
	private static final char MAN = '$';
	private static final char NEW_LINE = '\n';

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			map = new char[h + 2][w + 2];

			ArrayList<Node> manList = new ArrayList<>();
			manList.add(new Node(0, 0, 1));

			for (int i = 1; i <= h; i++) {
				char[] temp = br.readLine().toCharArray();
				for (int j = 1; j <= w; j++) {
					map[i][j] = temp[j - 1];
					if (map[i][j] == MAN) {
						manList.add(new Node(i, j, 1));
					}
				}
			}

			check = new int[3][h + 2][w + 2];
			bfs(manList.get(0), 0);
			bfs(manList.get(1), 1);
			bfs(manList.get(2), 2);

			int ans = Integer.MAX_VALUE;
			for (int i = 0; i < h + 2; i++) {
				for (int j = 0; j < w + 2; j++) {
					int val = check[0][i][j] + check[1][i][j] + check[2][i][j] - 3;
					if (map[i][j] == DOOR) {
						val -= 2;
					}
					
					if (val != -3 && ans > val) {
						ans = val;
					}
				}
			}
			sb.append(ans).append(NEW_LINE);
		}
		System.out.print(sb);
	}

	public static void bfs(Node n, int idx) {
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.add(n);
		check[idx][n.row][n.col] = 1;

		while (!q.isEmpty()) {
			n = q.remove();

			for (final int[] D : DIRECTIONS) {
				int nextRow = n.row + D[ROW];
				int nextCol = n.col + D[COL];
				if (nextRow < 0 || nextRow > h + 1 || nextCol < 0 || nextCol > w + 1) {
					continue;
				}

				if (map[nextRow][nextCol] != WALL) {
					if (check[idx][nextRow][nextCol] == 0) {
						if (map[nextRow][nextCol] == DOOR) {
							q.add(new Node(nextRow, nextCol, n.val + 1));
							check[idx][nextRow][nextCol] = check[idx][n.row][n.col] + 1;

						} else {
							q.add(new Node(nextRow, nextCol, n.val));
							check[idx][nextRow][nextCol] = check[idx][n.row][n.col];
						}
					}
				}
			}
		}
	}

	public static class Node implements Comparable<Node> {
		int row, col;
		int val;

		public Node(int row, int col, int val) {
			this.row = row;
			this.col = col;
			this.val = val;
		}

		@Override
		public int compareTo(Node that) {
			// TODO Auto-generated method stub
			if (this.val < that.val) {
				return -1;
			} else if (this.val == that.val) {
				return 0;
			} else {
				return 1;
			}
		}
	}
}
