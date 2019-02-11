package floodFill;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 섬의 개수
 * 1<=너비w,높이h<=50
 * 지도가 주어질 때, 섬의 개수를 출력
 * 0 0을 입력하면 종료
 */
public class BOJ4963 {
	private static final String NEW_LINE = "\n";
	private static boolean[][] map;
	private static boolean[][] check;
	
	private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
	private static final int ROW = 0;
	private static final int COL = 1;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			if (w == 0 && h == 0) { //종료
				break;
			}
			map = new boolean[h + 2][w + 2];
			check = new boolean[h + 2][w + 2];
			for (int i = 1; i <= h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= w; j++) {
					int temp = Integer.parseInt(st.nextToken());
					map[i][j] = temp == 1 ? true : false;
				}
			}
			
			int cnt = 0;
			for (int i = 1; i <= h; i++) {
				for (int j = 1; j <= w; j++) {
					if (check[i][j] == false && map[i][j] == true) {
						bfs(i, j);
						cnt++;
					}
				}
			}
			sb.append(cnt).append(NEW_LINE);
		}
		System.out.print(sb);
	}
	
	public static void bfs(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x, y));
		check[x][y] = true;
		
		while(!q.isEmpty()) {
			Point p = q.remove();

			for (final int[] DIRECTION : DIRECTIONS) {
				int nextRow = p.x + DIRECTION[ROW];
				int nextCol = p.y + DIRECTION[COL];
				
				if (check[nextRow][nextCol] == false && map[nextRow][nextCol] == true) {
					q.add(new Point(nextRow, nextCol));
					check[nextRow][nextCol] = true;
				}
			}
		}
	}
	
	public static class Point {
		int x, y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
