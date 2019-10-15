package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2638 {
	private static int N, M;
	private static boolean[][] map;
	private static int[][] check;
	
	private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	private static final int ROW = 0;
	private static final int COL = 1;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int temp = Integer.parseInt(st.nextToken());
				if (temp == 1) {
					map[i][j] = true;
				}
			}
		}
		
		int ans = 0;
		do {
			bfs();
			ans++;
		} while (!melt());
		
		System.out.println(ans);
	}
	
	public static boolean melt() {
		boolean isAllMelt = true;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (check[i][j] >= 2) {
					map[i][j] = false;
				}
				
				if (map[i][j]) {
					isAllMelt = false;
				}
			}
		}
		
		return isAllMelt;
	}
	
	public static void bfs() {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(0, 0));
		check = new int[N][M];
		check[0][0] = 1;
		
		while (!q.isEmpty()) {
			Node n = q.remove();
			
			for (final int[] D : DIRECTIONS) {
				int nextRow = n.row + D[ROW];
				int nextCol = n.col + D[COL];
				if (nextRow < 0 || nextRow > N - 1 || nextCol < 0 || nextCol > M - 1) {
					continue;
				}
				
				if (!map[nextRow][nextCol] && check[nextRow][nextCol] == 0) {
					q.add(new Node(nextRow, nextCol));
					check[nextRow][nextCol] = 1;
				} else if (map[nextRow][nextCol]) {
					check[nextRow][nextCol]++;
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
