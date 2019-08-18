package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ17070 {
	private static int N, ans;
	private static boolean[][] map;
	private static int[][] check;

	private static final int[][] DIRECTIONS = { { 0, 1 }, { 1, 0 }, { 1, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new boolean[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = (Integer.parseInt(st.nextToken()) == 0 ? false : true);
			}
		}

		Pipe p = new Pipe(1, 2, 0);
		ans = 0;
		check = new int[N + 1][N + 1];
		go(p);

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				System.out.print(check[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println(check[N][N]);
	}

	public static int go(Pipe p) {
		if (p.x == N && p.y == N) {
			return 0;
		}
		if (check[p.x][p.y] != 0) {
			return check[p.x][p.y];
		}
		
		check[p.x][p.y] = 1;

		int rightRow = p.x + DIRECTIONS[0][0];
		int rightCol = p.y + DIRECTIONS[0][1];

		int downRow = p.x + DIRECTIONS[1][0];
		int downCol = p.y + DIRECTIONS[1][1];

		int diagRow = p.x + DIRECTIONS[2][0];
		int diagCol = p.y + DIRECTIONS[2][1];

		switch (p.d) {
		case 0:
			if (rightCol <= N && downRow <= N) {
				if (!map[rightRow][rightCol]) {
					
					check[rightRow][rightCol] += check[p.x][p.y];
				}

				if (!map[rightRow][rightCol] && !map[downRow][downCol] && !map[diagRow][diagCol]) {
					check[diagRow][diagCol] += check[p.x][p.y];
				}

			} else if (rightCol <= N && downRow > N) {
				if (!map[rightRow][rightCol]) {
					check[rightRow][rightCol] += check[p.x][p.y];
				}
			}
			break;

		case 1:
			if (rightCol <= N && downRow <= N) {
				if (!map[downRow][downCol]) {
					check[downRow][downCol] += check[p.x][p.y];
				}

				if (!map[rightRow][rightCol] && !map[downRow][downCol] && !map[diagRow][diagCol]) {
					check[diagRow][diagCol] += check[p.x][p.y];
				}

			} else if (rightCol > N && downRow <= N) {
				if (!map[downRow][downCol]) {
					check[downRow][downCol] += check[p.x][p.y];
				}
			}
			break;

		case 2:
			if (rightCol <= N && downRow <= N) {
				if (!map[rightRow][rightCol]) {
					check[rightRow][rightCol] += check[p.x][p.y];
				}

				if (!map[downRow][downCol]) {
					check[downRow][downCol] += check[p.x][p.y];
				}

				if (!map[rightRow][rightCol] && !map[downRow][downCol] && !map[diagRow][diagCol]) {
					check[diagRow][diagCol] += check[p.x][p.y];
				}

			} else if (rightCol <= N && downRow > N) {
				if (!map[rightRow][rightCol]) {
					check[rightRow][rightCol] += check[p.x][p.y];
				}

			} else if (rightCol > N && downRow <= N) {
				if (!map[downRow][downCol]) {
					check[downRow][downCol] += check[p.x][p.y];
				}
			}
			break;
		}
		return 0;
	}

	public static class Pipe {
		int x, y, d; // 끝점 x, 끝점y, 현재방향(0:가로, 1:세로, 2: 대각)

		public Pipe(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
}
