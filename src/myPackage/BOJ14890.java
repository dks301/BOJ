package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14890 {
	private static int[][] map;
	private static int N;
	private static int X;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			cnt = right(i) ? cnt + 1 : cnt;
			cnt = down(i) ? cnt + 1 : cnt;
		}
		System.out.println(cnt);
	}

	public static boolean right(int i) {
		int cnt = 0;
		boolean[] isIncline = new boolean[N];

		for (int j = 0; j < N - 1; j++) {
			if (map[i][j] == map[i][j + 1]) {
				cnt++;
			} else if ((map[i][j] - map[i][j + 1]) == -1) {
				if (j + 1 < X || cnt + 1 < X) {
					return false;
				} else {
					for (int k = j; k > j - X; k--) {
						if (isIncline[k] == true) {
							return false;
						}
					}
					cnt = 0;
				}
			} else if ((map[i][j] - map[i][j + 1]) == 1) {
				if (j + X >= N) {
					return false;
				}
				for (int k = 0; k < X - 1; k++) {
					if (map[i][j + 1] != map[i][j + 2]) {
						return false;
					} else {
						isIncline[j + 1] = true;
						isIncline[j + 2] = true;
						cnt++;
						j++;
					}
				}
			} else {
				return false;
			}
		}
		return true;
	}

	public static boolean down(int j) {
		int cnt = 0;
		boolean[] isIncline = new boolean[N];

		for (int i = 0; i < N - 1; i++) {
			if (map[i][j] == map[i + 1][j]) {
				cnt++;

			} else if ((map[i][j] - map[i + 1][j]) == -1) {
				if (i + 1 < X || cnt + 1 < X) {
					return false;
				} else {
					for (int k = i; k > i - X; k--) {
						if (isIncline[k] == true) {
							return false;
						}
					}
					cnt = 0;
				}
			} else if ((map[i][j] - map[i + 1][j]) == 1) {
				if (i + X >= N) {
					return false;
				}
				for (int k = 0; k < X - 1; k++) {
					if (map[i + 1][j] != map[i + 2][j]) {
						return false;
					} else {
						isIncline[i + 1] = true;
						isIncline[i + 2] = true;
						cnt++;
						i++;
					}
				}
			} else {
				return false;
			}
		}
		return true;
	}
}
