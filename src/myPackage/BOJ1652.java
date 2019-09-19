package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
8
XX..XX..
..XX..XX
XX..XX..
..XX..XX
XX..XX..
..XX..XX
XX..XX..
..XX..XX

누울 수 있는 자리는 16개 수정필요
 */
public class BOJ1652 {
	private static int N;
	private static boolean[][] map;
	private static boolean[] isPossible;

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
			isPossible = new boolean[2];
			toRight(new Node(i, 0), 0);
			toBottom(new Node(0, i), 0);
			cnt[0] = isPossible[0] ? cnt[0] + 1 : cnt[0];
			cnt[1] = isPossible[1] ? cnt[1] + 1 : cnt[1];
			//System.out.println(cnt[0] + " " + cnt[1]);
		}

		System.out.println(cnt[0] + " " + cnt[1]);
	}

	public static void toRight(Node s, int d) {
		if (isPossible[0]) {
			return;
		}
		if (map[s.row][s.col]) {
			d = 0;
		} else {
			d = d + 1;
		}
		
		if (d >= 2) {
			isPossible[0] = true;
			return;
		}

		int nextRow = s.row;
		int nextCol = s.col + 1;
		if (nextCol > N - 1) {
			return;
		}
		
		toRight(new Node(nextRow, nextCol), d);
	}

	public static void toBottom(Node s, int d) {
		if (isPossible[1]) {
			return;
		}
		
		if (map[s.row][s.col]) {
			d = 0;
		} else {
			d = d + 1;
		}
		
		if (d >= 2) {
			isPossible[1] = true;
			return;
		}
		int nextRow = s.row + 1;
		int nextCol = s.col;
		if (nextRow > N - 1) {
			return;
		}

		if (map[s.row][s.col]) {
			d = 0;
		} else {
			d = d + 1;
		}
		
		toBottom(new Node(nextRow, nextCol), d);
	}

	public static class Node {
		int row, col;

		public Node(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
}
