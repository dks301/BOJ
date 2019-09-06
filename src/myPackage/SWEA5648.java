package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA5648 {
	private static int N, ans;
	private static LinkedList<Node> ll;
	private static int[][] map;

	private static final int[][] DIRECTIONS = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
	private static final int X = 0;
	private static final int Y = 1;

	private static final char NUMBER = '#';
	private static final char SPACE = ' ';
	private static final char NEW_LINE = '\n';

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= T; t++) {
			sb.append(NUMBER).append(t).append(SPACE);
			N = Integer.parseInt(br.readLine());
			ll = new LinkedList<>();
			map = new int[4001][4001];
			for (int i = 0; i < 4001; i++) {
				Arrays.fill(map[i], 0);
			}

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = 2 * (Integer.parseInt(st.nextToken()) + 1000);
				int y = 2 * (Integer.parseInt(st.nextToken()) + 1000);
				int d = Integer.parseInt(st.nextToken());
				int K = Integer.parseInt(st.nextToken());

				map[x][y] = K;
				ll.add(new Node(x, y, d, K));
			}

			ans = 0;
			bfs();
			sb.append(ans).append(NEW_LINE);
			Runtime.getRuntime().gc();
		}
		System.out.print(sb);
	}

	public static void bfs() {
		Queue<Node> q = ll;

		while (q.size() > 1) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Node n = q.remove();

				int nextX = n.x + DIRECTIONS[n.d][X];
				int nextY = n.y + DIRECTIONS[n.d][Y];
				if (nextX < 0 || nextY < 0 || nextX > 4000 || nextY > 4000) {
					map[n.x][n.y] -= n.K;
					continue;
				}

				map[nextX][nextY] += n.K;
				q.add(new Node(nextX, nextY, n.d, n.K));
				map[n.x][n.y] -= n.K;
			}
			
			size = q.size();
			for (int i = 0; i < size; i++) {
				Node n = q.remove();
				
				if (map[n.x][n.y] == 0) {
					continue;
				} else if (map[n.x][n.y] != n.K) {
					ans += map[n.x][n.y];
					map[n.x][n.y] = 0;
				} else {
					q.add(n);
				}
			}
		}
		
		q.clear();
	}

	public static class Node {
		int x, y;
		int d, K;

		public Node(int x, int y, int d, int K) {
			this.x = x;
			this.y = y;
			this.d = d;
			this.K = K;
		}
	}
}
