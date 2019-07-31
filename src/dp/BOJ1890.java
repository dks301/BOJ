package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 점프
 */
public class BOJ1890 {
	private static int N;
	private static int[][] map;
	private static long[][] d;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		d = new long[N][N];
		int jump = map[0][0];
		d[0][jump] = d[jump][0] = 1;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 1; k <= i; k++) {
					if (map[i - k][j] == k && d[i - k][j] != 0) {
						d[i][j] += d[i - k][j];
					}
				}

				for (int k = 1; k <= j; k++) {
					if (map[i][j - k] == k && d[i][j - k] != 0) {
						d[i][j] += d[i][j - k];
					}
				}
			}
		}
		
		System.out.println(d[N - 1][N - 1]);
	}
}
