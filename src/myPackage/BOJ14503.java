package myPackage;

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
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(check[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static int bfs(Robot r) {
		Queue<Robot> q = new LinkedList<>();
		q.add(r);
		check[r.x][r.y] = true;
		int cnt = 0;

		while (!q.isEmpty()) {
			r = q.remove();

			boolean isTrue = false;
			for (int i = 0; i < 4; i++) {
				if (isTrue == false) {
					switch (r.d) {
					case 0:
						r.d = 3;
						if (check[r.x][r.y - 1] == false && map[r.x][r.y - 1] != 1 && r.y > 0) {
							isTrue = true;
							q.add(new Robot(r.x, r.y - 1, r.d));
							check[r.x][r.y - 1] = true;
						}
						break;

					case 1:
						r.d = 0;
						if (check[r.x - 1][r.y] == false && map[r.x - 1][r.y] != 1 && r.x > 0) {
							isTrue = true;
							q.add(new Robot(r.x - 1, r.y, r.d));
							check[r.x - 1][r.y] = true;
						}
						break;

					case 2:
						r.d = 1;
						if (check[r.x][r.y + 1] == false && map[r.x][r.y + 1] != 1 && r.y < M) {
							isTrue = true;
							q.add(new Robot(r.x, r.y + 1, r.d));
							check[r.x][r.y + 1] = true;
						}
						break;

					case 3:
						r.d = 2;
						if (check[r.x + 1][r.y] == false && map[r.x + 1][r.y] != 1 && r.x < N) {
							isTrue = true;
							q.add(new Robot(r.x + 1, r.y, r.d));
							check[r.x + 1][r.y] = true;
						}
						break;
					}
				}
			}

			if (isTrue == false) {
				switch (r.d) {
				case 0:
					while (r.y != M) {
						if (check[r.x][r.y + 1] == false && map[r.x][r.y + 1] != 1 && r.y < M) {
							isTrue = true;
							q.add(new Robot(r.x, r.y + 1, r.d));
							break;
						}
					}
					break;

				case 1:
					while (r.x != N) {
						if (check[r.x + 1][r.y] == false && map[r.x + 1][r.y] != 1 && r.x < N) {
							isTrue = true;
							q.add(new Robot(r.x + 1, r.y, r.d));
							break;
						}
					}
					break;

				case 2:
					while (r.y != 0) {
						if (check[r.x][r.y - 1] == false && map[r.x][r.y - 1] != 1 && r.y > 0) {
							isTrue = true;
							q.add(new Robot(r.x, r.y - 1, r.d));
							break;
						}
					}
					break;

				case 3:
					while (r.x != 0) {
						if (check[r.x - 1][r.y] == false && map[r.x - 1][r.y] != 1 && r.x > 0) {
							isTrue = true;
							q.add(new Robot(r.x - 1, r.y, r.d));
							break;
						}
					}
					break;
				}
			}

			if (isTrue == false) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						if (check[i][j] == true) {
							cnt++;
						}
					}
				}
				return cnt;
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (check[i][j] == true) {
					cnt++;
				}
			}
		}
		return cnt;
	}

	public static class Robot {
		int x, y, d; // (0,북), (1,동), (2,남), (3, 서)

		public Robot(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
}
