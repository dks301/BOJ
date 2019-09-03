package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA2117 {
	private static int N, M, ans;
	private static int[][] map;

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
			map = new int[N][N];

			int home_cnt = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1) {
						home_cnt++;
					}
				}
			}

			ans = 1;
			for (int k = 21; k >= 2; k--) {
				int cost = k * k + ((k - 1) * (k - 1));
				if (cost > home_cnt * M) {
					continue;
				}

				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						int cnt = go(k, new Node(i, j));
						if (cost <= cnt * M) {
							if (ans < cnt) {
								ans = cnt;
							}
						}
					}
				}

				if (ans != 1) {
					break;
				}
			}
			sb.append(ans).append(NEW_LINE);
		}

		System.out.print(sb);
	}

	public static int goLeft(int k, Node n) {
		if (n.col < 0 || n.col > N - 1) {
			return 0;
		}
		if (k == 0) {
			return 0;
		}

		int cnt = 0;
		for (int i = n.row - (k - 1); i <= n.row + (k - 1); i++) {
			if (i < 0 || i > N - 1) {
				continue;
			}

			if (map[i][n.col] == 1) {
				cnt++;
			}

		}

		cnt += goLeft(k - 1, new Node(n.row, n.col - 1));

		return cnt;
	}

	public static int goRight(int k, Node n) {
		if (n.col < 0 || n.col > N - 1) {
			return 0;
		}

		if (k == 0) {
			return 0;
		}

		int cnt = 0;
		for (int i = n.row - (k - 1); i <= n.row + (k - 1); i++) {
			if (i < 0 || i > N - 1) {
				continue;
			}

			if (map[i][n.col] == 1) {
				cnt++;
			}

		}

		cnt += goRight(k - 1, new Node(n.row, n.col + 1));

		return cnt;
	}

	public static int go(int k, Node n) {
		int cnt = goLeft(k, n);
		cnt += goRight(k - 1, new Node(n.row, n.col + 1));
		return cnt;
	}

	public static class Node {
		int row, col;

		public Node(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
}
