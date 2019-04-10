package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 감시
 * 사무실은 NxM 크기의 직사각형, K개의 CCTV가 설치
 * CCTV는 90도 방향으로 회전이 가능 
 * 지도에서 0은 빈 칸, 6은 벽, 1~5는 CCTV의 번호, 감시영역은 '#'
 * 1번 카메라: 동서남북 중 한방향
 * 2번 카메라: 동서 or 남북
 * 3번 카메라: 남서 or 남동 or 북서 or 북동
 * 4번 카메라: 동서남 or 서남북 or 남북동 or 북동서
 * 5번 카메라: 동서남북
 * 사각 지대의 최소 크기 출력
 * 
 * 첫쨰줄: 사무실 세로N, 가로M(1<=N,M<=8)
 * 둘째줄~N개줄: 사무실정보(CCTV는 최대 8개)
 */
public class BOJ15683 {
	private static int N, M;
	private static int[][] map;
	private static int blank = 0;
	private static int min = Integer.MAX_VALUE;
	private static ArrayList<CCTV> cam = new ArrayList<>();

	private static final int[][] DIRECTIONS = { { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 0 } };
	private static final int ROW = 0;
	private static final int COL = 1;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				switch (map[i][j]) {
				case 0:
					blank++;
					break;

				case 1:
					cam.add(new CCTV(i, j, new boolean[] { true, false, false, false }));
					cam.add(new CCTV(i, j, new boolean[] { false, true, false, false }));
					cam.add(new CCTV(i, j, new boolean[] { false, false, true, false }));
					cam.add(new CCTV(i, j, new boolean[] { false, false, false, true }));
					break;

				case 2:
					cam.add(new CCTV(i, j, new boolean[] { true, false, true, false }));
					cam.add(new CCTV(i, j, new boolean[] { true, false, true, false }));
					cam.add(new CCTV(i, j, new boolean[] { false, true, false, true }));
					cam.add(new CCTV(i, j, new boolean[] { false, true, false, true }));
					break;

				case 3:
					cam.add(new CCTV(i, j, new boolean[] { true, true, false, false }));
					cam.add(new CCTV(i, j, new boolean[] { false, true, true, false }));
					cam.add(new CCTV(i, j, new boolean[] { false, false, true, true }));
					cam.add(new CCTV(i, j, new boolean[] { true, false, false, true }));
					break;

				case 4:
					cam.add(new CCTV(i, j, new boolean[] { true, true, true, false }));
					cam.add(new CCTV(i, j, new boolean[] { false, true, true, true }));
					cam.add(new CCTV(i, j, new boolean[] { true, false, true, true }));
					cam.add(new CCTV(i, j, new boolean[] { true, true, false, true }));
					break;

				case 5:
					cam.add(new CCTV(i, j, new boolean[] { true, true, true, true }));
					cam.add(new CCTV(i, j, new boolean[] { true, true, true, true }));
					cam.add(new CCTV(i, j, new boolean[] { true, true, true, true }));
					cam.add(new CCTV(i, j, new boolean[] { true, true, true, true }));
					break;
				}
			}
		}

		if (cam.isEmpty()) {
			System.out.println(blank);
		} else {
			combination(new int[cam.size() / 4], 0, cam.size(), cam.size() / 4, 0);
			System.out.println(min);
		}
	}

	public static int watch(int[] arr) {
		Queue<CCTV> q = new LinkedList<>();
		CCTV x;
		for (int i = 0; i < arr.length; i++) {
			x = cam.get(arr[i]);
			q.add(x);
		}
		int[][] map = deepCopy();
		int cnt = 0;

		while (!q.isEmpty()) {
			x = q.remove();

			for (int i = 0; i < 4; i++) {
				if (x.direct[i]) {
					int nextRow = x.x + DIRECTIONS[i][ROW];
					int nextCol = x.y + DIRECTIONS[i][COL];
					if (nextRow < 0 || nextRow > N - 1 || nextCol < 0 || nextCol > M - 1) {
						continue;
					}

					if (map[nextRow][nextCol] != 6) {
						if (map[nextRow][nextCol] == 0) {
							map[nextRow][nextCol] = -1;
							cnt++;
						}
						boolean[] direction = new boolean[4];
						direction[i] = true;
						q.add(new CCTV(nextRow, nextCol, direction));
					}
				}
			}
		}

		return cnt;
	}

	public static int[][] deepCopy() {
		int[][] temp = new int[N][M];
		for (int i = 0; i < N; i++) {
			System.arraycopy(map[i], 0, temp[i], 0, M);
		}
		return temp;
	}

	public static void combination(int[] arr, int index, int n, int r, int target) {
		if (r == 0) {
			boolean isTrue = false;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] >= (i * 4) && arr[i] <= (i * 4) + 3) {
					isTrue = true;
				} else {
					isTrue = false;
					break;
				}
			}
			if (isTrue) {
				int val = blank - watch(arr);
				if (val < min) {
					min = val;
				}
			}

		} else if (target == n) {
			return;
		} else {
			arr[index] = target;
			combination(arr, index + 1, n, r - 1, target + 1);
			combination(arr, index, n, r, target + 1);
		}
	}

	public static class CCTV {
		int x, y;
		int idx;
		boolean[] direct = new boolean[4]; // 동북서남

		public CCTV(int x, int y, boolean[] direct) {
			this.x = x;
			this.y = y;
			this.idx = map[x][y];
			this.direct = direct;
		}
	}
}
