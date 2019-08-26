package floodFill;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2468 {
	private static int N;
	private static int[][] map;
	private static boolean[][] check;
	
	private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	private static final int ROW = 0;
	private static final int COL = 1;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int ans = 1;
		for (int h = 1; h < 100; h++) {
			check = new boolean[N][N];
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!check[i][j] && map[i][j] > h) {
						cnt++;
						bfs(new Node(i, j), h);
					}
				}
			}
			
			if (cnt > ans) {
				ans = cnt;
			}
		}
		System.out.println(ans);
	}
	
	public static void bfs(Node n, int h) {
		Queue<Node> q = new LinkedList<>();
		q.add(n);
		check[n.row][n.col] = true;
		
		while (!q.isEmpty()) {
			n = q.remove();
			
			for (final int[] DIRECTION : DIRECTIONS) {
				int nextRow = n.row + DIRECTION[ROW];
				int nextCol = n.col + DIRECTION[COL];
				if (nextRow < 0 || nextCol < 0 || nextRow > N - 1 || nextCol > N - 1) {
					continue;
				}
				
				if (map[nextRow][nextCol] > h && !check[nextRow][nextCol]) {
					q.add(new Node(nextRow, nextCol));
					check[nextRow][nextCol] = true;
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
