package bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2665 {
	private static int N;
	private static boolean[][] map;
	private static int[][] check;

	private static final int[][] DIRECTIONS = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	private static final int ROW = 0;
	private static final int COL = 1;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				if (temp[j] == '0') {
					map[i][j] = true;
				}
			}
		}
		
		check = new int[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(check[i], Integer.MAX_VALUE);
		}
		check[0][0] = 0;
		bfs();

		System.out.println(check[N - 1][N - 1]);
	}

	public static void bfs() {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(0, 0));
		check[0][0] = 0;

		while (!q.isEmpty()) {
			Node n = q.remove();
			
			for (final int[] D : DIRECTIONS) {
				int nextRow = n.row + D[ROW];
				int nextCol = n.col + D[COL];
				if (nextRow < 0 || nextRow > N - 1 || nextCol < 0 || nextCol > N - 1) {
					continue;
				}
				
				if (check[nextRow][nextCol] == Integer.MAX_VALUE) {
					if (map[nextRow][nextCol]) {
						q.add(new Node(nextRow, nextCol));
						check[nextRow][nextCol] = check[n.row][n.col] + 1;
						
					} else {
						q.add(new Node(nextRow, nextCol));
						check[nextRow][nextCol] = check[n.row][n.col];
					}	
				} else {
					if (map[nextRow][nextCol]) {
						if (check[nextRow][nextCol] > check[n.row][n.col] + 1) {
							q.add(new Node(nextRow, nextCol));
							check[nextRow][nextCol] = check[n.row][n.col] + 1;
						}
						
					} else {
						if (check[nextRow][nextCol] > check[n.row][n.col]) {
							q.add(new Node(nextRow, nextCol));
							check[nextRow][nextCol] = check[n.row][n.col];
						}
					}
				}

			}
		}
	}

	public static class Node {
		int row, col;

		public Node(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
}
