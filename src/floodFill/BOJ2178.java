package floodFill;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 미로 탐색
 * N, M(2<=N, M<=100)
 * NxM크기의 미로에서 (1,1) -> (N,M)으로 갈 때 필요한 최소 칸의 갯수 출력
 */
public class BOJ2178 {
	private static boolean[][] maze;
	private static boolean[][] check;
	
	private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	private static final int ROW = 0;
	private static final int COL = 1;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		maze = new boolean[N + 2][M + 2];
		check = new boolean[N + 2][M + 2];
		
		for (int i = 1; i <= N; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j = 1; j <= M; j++) {
				maze[i][j] = temp[j - 1] == '1' ? true : false;
			}
		}
		System.out.println(bfs(N, M));
	}
	
	public static int bfs(int N, int M) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(1, 1));
		check[1][1] = true;
		int[][] d = new int[N + 2][M + 2];
		d[1][1] = 1;
		
		while (!q.isEmpty()) {
			Point p = q.remove();
			
			for (final int[] direction : DIRECTIONS) {
				int nextRow = p.x + direction[ROW];
				int nextCol = p.y + direction[COL];
				
				if (check[nextRow][nextCol] == false && maze[nextRow][nextCol] == true) {
					q.add(new Point(nextRow, nextCol));
					d[nextRow][nextCol] = d[p.x][p.y] + 1;
					check[nextRow][nextCol] = true;
				}
			}
		}
		return d[N][M];
	}
	
	public static class Point {
		int x, y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
