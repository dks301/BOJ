package unionFind;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ17472 {
	private static int N, M, ans;
	private static int[][] map;
	private static ArrayList<Bridge> bridges;

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
				if (map[i][j] == 1) {
					map[i][j] = -1;
				}
			}
		}

		int island_cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == -1) {
					bfs(new Node(i, j), ++island_cnt);
				}
			}
		}

		int[] island = new int[island_cnt];
		for (int i = 0; i < island_cnt; i++) {
			island[i] = i;
		}
		
		bridges = new ArrayList<>();
		
		for (int i = 1; i < island_cnt; i++) {
			for (int j = i + 1; j <= island_cnt; j++) {
				go(i, j);
			}
		}
		
		ans = Integer.MAX_VALUE;
		
		combination(new int[island_cnt - 1], 0, bridges.size(), island_cnt - 1, 0);
		
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

	public static void go(int from, int to) {
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
								boolean sw = false;
								for (Bridge next : bridges) {
									if (next.from == from && next.to == to) {
										sw = true;
										if (next.len > temp) {
											next.len = temp;
										}
									}
								}
								
								if (!sw) {
									bridges.add(new Bridge(from, to, temp));
								}
							}
						}

					}
				}
			}
		}
	}
	
	public static void union(int[] p, int n1, int n2) {
		int a = find(p, n1);
		int b = find(p, n2);
		
		if (a != b) {
			p[a] = b;
		}
	}
	
	public static int find(int[] p, int node) {
		if (p[node] == node) {
			return node;
		} else {
			return p[node] = find(p, p[node]);
		}
	}
	
	public static int check(int[] arr) {
		int[] p = new int[arr.length + 1];
		for (int i = 0; i < p.length; i++) {
			p[i] = i;
		}
		
		int len = 0;
		for (int i = 0; i < arr.length; i++) {
			Bridge b = bridges.get(arr[i]);
			union(p, b.from - 1, b.to - 1);
			len += b.len;
		}
		
		int val = find(p, 0);
		for (int i = 1; i < p.length; i++) {
			if (find(p, i) != val) {
				return -1;
			}
		}
		
		return len;
	}
	
	public static void combination(int[] arr, int index, int n, int r, int target) {
		if (r == 0) {
			// do something
			int val = check(arr);
			if (val == -1) {
				return;
			} else if (val < ans){
				ans = val;
			}
			
		} else if (target == n) {
			return;
		} else {
			arr[index] = target;
			combination(arr, index + 1, n, r - 1, target + 1);
			combination(arr, index, n, r, target + 1);
		}
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

				if (map[nextRow][nextCol] == -1) {
					q.add(new Node(nextRow, nextCol));
					map[nextRow][nextCol] = idx;
				}
			}
		}
	}
	
	public static class Bridge {
		int from, to;
		int len;
		
		public Bridge(int from, int to, int len) {
			this.from = from;
			this.to = to;
			this.len = len;
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
