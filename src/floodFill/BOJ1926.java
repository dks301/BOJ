package floodFill;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1926 {
	private static int[][] paper;
	private static boolean[][] check;
	
	private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	private static final int ROW = 0;
	private static final int COL = 1;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		paper = new int[n + 2][m + 2];
		check = new boolean[n + 2][m + 2];
		
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= m; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt = 0;
		int max = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (paper[i][j] == 1 && check[i][j] == false) {
					int temp = bfs(new Drawing(i, j));
					if (max < temp) {
						max = temp;
					}
					cnt++;
				}
			}
		}
		System.out.print(cnt + "\n" + max);
	}
	
	public static int bfs(Drawing d) {
		Queue<Drawing> q = new LinkedList<>();
		q.add(d);
		check[d.x][d.y] = true;
		int area = 0;
		
		while (!q.isEmpty()) {
			d = q.remove();
			area++;
			
			for (final int[] DIRECTION : DIRECTIONS) {
				int nextRow = d.x + DIRECTION[ROW];
				int nextCol = d.y + DIRECTION[COL];
				
				if (check[nextRow][nextCol] == false && paper[nextRow][nextCol] == 1) {
					q.add(new Drawing(nextRow, nextCol));
					check[nextRow][nextCol] = true;
				}
			}
		}
		
		return area;
	}
	
	public static class Drawing {
		int x, y;
		
		public Drawing(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
