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
		d[0][0] = 1;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0) {
					continue;
				}
				
				if (j + map[i][j] < N) {
					d[i][j + map[i][j]] += d[i][j];
				}
				
				if (i + map[i][j] < N) {
					d[i + map[i][j]][j] += d[i][j];
				}
			}
		}
		
		System.out.println(d[N - 1][N - 1]);
	}
}
