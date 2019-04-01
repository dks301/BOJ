package bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 치킨 배달
 * '치킨 거리'는 집과 가장 가까운 치킨집 사이의 거리
 * '도시의 치킨 거리'는 모든 집의 치킨 거리의 합
 * 임의의 두 칸 (r1,c1)과 (r2,c2)사이의 거리 = |r1-r2| + |c1-c2|
 * 0은 빈 칸, 1은 집, 2는 치킨집
 * 도시의 크기N*N(2<=N<=50), 폐업시키지 않을 치킨집의 수 M(1<=M<=13)
 * 집의 갯수는 2개를 넘지 않으며, 적어도 한개 존재한다.
 * 치킨집의 갯수는 M보다 크거나 같고, 13보다 작거나 같다.
 * 최대 M개의 치킨집이 남을 때, 도시의 치킨거리의 최솟값 출력.
 */
public class BOJ15686 {
	private static int[][] map;
	private static boolean[][] check;
	
	private static ArrayList<ArrayList<Integer>> com;
	private static ArrayList<Node> cl;
	
	private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	private static final int ROW = 0;
	private static final int COL = 1;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		com = new ArrayList<>();
		cl = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					cl.add(new Node(i, j));
				}
			}
		}
		pick(cl.size(), new ArrayList<Integer>(), M);
		
		int min = Integer.MAX_VALUE;
		for (ArrayList<Integer> next : com) {
			check = new boolean[N][N];
			int temp = bfs(next, N);

			if (temp < min) {
				min = temp;
			}
		}
		System.out.println(min);
		
	}
	
	public static int bfs(ArrayList<Integer> al, int N) {
		Queue<Node> q = new LinkedList<>();
		for (int next : al) {
			Node n = cl.get(next);
			q.add(n);
			check[n.x][n.y] = true;
		}

		int[][] d = new int[N][N];
		
		int ans = 0;
		
		while (!q.isEmpty()) {
			Node c = q.remove();
			
			for (final int[] DIRECTION : DIRECTIONS) {
				int nextRow = c.x + DIRECTION[ROW];
				int nextCol = c.y + DIRECTION[COL];
				
				if (nextRow < 0 || nextRow > N - 1 || nextCol < 0 || nextCol > N - 1) {
					continue;
				}
				if (!check[nextRow][nextCol]) {
					q.add(new Node(nextRow, nextCol));
					check[nextRow][nextCol] = true;
					d[nextRow][nextCol] = d[c.x][c.y] + 1;
					
					if (map[nextRow][nextCol] == 1) {
						ans += d[nextRow][nextCol];
					}
				}
			}
		}
		return ans;
	}
	
	public static void pick(int n, ArrayList<Integer> picked, int toPick) {
		if (toPick == 0) {
			com.add(picked);
			return;
		}
		
		int smallest = picked.isEmpty() ? 0 : picked.get(picked.size() - 1) + 1;
		
		for (int next = smallest; next < n; next++) {
			picked.add(next);
			pick(n, new ArrayList<Integer>(picked), toPick - 1);
			picked.remove(picked.size() - 1);
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
