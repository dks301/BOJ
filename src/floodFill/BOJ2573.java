package floodFill;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 빙산
 * 빙산: 빙산의 높이로 저장(1~10), 바닷물: 0
 * 빙산의 높이는 동서남북으로 인접한 바닷물의 칸만큼 1년에 1씩 줄어듬(최소 0)
 * 행N과 열M은 3 이상 300 이하
 * 한 덩어리의 빙산이 주어질 때, 이 빙산이 두 덩어리 이상으로 분리되는데 걸리는 년수 출력.
 * 다 녹아도 두 덩어리 이상으로 분리되지 않으면 0 출력. 
 */
public class BOJ2573 {
	private static int[][] map;
	private static boolean[][] check;
	
	private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	private static final int ROW = 0;
	private static final int COL = 1;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		check = new boolean[N][M];
		
		int maxHeight = -1;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (maxHeight < map[i][j]) {
					maxHeight = map[i][j];
				}
			}
		}
		
		int years = 0;
		boolean isNot = true;
		while (!isAllMelt(N, M)) {
			int iceberg = 0;
			check = new boolean[N][M];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] != 0 && check[i][j] == false) {
						bfs(new Node(i, j), N, M);
						iceberg++;
					}
				}
			}
			if (iceberg >= 2) {
				isNot = false;
				System.out.println(years);
				break;
			}
			years++;
		}
		if (isNot == true) {
			System.out.println(0);
		}
	}
	
	public static void bfs(Node v, int N, int M) {
		Queue<Node> q = new LinkedList<>();
		q.add(v);
		check[v.x][v.y] = true;
		int[][] melt = new int[N][M];
		
		while (!q.isEmpty()) {
			v = q.remove();
			for (final int[] DIRECTION : DIRECTIONS) {
				int nextRow = v.x + DIRECTION[ROW];
				int nextCol = v.y + DIRECTION[COL];
				
				if (check[nextRow][nextCol] == false && map[nextRow][nextCol] != 0) {
					q.add(new Node(nextRow, nextCol));
					check[nextRow][nextCol] = true;
				} else if (map[nextRow][nextCol] == 0) {
					melt[v.x][v.y]--;
				}
			}
		}
		setMap(melt, N, M);
	}
	
	public static void setMap(int[][] melt, int N, int M) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] += melt[i][j];
				
				if (map[i][j] < 0) {
					map[i][j] = 0;
				}
			}
		}
	}
	
	public static boolean isAllMelt(int N, int M) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static class Node {
		int x, y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
