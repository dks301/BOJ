package floodFill;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * チーズ
 * ねずみの最初の体力は 1 であり，
 * チーズを 1 個食べるごとに体力が 1 増える．
 * ただし，ねずみは自分の体力よりも硬いチーズを食べることはできない．
 * 1 行目には 3 つの整数 H，W，N (1 ≦ H ≦ 1000，1 ≦ W ≦ 1000，1 ≦ N ≦ 9)
 */
public class BOJ5558 {
	private static char[][] a;
	private static boolean[][] check;
	private static Point pos;
	
	private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	private static int ROW = 0;
	private static int COL = 1;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		a = new char[H + 2][W + 2];
		
		for (int i = 0; i < H + 2; i++) {
			Arrays.fill(a[i], 'X');
		}
		
		int startX = 0;
		int startY = 0;
		for (int i = 1; i <= H; i++) {
			char[] temp = br.readLine().toCharArray();
			
			for (int j = 1; j <= W; j++) {
				a[i][j] = temp[j - 1];
				if (a[i][j] == 'S') {
					startX = i;
					startY = j;
				}
			}
		}
		
		pos = new Point(startX, startY);
		
		int ans = 0;
		for (int i = 1; i <= N; i++) {
			check = new boolean[H + 2][W + 2];
			ans += bfs(pos, i, H, W);
		}
		
		System.out.println(ans);
	}
	
	public static int bfs(Point x, int factory, int H, int W) {
		Queue<Point> q = new LinkedList<>();
		q.add(x);
		check[x.x][x.y] = true;
		int[][] d = new int[H + 2][W + 2];
		d[x.x][x.y] = 0;
		
		while (!q.isEmpty()) {
			x = q.remove();
			
			for (final int[] DIRECTION : DIRECTIONS) {
				int nextRow = x.x + DIRECTION[ROW];
				int nextCol = x.y + DIRECTION[COL];
				
				if (check[nextRow][nextCol] == false && a[nextRow][nextCol] != 'X') {
					q.add(new Point(nextRow, nextCol));
					check[nextRow][nextCol] = true;
					d[nextRow][nextCol] = d[x.x][x.y] + 1;
					
					if (a[nextRow][nextCol] - '0' == factory) {
						pos = new Point(nextRow, nextCol);
						return d[nextRow][nextCol];
					}
				}
			}
		}
		
		return -1;
	}
	
	public static class Point {
		int x, y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
