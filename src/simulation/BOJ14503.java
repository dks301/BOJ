package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 로봇 청소기
 * 로봇 청소기는 다음과 같이 작동한다.
 * 1. 현재 위치를 청소한다.
 * 2. 현재 위치에서 현재 방향을 기준으로 왼쪽방향부터 차례대로 탐색을 진행한다.
 *    1. 왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면, 그 방향으로 회전한 다음 한 칸을 전진하고 1번부터 진행한다.
 *    2. 왼쪽 방향에 청소할 공간이 없다면, 그 방향으로 회전하고 2번으로 돌아간다.
 *    3. 네 방향 모두 청소가 이미 되어있거나 벽인 경우에는, 바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로 돌아간다.
 *    4. 네 방향 모두 청소가 이미 되어있거나 벽이면서, 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우에는 작동을 멈춘다.
 * d(동서남북) = (0,북), (1,동), (2,남), (3, 서)
 * 빈 칸 0, 벽 1
 */
public class BOJ14503 {
	private static int N;
	private static int M;
	private static int[][] map;
	private static boolean[][] check;

	private static final int[][][] DIRECTIONS = { { { 0, -1 }, { 1, 0 }, { 0, 1 }, { -1, 0 } }, // 서남동북
			{ { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } }, // 북서남동
			{ { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 0 } }, // 동북서남
			{ { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } } }; // 남동북서
	private static final int ROW = 0;
	private static final int COL = 1;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		Robot r = new Robot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken()));

		map = new int[N][M];
		check = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(bfs(r));
	}

	public static int bfs(Robot r) {
		Queue<Robot> q = new LinkedList<>();
		q.add(r);
		check[r.x][r.y] = true;
		int ans = 1;
		
		while (!q.isEmpty()) {
			r = q.remove();
			int d = r.d;
			
			boolean isTrue = false;
			for (final int[] DIRECTION : DIRECTIONS[d]) {
				int nextRow = r.x + DIRECTION[ROW];
				int nextCol = r.y + DIRECTION[COL];
				r.leftTurn();
				
				if (check[nextRow][nextCol] == false && map[nextRow][nextCol] != 1) {
					q.add(new Robot(nextRow, nextCol, r.d));
					check[nextRow][nextCol] = true;
					isTrue = true;
					ans++;
					break;
				}
			}
			
			if (isTrue == false) {
				int cnt = 0;
				for (final int[] DIRECTION : DIRECTIONS[d]) {
					if (cnt == 1) {
						int nextRow = r.x + DIRECTION[ROW];
						int nextCol = r.y + DIRECTION[COL];
						
						if (map[nextRow][nextCol] != 1) {
							q.add(new Robot(nextRow, nextCol, d));
							isTrue = true;
							break;
						}
					}
					cnt++;
				}
			}
			
			if (isTrue == false) {
				return ans;
			}
		}
		return -1;
	}

	public static class Robot {
		int x, y, d; // (0,북), (1,동), (2,남), (3, 서)

		public Robot(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
		
		public void leftTurn() {
			switch (d) {
			case 0:
				d = 3;
				break;
				
			case 1:
				d = 0;
				break;
				
			case 2:
				d = 1;
				break;
				
			case 3:
				d = 2;
				break;
			}
		}
	}
}
