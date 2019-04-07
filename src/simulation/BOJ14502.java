package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 연구소
 * 연구소는 크기가 N * M(3<=N,M<=8)
 * 바이러스는 상하좌우 인접한 빈 칸으로 퍼져나갈 수 있다.
 * 새로 새울 수 있는 벽은 3개이며 3개를 모두 꼭 세워야함
 * 0은 빈 칸(3개이상), 1은 벽, 2는 바이러스(2<=바이러스의 갯수<=10)
 * 벽을 3개 세운 뒤, 바이러스가 퍼질수 없는 안전영역의 최댓값 출력
 */
public class BOJ14502 {
	private static int[][] map;
	private static int N, M;
	private static ArrayList<Node> virus = new ArrayList<>();
	private static ArrayList<Node> blank = new ArrayList<>();
	private static int ans = 0;
	
	private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
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
				if (map[i][j] == 2) {
					virus.add(new Node(i, j));
				} else if (map[i][j] == 0) {
					blank.add(new Node(i, j));
				}
			}
		}
		combination(new int[3], 0, blank.size(), 3, 0);
		System.out.println(ans);
	}
	
	public static void setWall(int[] arr) {
		int[][] temp = deepCopy();
		
		for (int i = 0; i < arr.length; i++) {
			Node n = blank.get(arr[i]);
			temp[n.x][n.y] = 1;
		}
		
		bfs(temp);
	}
	
	public static void combination(int[] arr, int index, int n, int r, int target) {
		if (r == 0) {
			setWall(arr);
		} else if (target == n) {
			return;
		} else {
			arr[index] = target;
			combination(arr, index + 1, n, r - 1, target + 1);
			combination(arr, index, n, r, target + 1);
		}
	}
	
	public static int[][] deepCopy() {
		int[][] temp = new int[N][M];
		for (int i = 0; i < N; i++) {
			System.arraycopy(map[i], 0, temp[i], 0, M);
		}
		return temp;
	}
	
	public static void bfs(int[][] map) {
		Queue<Node> q = new LinkedList<>();
		q.addAll(virus);
		
		while (!q.isEmpty()) {
			Node x = q.remove();
			
			for (final int[] DIRECTION : DIRECTIONS) {
				int nextRow = x.x + DIRECTION[ROW];
				int nextCol = x.y + DIRECTION[COL];
				if (nextRow < 0 || nextRow > N - 1 || nextCol < 0 || nextCol > M - 1) {
					continue;
				}
				
				if (map[nextRow][nextCol] == 0) {
					q.add(new Node(nextRow, nextCol));
					map[nextRow][nextCol] = 2;
				}
			}
		}
		
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					cnt++;
				}
			}
		}
		
		if (ans < cnt) {
			ans = cnt;
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
