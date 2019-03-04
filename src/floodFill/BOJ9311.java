package floodFill;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * Robot in a Maze
 * first Line: TC, Second Line: R and C(ROW & COL)
 * X: wall, S: start, G: exit
 * output: "Shortest Path: t" or "No Exit"
 * What is the fewest number of moves the robot can make to exit from the maze?
 */
public class BOJ9311 {
	private static final String NEW_LINE = "\n";
	
	private static char[][] maze;
	private static boolean[][] check;
	
	private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	private static final int ROW = 0;
	private static final int COL = 1;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		while (N-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			maze = new char[R + 2][C + 2];
			check = new boolean[R + 2][C + 2];
			
			int startX = 0, startY = 0;
			
			for (int i = 1; i <= R; i++) {
				char[] line = br.readLine().toCharArray();
				for (int j = 1; j <= C; j++) {
					maze[i][j] = line[j - 1];
					if (maze[i][j] == 'S') {
						startX = i;
						startY = j;
					}
				}
			}
			
			int result = bfs(new Robot(startX, startY), R, C);
			sb.append(result == -1 ? "No Exit" : "Shortest Path: " + result).append(NEW_LINE);
		}
		System.out.print(sb);
	}
	
	public static int bfs(Robot r, int R, int C) {
		Queue<Robot> q = new LinkedList<>();
		q.add(r);
		check[r.x][r.y] = true;
		int[][] d = new int[R + 2][C + 2];
		d[r.x][r.y] = 0;
		
		while (!q.isEmpty()) {
			r = q.remove();
			
			for (final int[] DIRECTION : DIRECTIONS) {
				int nextRow = r.x + DIRECTION[ROW];
				int nextCol = r.y + DIRECTION[COL];
				
				if (maze[nextRow][nextCol] != 'X' && check[nextRow][nextCol] == false) {
					q.add(new Robot(nextRow, nextCol));
					check[nextRow][nextCol] = true;
					d[nextRow][nextCol] = d[r.x][r.y] + 1;
					
					if (maze[nextRow][nextCol] == 'G') {
						return d[nextRow][nextCol];
					}
				}
			}
		}
		
		return -1;
	}
	
	public static class Robot {
		int x, y;
		
		public Robot(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
