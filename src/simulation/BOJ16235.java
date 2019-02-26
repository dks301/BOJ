package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * 나무 재테크
 * 땅의 크기 1 ≤ N ≤ 10, 나무의 수 1 ≤ M ≤ N^2, 1 ≤ K ≤ 1,000
 * 1 ≤ A[r][c] ≤ 100, 1 ≤ 입력으로 주어지는 나무의 나이 ≤ 10
 * 입력으로 주어지는 나무의 위치는 모두 서로 다름
 * 봄에는 나무가 자신의 나이만큼 양분을 먹고 나이가 1증가, 나무가 여러개라면  어린 나무부터 양분을 먹는다, 양분이 부족하면 즉사
 * 여름에는 봄에 죽은 나무가 양분으로 변한다. 죽은 나무의 나이 / 2 = 양분(소수점아래는 버림)
 * 가을에는 나이가 5의 배수인 나무가 인접한 8개 칸에 번식해서 나이가 1인 나무가 생긴다
 * 겨울에는 로봇이 땅에 양분을 추가한다.
 * K년이 지난 후에 살아남은 나무의 수 출력
 */
public class BOJ16235 {
	private static int[][] food; //양분지도
	private static int[][] A; //로봇의 양분추가지도
	private static LinkedList<Tree> t = new LinkedList<>();
	
	private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
	private static final int ROW = 0;
	private static final int COL = 1;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		food = new int[N + 2][N + 2];
		for (int i = 1; i <= N ; i++) {
			for (int j = 1; j <= N; j++) {
				food[i][j] = 5; // 각 칸의 양분량
			}
		}
		
		A = new int[N + 2][N + 2];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			t.add(new Tree(x, y, z));
		}
		
		for (int i = 0; i < K; i++) {
			spring(N);
			
			summer();
			if (t.size() < 1) {
				break;
			}
			
			fall(N);
			
			winter(N);
		}
		
		System.out.println(t.size());
	}
	
	public static void spring(int N) {
		for (Tree next : t) {
			if (next.z <= food[next.x][next.y]) {
				food[next.x][next.y] -= next.z;
				next.z++;
				
			} else {
				next.isDie = true;
			}
		}
	}
	
	public static void summer() {
		Iterator<Tree> it = t.iterator();
		
		while (it.hasNext()) {
			Tree next = it.next();

			if (next.isDie == true) {
				food[next.x][next.y] += (next.z / 2);
				it.remove();
			}
		}
	}
	
	public static void fall(int N) {
		LinkedList<Tree> sprout = new LinkedList<>();
		
		for (Tree next : t) {
			if (next.z % 5 == 0) {
				for (final int[] DIRECTION : DIRECTIONS) {
					int nextRow = next.x + DIRECTION[ROW];
					int nextCol = next.y + DIRECTION[COL];
					
					if (nextRow >= 1 && nextRow <= N && nextCol >= 1 && nextCol <= N) {
						sprout.add(new Tree(nextRow, nextCol, 1));
					}
				}
			}
		}

		for (Tree next : sprout) {
			t.addFirst(next);	
		}
	}
	
	public static void winter(int N) {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				food[i][j] += A[i][j]; 
			}
		}
	}
	
	public static class Tree{
		int x, y, z;
		boolean isDie;
		
		public Tree(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.isDie = false;
		}
	}
}
