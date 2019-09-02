package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA2112 {
	private static int D, W, K, ans;
	private static boolean p;
	private static int[][] film;

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
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			film = new int[D][W];
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					film[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			ans = 0;
			if (K != 1) {
				p = isPass(film);
				while (true) {
					if (p) {
						break;
					}
					ans++;
					if (ans == D) {
						break;
					}
					combination(new int[ans], 0, D, ans, 0);
				}
			}
			sb.append(ans).append(NEW_LINE);
		}

		System.out.print(sb);
	}

	public static int[][] injection(int[][] f, int type, int row) {
		for (int j = 0; j < W; j++) {
			f[row][j] = type;
		}
		return f;
	}

	public static void go(int[][] f, int[] arr, int depth) {
		if (depth == arr.length) {
			if (isPass(f)) {
				p = true;
			}
			return;
		}
		if (p) {
			return;
		}
		int[][] result = deepCopy(f);
		go(injection(result, 0, arr[depth]), arr, depth + 1);
		go(injection(result, 1, arr[depth]), arr, depth + 1);
	}

	public static void combination(int[] arr, int index, int n, int r, int target) {
		if (p) {
			return;
		}
		if (r == 0) {
			if (!p) {
				go(film, arr, 0);
			}
			// for (int i = 0; i < arr.length; i++) {
			// System.out.print(arr[i] + " ");
			// }
			// System.out.println();
		} else if (target == n) {
			return;
		} else {
			arr[index] = target;
			combination(arr, index + 1, n, r - 1, target + 1);
			combination(arr, index, n, r, target + 1);
		}
	}

	public static boolean isPass(int[][] m) {
		for (int j = 0; j < W; j++) {
			int cnt = 1;
			boolean p = false;
			for (int i = 1; i < D; i++) {
				if (m[i - 1][j] == m[i][j]) {
					cnt++;
					if (cnt >= K) {
						p = true;
						break;
					}
				} else {
					cnt = 1;
				}
			}
			if (!p) {
				return false;
			}

		}
		return true;
	}

	public static int[][] deepCopy(int[][] m) {
		int[][] arr = new int[D][W];
		for (int i = 0; i < D; i++) {
			for (int j = 0; j < W; j++) {
				arr[i][j] = m[i][j];
			}
		}
		return arr;
	}
}
