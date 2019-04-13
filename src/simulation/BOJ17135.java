package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 캐슬 디펜스
 * 크기가 NxM인 격자판, 각 칸에 포함된 적의 수는 최대 하나
 * 격자판의 N번행 바로 아래(N+1번행)의 모든 칸에는 성이있다
 * 궁수 3명을 성에 배치, 하나의 칸에 최대 1명, 각 턴마다 궁수는 적 하나 공격 가능
 * 궁수가 공격하는 적은 거리가 D이하인 가장 가까운 적, 이런 적이 여려명일 경우 가장 왼쪽에 있는 적 공격
 * 같은 적이 여러 궁수에게 공격당할 수 있다. 공격받은 적은 게임에서 제외
 * 궁수의 공격이 끝나면 적이 아래로 한 칸 이동, 성에 도달하면 게임에서 제외, 모든 적이 제외되면 게임 끝
 * 격자판의 상태가 주어졌을 때, 궁수의 공격으로 제거할 수 있는 적의 최대 수 출력
 * 격자판의 두 위치 (r1,c1), (r2,c3)의 거리는 |r1-r2| + |c1-c2|
 * 
 * 첫쨰줄: 행N, 열M, 궁수사거리D(3<=N,M<=15, 1<=D<=10)
 * 둘째줄~N개줄: 격자판 상태 0은 빈 칸, 1은 적이 있는 칸
 */
public class BOJ17135 {
	private static int N, M, D, ans;
	private static boolean[][] map;
	private static int[][] d;
	private static LinkedList<Node>[] attack;
	
	private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	private static final int ROW = 0;
	private static final int COL = 1;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new boolean[N + 1][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()) == 1 ? true : false;
			}
		}
		
		ans = 0;
		combination(new int[3], 0, M, 3, 0);
		System.out.println(ans);
	}
	
	public static boolean[][] deepCopy() {
		boolean[][] temp = new boolean[N + 1][M];
		for (int i = 0; i < N + 1; i++) {
			System.arraycopy(map[i], 0, temp[i], 0, M);
		}
		return temp;
	}
	
	public static boolean isEnd(boolean[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static void gameStart(int[] arr) {
		int total = 0;
		boolean[][] temp = deepCopy();
		
		while (!isEnd(temp)) {
			attack = new LinkedList[3];
			for (int i = 0; i < 3; i++) {
				attack[i] = new LinkedList<>();
			}
			myTurn(arr, temp);
			for (int i = 0; i < 3; i++) {
				if (!attack[i].isEmpty()) {
					Node n = attack[i].get(0);
					if (temp[n.x][n.y]) {
						temp[n.x][n.y] = false;
						total++;
					}
				}
			}
			yourTurn(temp);
		}
		
		if (ans < total) {
			ans = total;
		}
	}
	
	public static void yourTurn(boolean[][] map) {
		for (int j = 0; j < M; j++) {
			for (int i = N - 1; i >= 0; i--) {
				if (map[i][j]) {
					if (i != N - 1) {
						map[i + 1][j] = true;
					}
					map[i][j] = false;
				}
			}
		}
	}
	
	public static void myTurn(int[] arr, boolean[][] map) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(N, arr[0]));
		d = new int[N + 1][M];
		
		
		while(!q.isEmpty()) {
			Node x = q.remove();
			
			for (final int[] DIRECTION : DIRECTIONS) {
				int nextRow = x.x + DIRECTION[ROW];
				int nextCol = x.y + DIRECTION[COL];
				
				if (nextRow < 0 || nextRow > N - 1 || nextCol < 0 || nextCol > M - 1) {
					continue;
				}
				
				if (d[nextRow][nextCol] == 0 && d[x.x][x.y] < D) {
					q.add(new Node(nextRow, nextCol));
					d[nextRow][nextCol] = d[x.x][x.y] + 1;
					
					if (map[nextRow][nextCol]) {
						if (attack[0].isEmpty()) {
							attack[0].add(new Node(nextRow, nextCol));
						} else {
							Node n = attack[0].remove(0);
							if (d[n.x][n.y] > d[nextRow][nextCol]) {
								attack[0].add(new Node(nextRow, nextCol));
								
							} else if (d[n.x][n.y] == d[nextRow][nextCol]) {
								if (n.y < nextCol) {
									attack[0].add(n);
									
								} else {
									attack[0].add(new Node(nextRow, nextCol));
									
								}
							} else {
								attack[0].add(n);
							}
						}
					}
				}
			}
		}
		
		q.add(new Node(N, arr[1]));
		d = new int[N + 1][M];
		
		
		while(!q.isEmpty()) {
			Node x = q.remove();
			
			for (final int[] DIRECTION : DIRECTIONS) {
				int nextRow = x.x + DIRECTION[ROW];
				int nextCol = x.y + DIRECTION[COL];
				
				if (nextRow < 0 || nextRow > N - 1 || nextCol < 0 || nextCol > M - 1) {
					continue;
				}
				
				if (d[nextRow][nextCol] == 0 && d[x.x][x.y] < D) {
					q.add(new Node(nextRow, nextCol));
					d[nextRow][nextCol] = d[x.x][x.y] + 1;
					
					if (map[nextRow][nextCol]) {
						if (attack[1].isEmpty()) {
							attack[1].add(new Node(nextRow, nextCol));
						} else {
							Node n = attack[1].remove(0);
							if (d[n.x][n.y] > d[nextRow][nextCol]) {
								attack[1].add(new Node(nextRow, nextCol));
								
							} else if (d[n.x][n.y] == d[nextRow][nextCol]) {
								if (n.y < nextCol) {
									attack[1].add(n);
									
								} else {
									attack[1].add(new Node(nextRow, nextCol));
									
								}
							} else {
								attack[1].add(n);
							}
						}
					}
				}
			}
		}
		
		q.add(new Node(N, arr[2]));
		d = new int[N + 1][M];
		
		
		while(!q.isEmpty()) {
			Node x = q.remove();
			
			for (final int[] DIRECTION : DIRECTIONS) {
				int nextRow = x.x + DIRECTION[ROW];
				int nextCol = x.y + DIRECTION[COL];
				
				if (nextRow < 0 || nextRow > N - 1 || nextCol < 0 || nextCol > M - 1) {
					continue;
				}
				
				if (d[nextRow][nextCol] == 0 && d[x.x][x.y] < D) {
					q.add(new Node(nextRow, nextCol));
					d[nextRow][nextCol] = d[x.x][x.y] + 1;
					
					if (map[nextRow][nextCol]) {
						if (attack[2].isEmpty()) {
							attack[2].add(new Node(nextRow, nextCol));
						} else {
							Node n = attack[2].remove(0);
							if (d[n.x][n.y] > d[nextRow][nextCol]) {
								attack[2].add(new Node(nextRow, nextCol));
								
							} else if (d[n.x][n.y] == d[nextRow][nextCol]) {
								if (n.y < nextCol) {
									attack[2].add(n);
									
								} else {
									attack[2].add(new Node(nextRow, nextCol));
									
								}
							} else {
								attack[2].add(n);
							}
						}
					}
				}
			}
		}
		
		
	}
	
	public static void combination(int[] arr, int index, int n, int r, int target) {
		if (r == 0) {
			gameStart(arr);
			
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
