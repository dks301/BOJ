package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 아기 상어
 * N x N(2<=N<=20) 공간에 물고기 M마리 아기상어 1마리, 한칸에는 물고기가 최대 한마리
 * 0: 빈 칸, 1,2,3,4,5,6: 칸에 있는 물고기 크기, 9: 아기상어 위치
 * 아기 상어의 처음 크기 2, 1초에 상하좌우로 인접한 한칸씩 이동가능
 * 아기상어 >= 물고기 지나가기 가능, 아기상어 > 물고기 먹기 가능
 * 더 이상 먹을 수 있는 물고기가 공간에 없다면 아기 상어는 엄마 상어에게 도움을 요청한다.
 * 먹을 수 있는 물고기가 1마리라면, 그 물고기를 먹으러 간다.
 * 먹을 수 있는 물고기가 1마리보다 많다면, 거리가 가장 가까운 물고기를 먹으러 간다.
    - 거리는 아기 상어가 있는 칸에서 물고기가 있는 칸으로 이동할 때, 지나야하는 칸의 개수의 최소값이다.
    - 거리가 가까운 물고기가 많다면, 가장 위에 있는 물고기, 그러한 물고기가 여러마리라면, 가장 왼쪽에 있는 물고기를 먹는다.
 * 아기상어는 자신의 크기와 같은수의 물고기를 먹을 때 마다 크기가 1증가
 * 아기 상어가 엄마 상어에게 도움을 요청하기까지 걸리는 시간 출력.
 */
public class BOJ16236 {
	private static int[][] map;
	private static boolean[][] check;
	private static BabyShark bs;
	
	private static final int[][] DIRECTIONS = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
	private static final int ROW = 0;
	private static final int COL = 1;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		check = new boolean[N + 2][N + 2];
		map = new int[N + 2][N + 2];
		for (int i = 0; i < N + 2; i++) {
			Arrays.fill(map[i], -1);
		}
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					bs = new BabyShark(i, j, 2);
					map[i][j] = 0;
				}
			}
		}
		
		int ans = 0;
		int temp = 0;
		while ((temp = bfs(N)) != -1) {
			ans += temp;
			check = new boolean[N + 2][N + 2];
		}
		
		System.out.println(ans);
	}
	
	public static int bfs(int N) {
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(bs.x, bs.y));
		check[bs.x][bs.y] = true;
		int[][] d = new int[N + 2][N + 2];
		d[bs.x][bs.y] = 0;
		
		boolean[][] canEat = new boolean[N + 2][N + 2];
		int min = Integer.MAX_VALUE;
		
		while (!q.isEmpty()) {
			Pos x = q.remove();
			
			for (final int[] DIRECTION : DIRECTIONS) {
				int nextRow = x.x + DIRECTION[ROW];
				int nextCol = x.y + DIRECTION[COL];
				
				if (map[nextRow][nextCol] != -1 && map[nextRow][nextCol] <= bs.size && check[nextRow][nextCol] == false) {
					if (map[nextRow][nextCol] < bs.size && map[nextRow][nextCol] != 0) {
						canEat[nextRow][nextCol] = true;
						if (min > d[x.x][x.y] + 1) {
							min = d[x.x][x.y] + 1;
						}
					}
					
					q.add(new Pos(nextRow, nextCol));
					check[nextRow][nextCol] = true;
					d[nextRow][nextCol] = d[x.x][x.y] + 1;
				}
			}
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (canEat[i][j] == true && d[i][j] == min) {
					bs.feed();
					bs.x = i;
					bs.y = j;
					map[i][j] = 0;
					
					return d[i][j];
				}
			}
		}
		return -1;
	}
	public static class Pos {
		int x, y;
		
		public Pos (int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static class BabyShark {
		int x, y, size; // 아기상어 x좌표, y좌표, 크기
		int need;
		
		public BabyShark(int x, int y, int size) {
			this.x = x;
			this.y = y;
			this.size = size;
			need = size;
		}
		
		public void feed() {
			if (need == 1) {
				size++;
				need = size;
				
			} else {
				need--;
			}
		}
	}
}
