package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16236_2 {
	private static int N;
	private static int[][] map;
	private static int[][] check;
	private static PriorityQueue<Fish> possible;
	
	private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
	private static final int ROW = 0;
	private static final int COL = 1;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		Fish shark = null;
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					shark = new Fish(i, j, 2);
					map[i][j] = 0;
				}
			}
		}
		
		int ans = 0;
		while (true) {
			possible = new PriorityQueue<>();
			bfs(shark);
			if (possible.isEmpty()) {
				break;
			}
			
			Fish f = possible.remove();
		
			map[f.row][f.col] = 0;
			shark.row = f.row;
			shark.col = f.col;
			shark.eat();
			ans += f.d;
		}
		
		System.out.println(ans);
	}
	
	public static void combination(int[] arr, int index, int n, int r, int target) {
		if (r == 0) {
			// do something
			
		} else if (target == n) {
			return;
		} else {
			arr[index] = target;
			combination(arr, index + 1, n, r - 1, target + 1);
			combination(arr, index, n, r, target + 1);
		}
	}
	
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void permutation(int[] arr, int depth, int n, int k) {
		if (depth == k) {
			// do something
			return;
		}
		
		for (int i = depth; i < n; i++) {
			swap(arr, i, depth);
			permutation(arr, depth + 1, n, k);
			swap(arr, i, depth);
		}
	}
	
	public static void bfs(Fish s) {
		Queue<Fish> q = new LinkedList<>();
		q.add(s);
		check = new int[N][N];
		check[s.row][s.col] = 1;
		int min = Integer.MAX_VALUE;
		
		while (!q.isEmpty()) {
			s = q.remove();
			
			for (final int[] D : DIRECTIONS) {
				int nextRow = s.row + D[ROW];
				int nextCol = s.col + D[COL];
				if (nextRow < 0 || nextRow > N - 1 || nextCol < 0 || nextCol > N - 1) {
					continue;
				}
				
				if (check[nextRow][nextCol] == 0 && map[nextRow][nextCol] <= s.size) {
					q.add(new Fish(nextRow, nextCol, s.size));
					check[nextRow][nextCol] = check[s.row][s.col] + 1;
					if (map[nextRow][nextCol] < s.size && map[nextRow][nextCol] != 0) {
						if (min > check[nextRow][nextCol]) {
							min = check[nextRow][nextCol];
						}
					}
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (check[i][j] == min && map[i][j] != 0 && map[i][j] < s.size) {
					Fish temp = new Fish(i, j, map[i][j]);
					temp.d = min - 1;
					possible.add(temp);
				}
			}
		}
	}
	
	
	public static class Fish implements Comparable<Fish> {
		int row, col;
		int size, d;
		int cnt;
		
		public Fish (int row, int col, int size) {
			this.row = row;
			this.col = col;
			this.size = size;
			this.d = Integer.MAX_VALUE;
			this.cnt = 0;
		}
		
		public void eat() {
			cnt++;
			if(size == cnt) {
				size++;
				cnt = 0;
			}
		}
		
		@Override
		public int compareTo(Fish that) {
			// TODO Auto-generated method stub
			if (this.d < that.d) {
				return -1;
			} else if (this.d == that.d) {
				if (this.row < that.row) {
					return -1;
				} else if (this.row == that.row) {
					if (this.col < that.col) {
						return -1;
					} else if (this.col == that.col) {
						return 0;
					} else {
						return 1;
					}
				} else {
					return 1;
				}
			} else {
				return 1;
			}
		}
	}
}
