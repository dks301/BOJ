package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 감시
 * 1번 카메라: 동서남북 중 한방향
 * 2번 카메라: 동서 or 남북
 * 3번 카메라: 남서 or 남동 or 북서 or 북동
 * 4번 카메라: 동서남 or 서남북 or 남북동 or 북동서
 * 5번 카메라: 동서남북
 * 사각 지대의 최소 크기 출력
 */
public class BOJ15683 {
	private static int[][] a;
	private static boolean[][] check;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		// 가장 많이 감시할 수 있는 것 찾고 그건 고정, 그 다음 이미 감시중인걸 빼고 가장 많이 감시할 수 있는것 찾고 고정
		// 반복
		a = new int[N + 2][M + 2];
		check = new boolean[N + 2][M + 2];

		for (int i = 0; i < N + 2; i++) {
			Arrays.fill(a[i], 6);
		}
		
		ArrayList<Camera> c1 = new ArrayList<>();
		ArrayList<Camera> c2 = new ArrayList<>();
		ArrayList<Camera> c3 = new ArrayList<>();
		ArrayList<Camera> c4 = new ArrayList<>();
		ArrayList<Camera> c5 = new ArrayList<>();
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
				
				switch (a[i][j]) {
				case 1:
					c1.add(new Camera(i, j));
					break;
					
				case 2:
					c2.add(new Camera(i, j));
					break;
					
				case 3:
					c3.add(new Camera(i, j));
					break;
					
				case 4:
					c4.add(new Camera(i, j));
					break;
					
				case 5:
					c5.add(new Camera(i, j));
					break;
				}
			}
		}
		
		for (Camera next : c5) {
			up(next);
			down(next);
			left(next);
			right(next);
		}
		for (Camera next : c4) {
			up(next);
			down(next);
			left(next);
			right(next);
		}
		for (Camera next : c3) {
			up(next);
			down(next);
			left(next);
			right(next);
		}
		for (Camera next : c2) {
			up(next);
			down(next);
			left(next);
			right(next);
		}
		for (Camera next : c1) {
			up(next);
			down(next);
			left(next);
			right(next);
		}
	}

	public static void up(Camera c) {
		Queue<Camera> q = new LinkedList<>();
		q.add(c);
		check[c.x][c.y] = true;

		while (!q.isEmpty()) {
			c = q.remove();

			int nextRow = c.x - 1;
			int nextCol = c.y;
			if (a[nextRow][nextCol] != 6) {
				q.add(new Camera(nextRow, nextCol));
				check[nextRow][nextCol] = true;
			}
		}
	}

	public static void down(Camera c) {
		Queue<Camera> q = new LinkedList<>();
		q.add(c);
		check[c.x][c.y] = true;

		while (!q.isEmpty()) {
			c = q.remove();

			int nextRow = c.x + 1;
			int nextCol = c.y;
			if (a[nextRow][nextCol] != 6) {
				q.add(new Camera(nextRow, nextCol));
				check[nextRow][nextCol] = true;
			}
		}
	}

	public static void left(Camera c) {
		Queue<Camera> q = new LinkedList<>();
		q.add(c);
		check[c.x][c.y] = true;

		while (!q.isEmpty()) {
			c = q.remove();

			int nextRow = c.x;
			int nextCol = c.y - 1;
			if (a[nextRow][nextCol] != 6) {
				q.add(new Camera(nextRow, nextCol));
				check[nextRow][nextCol] = true;
			}
		}
	}

	public static void right(Camera c) {
		Queue<Camera> q = new LinkedList<>();
		q.add(c);
		check[c.x][c.y] = true;

		while (!q.isEmpty()) {
			c = q.remove();

			int nextRow = c.x;
			int nextCol = c.y + 1;
			if (a[nextRow][nextCol] != 6) {
				q.add(new Camera(nextRow, nextCol));
				check[nextRow][nextCol] = true;
			}
		}
	}

	public static class Camera {
		int x, y;

		public Camera(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
