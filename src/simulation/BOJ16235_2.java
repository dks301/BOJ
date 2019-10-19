package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ16235_2 {
	private static int N, M, K;
	private static int[][] map;
	private static int[][] check;
	private static Deque<Tree> trees;

	private static final int[][] DIRECTIONS = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 },
			{ 1, 0 }, { 1, 1 } };
	private static final int ROW = 0;
	private static final int COL = 1;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		check = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int val = Integer.parseInt(st.nextToken());
				map[i][j] = val;
				check[i][j] = 5;
			}
		}

		trees = new LinkedList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			trees.add(new Tree(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1,
					Integer.parseInt(st.nextToken())));
		}
		
		while (K-- > 0) {
			spring();
			summer();
			fall();
			winter();
		}
		
		System.out.println(trees.size());
	}

	public static void spring() {
		for (Tree next : trees) {
			if (check[next.row][next.col] < next.age) {
				next.isDie = true;

			} else {
				check[next.row][next.col] -= next.age;
				next.age++;
			}
		}
	}

	public static void summer() {
		Iterator<Tree> it = trees.iterator();
		while (it.hasNext()) {
			Tree next = it.next();
			if (next.isDie) {
				check[next.row][next.col] += (next.age / 2);
				it.remove();
			}
		}
	}

	public static void fall() {
		ArrayList<Tree> temp = new ArrayList<>();
		
		for (Tree next : trees) {
			if (next.age % 5 == 0) {
				for (final int[] D : DIRECTIONS) {
					int nextRow = next.row + D[ROW];
					int nextCol = next.col + D[COL];
					if (nextRow < 0 || nextRow > N - 1 || nextCol < 0 || nextCol > N - 1) {
						continue;
					}
					
					temp.add(new Tree(nextRow, nextCol, 1));
				}
			}
		}
		
		for (Tree next : temp) {
			trees.addFirst(next);
		}
	}

	public static void winter() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				check[i][j] += map[i][j];
			}
		}
	}

	public static class Tree {
		int row, col;
		int age;
		boolean isDie;

		public Tree(int row, int col, int age) {
			this.row = row;
			this.col = col;
			this.age = age;
			isDie = false;
		}
	}
}
