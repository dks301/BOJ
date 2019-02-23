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
		
		a = new int[N + 2][M + 2];
		check = new boolean[N + 2][M + 2];

		for (int i = 0; i < N + 2; i++) {
			Arrays.fill(a[i], 6);
		}
		
		Camera[][] camera = new Camera[8][4];
		int cameraIdx = 0;
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
				if (a[i][j] >= 1 && a[i][j] <= 5) {
					camera[cameraIdx++][0] = new Camera(a[i][j], i, j);
					camera[cameraIdx++][1] = new Camera(a[i][j], i, j);
					camera[cameraIdx++][2] = new Camera(a[i][j], i, j);
					camera[cameraIdx++][3] = new Camera(a[i][j], i, j);
				}
			}
		}
		
		for (int i = 0; i < cameraIdx; i++) {
			if (camera[i][0].idx == 5) {
				up(camera[i][0], check);
				down(camera[i][0], check);
				left(camera[i][0], check);
				right(camera[i][0], check);				
			}
		}
		
		boolean[][] temp = getCheck(check);
		for (int i = 0; i < cameraIdx; i++) {
			if (camera[i][0].idx != 5) {
				for (int j = 0; j < cameraIdx; j++) {
					for (int k = 0; k < cameraIdx; k++) {
						for (int l = 0; l < )
					}
				}
			}
		}
		for (Camera next : c) {
			switch (next.idx) {
			case 5:
				up(next, check);
				down(next, check);
				left(next, check);
				right(next, check);
				break;
			}
		}
		
		for (Camera next : c) {
			switch (next.idx) {
			case 1:
				for (Camera next2 : c) {
					
				}
				break;
				
			case 2:
				break;
				
			case 3:
				break;
				
			case 4:
				break;
			}
		}
		
//		for (Camera next : c5) {
//			up(next, check);
//			down(next, check);
//			left(next, check);
//			right(next, check);
//		}
//		
//		for (Camera next : c4) {
//			boolean[][] temp = getCheck(check);
//			up(next, temp);
//			left(next, temp);
//			right(next, temp);
//			
//			down(next);
//			left(next);
//			right(next);
//			
//			left(next);
//			up(next);
//			down(next);
//			
//			right(next);
//			up(next);
//			down(next);
//		}
//		for (Camera next : c3) {
//			up(next);
//			left(next);
//			
//			up(next);
//			right(next);
//			
//			down(next);
//			left(next);
//			
//			down(next);
//			right(next);
//		}
//		for (Camera next : c2) {
//			up(next);
//			down(next);
//			
//			left(next);
//			right(next);
//		}
//		for (Camera next : c1) {
//			up(next);
//			
//			down(next);
//			
//			left(next);
//			
//			right(next);
//		}
	}

	public static boolean[][] getCheck (boolean[][] c) {
		int N = c.length;
		int M = c[0].length;
		boolean[][] temp = new boolean[N][M];
		
		for (int i = 1 ; i <= N - 2; i++) {
			for (int j = 1; j <= M - 2; j++) {
				temp[i][j] = c[i][j];
			}
		}
		
		return temp;
	}
	
	public static void up(Camera c, boolean[][] check) {
		Queue<Camera> q = new LinkedList<>();
		q.add(c);
		check[c.x][c.y] = true;

		while (!q.isEmpty()) {
			c = q.remove();

			int nextRow = c.x - 1;
			int nextCol = c.y;
			if (a[nextRow][nextCol] != 6) {
				q.add(new Camera(c.idx, nextRow, nextCol));
				check[nextRow][nextCol] = true;
			}
		}
	}

	public static void down(Camera c, boolean[][] check) {
		Queue<Camera> q = new LinkedList<>();
		q.add(c);
		check[c.x][c.y] = true;

		while (!q.isEmpty()) {
			c = q.remove();

			int nextRow = c.x + 1;
			int nextCol = c.y;
			if (a[nextRow][nextCol] != 6) {
				q.add(new Camera(c.idx, nextRow, nextCol));
				check[nextRow][nextCol] = true;
			}
		}
	}

	public static void left(Camera c, boolean[][] check) {
		Queue<Camera> q = new LinkedList<>();
		q.add(c);
		check[c.x][c.y] = true;

		while (!q.isEmpty()) {
			c = q.remove();

			int nextRow = c.x;
			int nextCol = c.y - 1;
			if (a[nextRow][nextCol] != 6) {
				q.add(new Camera(c.idx, nextRow, nextCol));
				check[nextRow][nextCol] = true;
			}
		}
	}

	public static void right(Camera c, boolean[][] check) {
		Queue<Camera> q = new LinkedList<>();
		q.add(c);
		check[c.x][c.y] = true;

		while (!q.isEmpty()) {
			c = q.remove();

			int nextRow = c.x;
			int nextCol = c.y + 1;
			if (a[nextRow][nextCol] != 6) {
				q.add(new Camera(c.idx, nextRow, nextCol));
				check[nextRow][nextCol] = true;
			}
		}
	}

	public static class Camera { // 이거를 Node로 바꿔서 idx == 6이면 벽으로 설정하는것 고려
		int idx;
		int x, y;
		boolean[] direction = new boolean[4]; // 0, 1, 2, 3 -> 4가지 방향

		public Camera(int idx, int x, int y) {
			this.idx = idx;
			this.x = x;
			this.y = y;
		}
		
		public void rotate(int idx, boolean[][] c) {
			switch (idx) {
			case 1:
				up(this, c);
				
				
				break;
				
			case 2:
				
				break;
				
			case 3:
				
				break;
				
			case 4:
				
				break;
				
			case 5:
				
				break;
			}
		}
	}
}
