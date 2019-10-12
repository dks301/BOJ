package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ17472 {
	private static int N, M, ans;
	private static int[][] map;
	private static Bridge[] bridges;

	private static final int[][] DIRECTIONS = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	private static final int ROW = 0;
	private static final int COL = 1;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int island_cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					bfs(new Node(i, j), island_cnt + 3);
					island_cnt++;
				}
			}
		}

		int[] island = new int[island_cnt];
		for (int i = 0; i < island_cnt; i++) {
			island[i] = i;
		}
		
		bridges = new Bridge[island_cnt];
		for (int i = 0; i < island_cnt; i++) {
			bridges[i] = new Bridge(island_cnt);
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
		ans = Integer.MAX_VALUE;
		permutation(island, 0, island_cnt, island_cnt);
		
		int bridges_cnt = 0;
		for (int i = 0; i < island_cnt; i++) {
			for (int j = 0; j < island_cnt; j++) {
				if (bridges[i].island[j] != 100) {
					bridges_cnt++;
				}
			}
		}
		System.out.println(bridges_cnt);
		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
	}

	public static int makeBridge(Node x, int d, int to) {
		int len = 1;
		while (true) {
			int nextRow = x.row + DIRECTIONS[d][ROW];
			int nextCol = x.col + DIRECTIONS[d][COL];
			if (nextRow < 0 || nextRow > N - 1 || nextCol < 0 || nextCol > M - 1) {
				return -1;
			}
			
			if (map[nextRow][nextCol] == 0) {
				x.row = nextRow;
				x.col = nextCol;
				len++;
			} else {
				if (map[nextRow][nextCol] != to) {
					return -2;
				} else { // map[nextRow][nextCol] == to
					return len;
				}
			}
		}
	}

	public static int go(int from, int to) {
		int len = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == from) {
					for (int d = 0; d < 4; d++) {
						int nextRow = i + DIRECTIONS[d][ROW];
						int nextCol = j + DIRECTIONS[d][COL];
						if (nextRow < 0 || nextRow > N - 1 || nextCol < 0 || nextCol > M - 1) {
							continue;
						}

						if (map[nextRow][nextCol] == 0) {
							int temp = makeBridge(new Node(nextRow, nextCol), d, to);
							if (temp < 2) {
								continue;
							} else {
								if (bridges[from - 3].island[to - 3] > temp) {
									bridges[from - 3].island[to - 3] = temp;
								}
								if (temp < len) {
									len = temp;
								}
							}
						}

					}
				}
			}
		}
		
		return len;
	}

	public static void permutation(int[] arr, int depth, int n, int k) {
		if (depth == k) {
			int total = 0;

			for (int i = 0; i < arr.length - 1; i++) {
				int len = go(arr[i] + 3, arr[i + 1] + 3);
				if (len == Integer.MAX_VALUE) {
					return;
				} else {
					total += len;
				}
			}

			if (total < ans) {
				for (int i = 0; i < arr.length; i++) {
					System.out.print((arr[i] + 3) + " ");
				}
				System.out.println();
				System.out.println(total);
				ans = total;
			}

			return;
		}

		for (int i = depth; i < n; i++) {
			swap(arr, i, depth);
			permutation(arr, depth + 1, n, k);
			swap(arr, i, depth);
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void bfs(Node n, int idx) {
		Queue<Node> q = new LinkedList<>();
		q.add(n);
		map[n.row][n.col] = idx;

		while (!q.isEmpty()) {
			n = q.remove();

			for (final int[] DIRECTION : DIRECTIONS) {
				int nextRow = n.row + DIRECTION[ROW];
				int nextCol = n.col + DIRECTION[COL];
				if (nextRow < 0 || nextCol < 0 || nextRow > N - 1 || nextCol > M - 1) {
					continue;
				}

				if (map[nextRow][nextCol] == 1) {
					q.add(new Node(nextRow, nextCol));
					map[nextRow][nextCol] = idx;
				}
			}
		}
	}
	
	public static class Bridge {
		int[] island;
		
		public Bridge(int nums) {
			island = new int[nums];
			for (int i = 0; i < nums; i++) {
				island[i] = 100;
			}
		}
	}
	
	public static class Node {
		int row, col;

		public Node(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
}
