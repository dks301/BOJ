package realization;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ1652 {
	private static int N;
	private static boolean[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				if (temp[j] == 'X') {
					map[i][j] = true;
				}
			}
		}

		int[] cnt = new int[2];
		for (int i = 0; i < N; i++) {
			cnt[0] += toRight(i);
			cnt[1] += toBottom(i);
		}

		System.out.println(cnt[0] + " " + cnt[1]);
	}

	public static int toRight(int row) {
		int cnt = 0;
		int result = 0;
		for (int j = 0; j < N; j++) {
			if (map[row][j] != true) {
				cnt++;
			} else {
				if (cnt >= 2) {
					result++;
				}
				cnt = 0;
			}
		}
		
		if (cnt >= 2) {
			result++;
		}
		
		return result;
	}

	public static int toBottom(int col) {
		int cnt = 0;
		int result = 0;
		for (int i = 0; i < N; i++) {
			if (map[i][col] != true) {
				cnt++;
			} else {
				if (cnt >= 2) {
					result++;
				}
				cnt = 0;
			}
		}
		
		if (cnt >= 2) {
			result++;
		}
		
		return result;
	}
}
