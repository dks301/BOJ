package bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 봄버맨
 * 폭탄은 3초가 지난후 그 칸 + 인접한 네칸이 폭파,
 * 인접한 칸에 있던 폭탄은 폭발없이 파괴
 * 1. 가장 처음 봄버 맨은 일부 칸에 폭탄을 설치
 * 2. 다음 1초 동안 봄버맨은 아무것도 하지 않음
 * 3. 다음 1초 동안 폭탄이 없는 모든 칸에 폭탄 설치, 즉 모든 칸은 폭탄을 가지고있음
 * 4. 1초가 지난 후에 3초 전에 설치된 폭탄이 모두 폭발.
 * 위 3, 4를 반복
 * (1<=R,C,N<=200) 빈칸은 '.', 폭탄은 'O'
 * 초기 상태가 주어졌을 때, N초가 지난 후의 격자판 상태를 출력
 */
public class BOJ16918 {
	private static final String NEW_LINE = "\n";
	private static final char BLANK = '.';
	private static final char BOMB = 'O';

	private static char[][] map;
	private static boolean[][] check;

	private static final int[][] DIRECTIONS = { { 1, 0 }, { -1, 0 }, { 0, 0 }, { 0, 1 }, { 0, -1 } };
	private static final int ROW = 0;
	private static final int COL = 1;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		map = new char[R + 2][C + 2];
		
		for (int i = 1; i <= R; i++) {
			char[] init = br.readLine().toCharArray();
			for (int j = 1; j <= C; j++) {
				map[i][j] = init[j - 1];
			}
		}
		
		StringBuilder sb = new StringBuilder();
		if (N % 2 == 1) {
			for (int i = 0; i < N / 2; i++) {
				bfs(R, C);
			}
			
			for (int i = 1; i <= R; i++) {
				for (int j = 1; j <= C; j++) {
					sb.append(map[i][j]);
				}
				sb.append(NEW_LINE);
			}
			System.out.print(sb);
			
		} else if (N % 2 == 0) {
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					sb.append(BOMB);
				}
				sb.append(NEW_LINE);
			}
			System.out.print(sb);
			
		}
	}

	public static void bfs(int R, int C) {
		Queue<Bomb> q = new LinkedList<>();
		check = new boolean[R + 2][C + 2];
		
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				if (map[i][j] == BOMB) {
					q.add(new Bomb(i, j));
				}
			}
			Arrays.fill(map[i], BOMB);
		}
		
		while (!q.isEmpty()) {
			Bomb b = q.remove();
			
			for (final int[] DIRECTION : DIRECTIONS) {
				int nextRow = b.x + DIRECTION[ROW];
				int nextCol = b.y + DIRECTION[COL];
				
				if (check[nextRow][nextCol] == false) {
					check[nextRow][nextCol] = true;
					map[nextRow][nextCol] = BLANK;
				}
			}
		}
	}
	
	public static class Bomb {
		int x, y;

		public Bomb(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
