package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17070 {
	private static int N;
	private static boolean[][] map;
	private static int[][][] d;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new boolean[N + 1][N + 1];
		d = new int[N + 1][N + 1][3];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				for (int k = 0; k < 3; k++) {
					d[i][j][k] = -1;
				}
			}
		}
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = (Integer.parseInt(st.nextToken()) == 0 ? false : true);
			}
		}

		Pipe p = new Pipe(new Node(1, 2), 0);

		System.out.println(go(p));
	}

	public static int go(Pipe p) {
		Node right = p.right;
		if (right.x == N && right.y == N) {
			return 1;
		}

		if (right.x > N || right.y > N) {
			return 0;
		}

		if (p.d == 0 && d[right.x][right.y][0] != -1) {
			return d[right.x][right.y][0];

		} else if (p.d == 1 && d[right.x][right.y][1] != -1) {
			return d[right.x][right.y][1];

		} else if (p.d == 2 && d[right.x][right.y][2] != -1) {
			return d[right.x][right.y][2];
		}

		d[right.x][right.y][p.d] = 0;

		if (p.d == 0) {
			if (right.y + 1 <= N && !map[right.x][right.y + 1]) {
				d[right.x][right.y][p.d] += go(new Pipe(new Node(right.x, right.y + 1), 0));
			}
			if (right.x + 1 <= N && right.y + 1 <= N && !map[right.x][right.y + 1] && !map[right.x + 1][right.y]
					&& !map[right.x + 1][right.y + 1]) {
				d[right.x][right.y][p.d] += go(new Pipe(new Node(right.x + 1, right.y + 1), 2));
			}

		} else if (p.d == 1) {
			if (right.x + 1 <= N && !map[right.x + 1][right.y]) {
				d[right.x][right.y][p.d] += go(new Pipe(new Node(right.x + 1, right.y), 1));
			}
			if (right.x + 1 <= N && right.y + 1 <= N && !map[right.x][right.y + 1] && !map[right.x + 1][right.y]
					&& !map[right.x + 1][right.y + 1]) {
				d[right.x][right.y][p.d] += go(new Pipe(new Node(right.x + 1, right.y + 1), 2));
			}

		} else {
			if (right.y + 1 <= N && !map[right.x][right.y + 1]) {
				d[right.x][right.y][p.d] += go(new Pipe(new Node(right.x, right.y + 1), 0));
			}
			if (right.x + 1 <= N && !map[right.x + 1][right.y]) {
				d[right.x][right.y][p.d] += go(new Pipe(new Node(right.x + 1, right.y), 1));
			}
			if (right.x + 1 <= N && right.y + 1 <= N && !map[right.x][right.y + 1] && !map[right.x + 1][right.y]
					&& !map[right.x + 1][right.y + 1]) {
				d[right.x][right.y][p.d] += go(new Pipe(new Node(right.x + 1, right.y + 1), 2));
			}
		}

		return d[right.x][right.y][p.d];
	}

	public static class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static class Pipe {
		Node right;
		int d; // 현재방향(0:가로, 1:세로, 2: 대각)

		public Pipe(Node right, int d) {
			this.right = right;
			this.d = d;
		}
	}
}
