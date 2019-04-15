package bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 연구소2
 * 특정 위치에 바이러스 M개 놓기
 * 연구소는 빈칸, 벽으로 이루어짐
 * 0은 빈 칸, 1은 벽, 2는 바이러스를 놓을 수 있는 곳
 * 연구소의 상태가 주어졌을 때, 모든 빈 칸에 바이러스를 퍼뜨리는 최소 시간을 출력.
 * 
 * 첫째줄: 연구소의 크기 N(5<=N<=50), 놓을 수 있는 바이러스의 개수 M(2<=M<=10)
 * 둘째줄~N개줄: 연구소의 상태, 2의 개수는 M보다 크거나 같고, 10보다 작거나 같은 자연수
 * 바이러스를 모든 칸에 퍼뜨릴 수 없는 경우에는 -1 출력.
 */
public class BOJ17141 {
	private static int N, M, ans;
	private static int[][] map;
	private static boolean[][] check;
	private static ArrayList<Node> al;
	
	private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	private static final int ROW = 0;
	private static final int COL = 1;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		al = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					al.add(new Node(i, j));
				}
			}
		}
		
		ans = Integer.MAX_VALUE;
		combination(new int[M], 0, al.size(), M, 0);
		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
	}
	
	public static int bfs(int[] arr) {
		check = new boolean[N][N];
		Queue<Node> q = new LinkedList<>();
		for (int i = 0; i < arr.length; i++) {
			Node n = al.get(arr[i]);
			q.add(n);
			check[n.x][n.y] = true;
		}
		
		int[][] d = new int[N][N];
		
		while(!q.isEmpty()) {
			Node x = q.remove();
			
			for (final int[] DIRECTION : DIRECTIONS) {
				int nextRow = x.x + DIRECTION[ROW];
				int nextCol = x.y + DIRECTION[COL];
				if (nextRow < 0 || nextRow > N - 1 || nextCol < 0 || nextCol > N - 1) {
					continue;
				}
				
				if (map[nextRow][nextCol] != 1 && !check[nextRow][nextCol]) {
					q.add(new Node(nextRow, nextCol));
					check[nextRow][nextCol] = true;
					d[nextRow][nextCol] = d[x.x][x.y] + 1;
				}
			}
		}
		
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] != 1 && !check[i][j]) {
					return -1;
				} else if (d[i][j] > max) {
					max = d[i][j];
				}
			}
		}
		
		return max;
	}
	
	
	public static void combination(int[] arr, int index, int n, int r, int target) {
		if (r == 0) {
			int temp = bfs(arr);
			if (temp != -1 && temp < ans) {
				ans = temp;
			}
		} else if (target == n) {
			return;
			
		} else {
			arr[index] = target;
			combination(arr, index + 1, n, r - 1, target + 1);
			combination(arr, index, n, r, target + 1);
		}
	}
	
	public static class Node {
		int x, y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
