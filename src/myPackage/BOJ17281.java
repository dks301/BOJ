package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ17281 {
	private static int N, ans, nextPlayer;
	private static int[][] playerInfo;
	private static ArrayList<Inning>[] al;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		playerInfo = new int[N][9];
		ans = 0;

		int[] arr = new int[9];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				playerInfo[i][j] = Integer.parseInt(st.nextToken());
				arr[j] = j;
			}
		}
		permutation(arr, 0, 9, 9);

		System.out.println(ans);
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void permutation(int[] arr, int depth, int n, int k) {
		if (depth == k) {
			// 여기서 뭐 하면됨
			if (arr[3] != 0) {
				return;
			} else {
				int score = 0;
				for (int i = 0; i < arr.length; i++) {
					System.out.print(arr[i] + " ");
				}
				System.out.println();
				
				nextPlayer = 0;
				for (int i = 0; i < N; i++) {
					Inning in = new Inning();
					nextPlayer = in.go(arr, i, nextPlayer);
					score += in.score;
				}
				if (score > ans) {
					ans = score;
				}
			}
			return;
		}

		for (int i = depth; i < n; i++) {
			swap(arr, i, depth);
			permutation(arr, depth + 1, n, k);
			swap(arr, i, depth);
		}
	}

	public static class Inning {
		int outCount, score;
		boolean[] base;

		public Inning() {
			outCount = 0;
			score = 0;
			base = new boolean[4];
		}

		public int go(int[] arr, int i, int idx) {
			int nextPlayer = idx;
			while (nextPlayer != -1) {
				switch (playerInfo[i][arr[nextPlayer]]) {
				case 0:
					outCount++;
					if (outCount == 3) {
						nextPlayer++;
						if (nextPlayer > 8) {
							nextPlayer = 0;
						}
						return nextPlayer;
					}
					break;

				case 1:
					hit();
					nextPlayer++;
					if (nextPlayer > 8) {
						nextPlayer = 0;
					}
					break;

				case 2:
					doubleHit();
					nextPlayer++;
					if (nextPlayer > 8) {
						nextPlayer = 0;
					}
					break;

				case 3:
					tripleHit();
					nextPlayer++;
					if (nextPlayer > 8) {
						nextPlayer = 0;
					}
					break;

				case 4:
					System.out.println("??asdfasdf");
					homerun();
					nextPlayer++;
					if (nextPlayer > 8) {
						nextPlayer = 0;
					}
					break;
				}
			}
			return -1; // error
		}

		public void hit() {
			for (int i = 3; i >= 1; i--) {
				if (base[i]) {
					if (i == 3) {
						score++;
						base[i] = false;
					} else {
						base[i + 1] = true;
						base[i] = false;
					}
				}
			}
			base[1] = true;
		}

		public void doubleHit() {
			for (int i = 3; i >= 1; i--) {
				if (base[i]) {
					if (i == 3 || i == 2) {
						score++;
						base[i] = false;
					} else {
						base[i + 2] = true;
						base[i] = false;
					}
				}
			}
			base[2] = true;
		}

		public void tripleHit() {
			for (int i = 3; i >= 1; i--) {
				if (base[i]) {
					score++;
					base[i] = false;
				}
			}
			base[3] = true;
		}

		public void homerun() {
			for (int i = 3; i >= 1; i--) {
				if (base[i]) {
					score++;
					base[i] = false;
				}
			}
			score++;
		}
	}
}
