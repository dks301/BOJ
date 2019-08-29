package floodFill;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA1953 {
	private static int N, M, R, C, L;
	private static int[][] map;
	private static int[][] check;
	
	private static final int[][][] DIRECTIONS = {
			{{0, 0}, {0, 0}, {0, 0} ,{0, 0}},
			{{1, 0}, {-1, 0}, {0, 1}, {0, -1}},
			{{1, 0}, {-1, 0}},
			{{0, 1}, {0, -1}},
			{{-1, 0}, {0, 1}},
			{{1, 0}, {0, 1}},
			{{1, 0}, {0, -1}},
			{{-1, 0}, {0, -1}}};
	private static final int ROW = 0;
	private static final int COL = 1;
	
	private static final char NUMBER = '#';
	private static final char SPACE = ' ';
	private static final char NEW_LINE = '\n';
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			sb.append(NUMBER).append(t).append(SPACE);
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			check = new int[N][M];
			Node start = new Node(R, C);
			
			bfs(start);
			int ans = calculation();
			sb.append(ans).append(NEW_LINE);
		}
		System.out.print(sb);
	}
	
	public static int calculation() {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (check[i][j] != 0 && check[i][j] <= L) {
					cnt++;
				}
			}
		}
		return cnt;
	}
	
	public static void bfs(Node n) {
		Queue<Node> q = new LinkedList<>();
		q.add(n);
		check[n.row][n.col] = 1;
		
		while (!q.isEmpty()) {
			n = q.remove();
			
			for (int i = 1; i <= 7; i++) {
				if (i == map[n.row][n.col]) {
					for (final int[] DIRECTION : DIRECTIONS[i]) {
						int nextRow = n.row + DIRECTION[ROW];
						int nextCol = n.col + DIRECTION[COL];
						if (nextRow < 0 || nextCol < 0 || nextRow > N -1 || nextCol > M - 1) {
							continue;
						}
						
						boolean isPossible = false;
						for (final int[] NEXT : DIRECTIONS[map[nextRow][nextCol]]) {
							int r = nextRow + NEXT[ROW];
							int c = nextCol + NEXT[COL];
							if (r < 0 || c < 0 || r > N -1 || c > M - 1) {
								continue;
							}
							
							if (r == n.row && c == n.col) {
								isPossible = true;
								break;
							}
						}
						
						if (isPossible && check[nextRow][nextCol] == 0 && map[nextRow][nextCol] != 0) {
							q.add(new Node(nextRow, nextCol));
							check[nextRow][nextCol] = check[n.row][n.col] + 1;
						}					
					}
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
