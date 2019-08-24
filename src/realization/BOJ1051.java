package realization;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1051 {
	private static int N, M;
	private static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = temp[j] - '0';
			}
		}

		int K = Math.min(N, M);
		boolean isEnd = false;
		for (int k = K; k >= 1; k--) {
			for (int i = 0; i <= N - k; i++) {
				for (int j = 0; j <= M - k; j++) {
					if (isSquare(k, i, j)) {
						K = k * k;
						isEnd = true;
					}

					if (isEnd) {
						break;
					}
				}
				if (isEnd) {
					break;
				}
			}
			if (isEnd) {
				break;
			}
		}
		System.out.println(K);
	}

	public static boolean isSquare(int size, int i, int j) {
		int row = i + size - 1;
		int col = j + size - 1;
		if (row > N - 1 || col > M - 1) {
			return false;
		}

		if (map[i][j] == map[row][j] && map[i][j] == map[i][col] && map[i][col] == map[row][col]) {
			return true;
		} else {
			return false;
		}
	}
}
