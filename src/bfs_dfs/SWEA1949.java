package bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA1949 {
	private static int N, K, max, ans;
	private static int[][] map;
	private static boolean[][] check;
	
	private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	private static final int ROW = 0;
	private static final int COL = 1;
	
	private static final char NUMBER = '#';
	private static final char SPACE = ' ';
	private static final char NEW_LINE = '\n';
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			sb.append(NUMBER).append(t).append(SPACE);
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			
			max = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (max < map[i][j]) {
						max = map[i][j];
					}
				}
			}
			
			ArrayList<Node> al = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == max) {
						al.add(new Node(i, j));
					}
				}
			}
			
			ans = 0;
			for (Node next : al) {
				check = new boolean[N][N];
				dfs(next, map, check, false, 1);
			}
			
			sb.append(ans).append(NEW_LINE);
		}
		System.out.print(sb);
	}
	
	public static boolean[][] deepCopy(boolean[][] c) {
		boolean[][] result = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				result[i][j] = c[i][j];
			}
		}
		return result;
	}
	
	public static int[][] deepCopy(int[][] m) {
		int[][] result = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				result[i][j] = m[i][j];
			}
		}
		return result;
	}
	
	public static void dfs(Node n, int[][] map, boolean[][] c, boolean isWork, int depth) {
		if (depth > ans) {
			ans = depth;
		}
		int val = map[n.row][n.col];
		c[n.row][n.col] = true; 
		
		for (final int[] DIRECTION : DIRECTIONS) {
			int nextRow = n.row + DIRECTION[ROW];
			int nextCol = n.col + DIRECTION[COL];
			if (nextRow < 0 || nextRow > N - 1 || nextCol < 0 || nextCol > N - 1) {
				continue;
			}
			
			if (val > map[nextRow][nextCol] && !c[nextRow][nextCol]) {
				dfs(new Node(nextRow, nextCol), map, deepCopy(c), isWork, depth + 1);
			} else if (val <= map[nextRow][nextCol] && !c[nextRow][nextCol]) {
				if (!isWork) {
					for (int i = 1; i <= K; i++) {
						int temp = map[nextRow][nextCol] - i;
						if (val > temp) {
							int[][] m = deepCopy(map);
							m[nextRow][nextCol] = temp;
							dfs(new Node(nextRow, nextCol), m, deepCopy(c), true, depth + 1);
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
