package bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1303 {
	private static int N, M;
	private static boolean[][] map;
	private static boolean[][] check;
	
	private static final char B = 'B';
	
	private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	private static final int ROW = 0;
	private static final int COL = 1;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new boolean[M][N];
		check = new boolean[M][N];
		
		for (int i = 0; i < M; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				if (temp[j] == B) {
					map[i][j] = true;
				}
			}
		}
		
		int[] power = new int[2];
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (!check[i][j]) {
					if (!map[i][j]) {
						power[0] += bfs(new Node(i, j), false);
					} else {
						power[1] += bfs(new Node(i, j), true);
					}
				}
			}
		}
		
		System.out.println(power[0] + " " + power[1]);
	}
	
	public static int bfs(Node x, boolean team) {
		Queue<Node> q = new LinkedList<>();
		q.add(x);
		check[x.row][x.col] = true;
		int cnt = 1;
		
		
		while (!q.isEmpty()) {
			x = q.remove();
			
			for (final int[] DIRECTION : DIRECTIONS) {
				int nextRow = x.row + DIRECTION[ROW];
				int nextCol = x.col + DIRECTION[COL];
				if (nextRow < 0 || nextCol < 0 || nextRow > M - 1 || nextCol > N - 1) {
					continue;
				}
				
				if (map[nextRow][nextCol] == team && !check[nextRow][nextCol]) {
					q.add(new Node(nextRow, nextCol));
					check[nextRow][nextCol] = true;
					cnt++;
				}
			}
		}
		
		return cnt * cnt;
	}
	
	public static class Node {
		int row, col;
		
		public Node(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
}
