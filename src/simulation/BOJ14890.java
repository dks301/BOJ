package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 경사로
 * 크기 NxN, 경사로는 높이가 항상 1, 길이는 L
 * 지도가 주어졌을 때, 지나갈 수 있는 길의 개수를 출력
 * 
 * 첫째줄: N(2<=N<=100), L(1<=L<=N)
 * 둘째줄~N개줄: 지도, 각 칸의 높이는 10보다 작거나 같은 자연수
 */
public class BOJ14890 {
	private static int[][] map;
	private static int N;
	private static int L;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());

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
		int[] arr = new int[N];
		System.arraycopy(map[i], 0, arr, 0, N);

		boolean[] isIncline = new boolean[N];

		for (int j = 0; j < N - 1; j++) {
			if (arr[j] == arr[j + 1]) {
				continue;
			}

			if (j + L < N && arr[j] - arr[j + 1] == 1) {
				int temp = arr[j + 1];
				isIncline[j + 1] = true;

				for (int k = j + 2; k <= j + L; k++) {
					if (temp != arr[k]) {
						return false;
					}
					isIncline[k] = true;
				}

			} else if (j - L + 1 >= 0 && arr[j] - arr[j + 1] == -1 && !isIncline[j]) {
				int temp = arr[j];
				isIncline[j] = true;

				for (int k = j - 1; k >= j - L + 1; k--) {
					if (temp != arr[k] || isIncline[k]) {
						return false;
					}
					isIncline[k] = true;
				}

			} else {
				return false;
			}
		}

		return true;
	}

	public static boolean down(int j) {
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = map[i][j];
		}

		boolean[] isIncline = new boolean[N];

		for (int i = 0; i < N - 1; i++) {
			if (arr[i] == arr[i + 1]) {
				continue;
			}

			if (i + L < N && arr[i] - arr[i + 1] == 1) {
				int temp = arr[i + 1];
				isIncline[i + 1] = true;

				for (int k = i + 2; k <= i + L; k++) {
					if (temp != arr[k]) {
						return false;
					}
					isIncline[k] = true;
				}

			} else if (i - L + 1 >= 0 && arr[i] - arr[i + 1] == -1 && !isIncline[i]) {
				int temp = arr[i];
				isIncline[i] = true;

				for (int k = i - 1; k >= i - L + 1; k--) {
					if (temp != arr[k] || isIncline[k]) {
						return false;
					}
					isIncline[k] = true;
				}

			} else {
				return false;
			}
		}

		return true;
	}
}
