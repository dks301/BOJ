package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SCPCRound2_4 {
	private static StringBuilder sb;
	private static StringBuilder sb2;

	private static final String CASE = "Case #";
	private static final char NEW_LINE = '\n';
	private static final char SPACE = ' ';

	private static boolean[][] map;
	private static int M, N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb = new StringBuilder();
			sb.append(CASE).append(t).append(NEW_LINE);

			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			map = new boolean[M + 1][N + 1];
			for (int i = 1; i <= M; i++) {
				char[] in = br.readLine().toCharArray();
				for (int j = 1; j <= N; j++) {
					if (in[j - 1] == '1') {
						map[i][j] = true;
					}
				}
			}
			sb2 = new StringBuilder();

			sb.append(solve());
			System.out.println(sb);
			System.out.print(sb2);
		}

	}

	public static int check(int row, int col) {
		int cnt = 0;
		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {
				if (row + i > M || col + j > N) {
					continue;
				}
				if (map[row + i][col + j]) {
					cnt++;
				}
			}
		}
		return cnt;
	}

	public static void delete(int row, int col) {
		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {
				if (row + i > M || col + j > N) {
					continue;
				}
				if (map[row + i][col + j]) {
					map[row + i][col + j] = false;
				}
			}
		}
	}

	public static int solve() {
		int cnt = 0;
		for (int i = 1; i <= M; i++) {
			for (int j = 1; j <= N; j++) {
				if (map[i][j]) {
					int max = 0;
					int maxRow = i, maxCol = j;
					for (int l = -1; l <= 1; l++) {
						int row = i;
						int col = j + l;
						int val = check(row, col);
						if (val > max) {
							max = val;
							maxRow = row;
							maxCol = col;
						}
					}

					delete(maxRow, maxCol);
					sb2.append(maxRow).append(SPACE).append(maxCol).append(NEW_LINE);
					cnt++;
				}
			}
		}
		return cnt;
	}
}
