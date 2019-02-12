package floodFill;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 다리 만들기
 * 지도의 크기 N(1<=N<=100)
 * 지도에 섬과 바다가 주어질 때, 가장 짧은 다리의 길이를 출력
 */
public class BOJ2146 {
	private static int[][] check;
	private static int[][] map;
	private static ArrayList<Point>[] island;
	
	private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	private static final int ROW = 0;
	private static final int COL = 1;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new int[N + 2][N + 2];
		for (int i = 0; i < N + 2; i++) {
			Arrays.fill(map[i], -1);
		}
		check = new int[N + 2][N + 2];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		island = new ArrayList[N * N + 2];
		int idx = 1;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (check[i][j] == 0 && map[i][j] == 1) {
					setIsland(i, j, idx++);
				}
			}
		}
		
		int min = Integer.MAX_VALUE;
		for (int i = 1; i < idx; i++) {
			int[][] arr = new int[N + 2][N + 2];
			for (int j = 1; j <= N; j++) {
				for (int k = 1; k <= N; k++) {
					arr[j][k] = check[j][k];
				}
			}
			
			int temp = bfs(arr, i);
			if (min > temp) {
				min = temp;
			}
		}
		System.out.println(min);
	}
	
	public static void setIsland(int x, int y, int idx) {
		Queue<Point> q = new LinkedList<>();
		Point temp = new Point(x, y);
		q.add(temp);
		check[x][y] = 1;
		map[x][y] = idx;
		island[idx] = new ArrayList<Point>();
		
		while (!q.isEmpty()) {
			Point p = q.remove();
			island[idx].add(p);
			
			for (final int[] DIRECTION : DIRECTIONS) {
				int nextRow = p.x + DIRECTION[ROW];
				int nextCol = p.y + DIRECTION[COL];
				
				if (check[nextRow][nextCol] == 0 && map[nextRow][nextCol] == 1) {
					q.add(new Point(nextRow, nextCol));
					check[nextRow][nextCol] = 1;
					map[nextRow][nextCol] = idx;
				}
			}
		}
	}
	
	public static int bfs(int[][] check, int idx) {
		Queue<Point> q = new LinkedList<>();
		q.addAll(island[idx]);
		int length = Integer.MAX_VALUE;
		while(!q.isEmpty()) {
			Point p = q.remove();

			for (final int[] DIRECTION : DIRECTIONS) {
				int nextRow = p.x + DIRECTION[ROW];
				int nextCol = p.y + DIRECTION[COL];
				
				if (check[nextRow][nextCol] == 0 && map[nextRow][nextCol] == 0) {
					q.add(new Point(nextRow, nextCol));
					check[nextRow][nextCol] = check[p.x][p.y] + 1;
				} else if (check[nextRow][nextCol] == 1 && map[nextRow][nextCol] != idx && map[nextRow][nextCol] != 0) {
					int temp = check[p.x][p.y];
					if (temp < length) {
						length = temp;
					}
				}
			}
		}
		return length - 1;
	}
	
	public static class Point {
		int x, y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
