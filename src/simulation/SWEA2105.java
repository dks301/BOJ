package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA2105 {
	private static Node start;
	private static int N, ans;
	private static int[][] map;
	private static boolean[] desert; // 먹은 디저트 저장
	
	private static int[] count; // 방향 갯수 저장
	private static final int[][] DIRECTIONS = {{1, 1}, {1, -1}, {-1, -1}, {-1, 1}};
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
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			desert = new boolean[101];
			count = new int[4];
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			ans = -1;
			for (int i = 0; i < N - 1; i++) {
				for (int j = 1; j < N - 1; j++) {
					start = new Node(i, j);
					go(start, desert, count);
				}
			}
			
			sb.append(ans).append(NEW_LINE);
		}
		
		System.out.print(sb);
	}
	
	public static void go(Node n, boolean[] desert, int[] count) {
		if (start.row == n.row && start.col == n.col && count[3] != 0 && count[0] == count[2] && count[1] == count[3]) {
			int temp = count[0] + count[1] + count[2] + count[3];
			if (temp > ans) {
				ans = temp;
			}
			return;
		}
		
		boolean[] d = desert.clone();
		d[map[n.row][n.col]] = true;
		int[] c = count.clone();
		
		for (int i = 0; i < 4; i++) {
			if (c[i] == 0) {
				int nextRow = n.row;
				int nextCol = n.col;
				for (int j = 1; j <= N; j++) {
					nextRow += DIRECTIONS[i][ROW];
					nextCol += DIRECTIONS[i][COL];
					if (nextRow < 0 || nextRow > N - 1 || nextCol < 0 || nextCol > N - 1) {
						break;
					}
					
					if (!(start.row == nextRow && start.col == nextCol)) {
						if (d[map[nextRow][nextCol]]) {
							break;
						}
					}
					
					d[map[nextRow][nextCol]] = true;
					c[i] = j;
					go(new Node(nextRow, nextCol), d, c);
				}
				break;
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
