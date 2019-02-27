package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 인구 이동
 * N x N크기의 땅에서 한 칸당 나라가 하나씩 존재, r행c열의 나라에는 A[r][c]명이 살고 있음
 * 인구 이동은 다음과 같이 진행되고, 더 이상 아래 방법에 의해 인구 이동이 없을 때까지 지속된다.
	- 국경선을 공유하는 두 나라의 인구 차이가 L명 이상, R명 이하라면, 두 나라가 공유하는 국경선을 오늘 하루동안 연다.
	- 위의 조건에 의해 열어야하는 국경선이 모두 열렸다면, 인구 이동을 시작한다.
	- 국경선이 열려있어 인접한 칸만을 이용해 이동할 수 있으면, 그 나라를 오늘 하루 동안은 연합이라고 한다.
	- 연합을 이루고 있는 각 칸의 인구수는 (연합의 인구수) / (연합을 이루고 있는 칸의 개수)가 된다. 편의상 소수점은 버린다.
	- 연합을 해체하고, 모든 국경선을 닫는다.
 * 첫째 줄에 N, L, R이 주어진다. (1 ≤ N ≤ 50, 1 ≤ L ≤ R ≤ 100)
 * 둘째 줄부터 N개의 줄에 각 나라의 인구수가 주어진다. r행 c열에 주어지는 정수는 A[r][c]의 값이다. (1 ≤ A[r][c] ≤ 100)
 * 인구 이동이 발생하는 횟수가 2,000번 보다 작거나 같은 입력만 주어진다.
 * 인구 이동이 몇 번 발생하는지 출력
 */
public class BOJ16234 {
	private static int N, L, R;
	private static int[][] A;
	private static boolean[][] check;

	private static final int[][] DIRECTIONS = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	private static final int ROW = 0;
	private static final int COL = 1;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		A = new int[N + 2][N + 2];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int ans = 0;
		while (true) {
			int cnt = 0;
			check = new boolean[N + 2][N + 2];
			
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (check[i][j] == false) {
						ArrayList<State> al = makeStates(i, j);
						int total = 0;
						for (int k = 0; k < al.size(); k++) {
							total += A[al.get(k).x][al.get(k).y];
						}

						int result = total / al.size();
						for (int k = 0; k < al.size(); k++) {
							A[al.get(k).x][al.get(k).y] = result;
						}
						cnt++;
					}
				}
			}
			
			if (cnt == N * N) {
				break;
			}
			ans++;
		}
		System.out.println(ans);
	}

	public static ArrayList<State> makeStates(int x, int y) {
		Queue<State> q = new LinkedList<>();
		ArrayList<State> al = new ArrayList<>();
		q.add(new State(x, y));
		check[x][y] = true;

		while (!q.isEmpty()) {
			State next = q.remove();
			al.add(next);

			for (final int[] DIRECTION : DIRECTIONS) {
				int nextRow = next.x + DIRECTION[ROW];
				int nextCol = next.y + DIRECTION[COL];

				int diff = Math.abs(A[nextRow][nextCol] - A[next.x][next.y]);
				if (diff >= L && diff <= R && check[nextRow][nextCol] == false && A[nextRow][nextCol] != 0) {
					q.add(new State(nextRow, nextCol));
					check[nextRow][nextCol] = true;
				}
			}
		}

		return al;
	}

	public static class State {
		int x, y;

		public State(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
