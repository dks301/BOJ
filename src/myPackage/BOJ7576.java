package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 토마토
 * 상자의 가로 칸의 수 M, 세로 칸의 수 N(2<=M,N<=1,000)
 * 1은 익은 토마토, 0은 안익은 토마토, -1은 없는 토마토
 * 익은 토마토에 인접한 안익은 토마토는 하루가 지나면 익는다.
 * 모든 토마토가 익는데 걸리는 최소 일수 출력
 */
public class BOJ7576 {
	private static int[][] check;
	private static int[][] box;

	private static final int[][] DIRECTIONS = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	private static final int ROW = 0;
	private static final int COL = 1;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken()); // COL
		int N = Integer.parseInt(st.nextToken()); // ROW
		box = new int[N + 2][M + 2];
		check = new int[N + 2][M + 2];
		for (int i = 0; i < N + 2; i++) {
			Arrays.fill(box[i], -1);
		}
		int totalTomato = 0;
		ArrayList<Tomato> ripenTomato = new ArrayList<>();

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if (box[i][j] != -1) {
					if (box[i][j] == 1) {
						ripenTomato.add(new Tomato(i, j));
					}
					totalTomato++;
				}
			}
		}
	
		System.out.println(bfs(ripenTomato, totalTomato));
	}

	public static int bfs(ArrayList<Tomato> al, int totalTomato) {
		if (totalTomato == al.size()) {
			return 0;
		}
		
		Queue<Tomato> q = new LinkedList<>();
		int count = 0, max = -1;
		for (int i = 0; i < al.size(); i++) {
			q.add(al.get(i));
			check[al.get(i).x][al.get(i).y] = 1;
		}
		
		while (!q.isEmpty()) {
			Tomato t = q.remove();
			count++;

			for (final int[] DIRECTION : DIRECTIONS) {
				int nextRow = t.x + DIRECTION[ROW];
				int nextCol = t.y + DIRECTION[COL];

				if (check[nextRow][nextCol] == 0 && box[nextRow][nextCol] == 0) {
					q.add(new Tomato(nextRow, nextCol));
					check[nextRow][nextCol] = check[t.x][t.y] + 1;
					if(max < check[nextRow][nextCol]) {
						max = check[nextRow][nextCol];
					}
				}
			}
		}
		
		return totalTomato != count ? -1 : max - 1;
	}

	public static class Tomato {
		int x, y;

		public Tomato(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
