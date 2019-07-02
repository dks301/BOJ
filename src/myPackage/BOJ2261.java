package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 2차원 평면상에 n개의 점이 주어진다
 * 
 * 입력
 * 첫째줄: 자연수n(2<=n<=100,000)
 * 다음 n개줄: 각 점의 x, y좌표(|x&y|<10000, 같은 점이 여러개 가능)
 * 어렵당
 * 출력
 * 가장 가까운 두 점의 거리의 제곱을 출력
 */
public class BOJ2261 {
	private static boolean[][] map;
	private static double ans = Double.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new boolean[20000][20000];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			if (map[x][y]) {
				ans = 0;
			} else {
				map[x][y] = true;
			}
		}
		
		if (ans == 0) {
			System.out.println(0);
		} else {
			solve(0, 0, 20000);
			System.out.println(ans);	
		}
		
	}

	public static int count(int x, int y, int n) {
		int cnt = 0;
		for (int i = x; i < x + n; i++) {
			for (int j = y; j < y + n; j++) {
				if (map[i][j]) {
					cnt++;
				}
			}
		}
		return cnt;
	}

	public static void solve(int x, int y, int n) {
		if (n == 1) {
			return;
		}

		int cnt = count(x, y, n);
		if (cnt < 2) {
			return;
		} else if (cnt == 2) {
			boolean isFirst = true;
			int x1, x2, y1, y2;
			x1 = y1 = 0;
			x2 = y2 = 20000;

			for (int i = x; i < x + n; i++) {
				for (int j = y; j < y + n; j++) {
					if (isFirst && map[i][j]) {
						x1 = i;
						y1 = j;
						isFirst = false;
					} else if (!isFirst && map[i][j]) {
						x2 = i;
						y2 = j;
					}
				}
			}

			double distance = Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2);
			if (distance < ans) {
				ans = distance;
			}
		} else {
			int mid = n / 2;

			for (int i = x; i < x + n; i += mid) {
				for (int j = y; j < y + n; j += mid) {
					solve(i, j, mid);
				}
			}
		}
	}
	
	public static class Node implements Comparable<Node>{
		int x, y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public int compareTo(Node that) {
			if (this.x < that.x) {
				return -1;
			} else if (this.x == that.x) {
				if (this.y < that.y) {
					return -1;
				} else if (this.y == that.y) {
					ans = 0;
					return 0;
				} else {
					return 1;
				}
			} else {
				return 1;
			}
		}
	}
}
