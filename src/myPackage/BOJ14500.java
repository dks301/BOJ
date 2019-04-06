package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 테트로미노
 * 정사각형 4개를 이어붙인 것이 테트로미노(테트리스모양)
 * 테트로미노는 회전, 대칭이 가능
 * 크기가 N*M인 종이 위에 테트로미노 하나 놓기, 종이의 한칸에는 정수가 쓰여있음
 * 테트로미노 하나가 놓인 칸의 최대값 출력
 * 
 * 첫째줄: 종이의 세로N, 가로M(4<=N,M<=500)
 * 둘째줄부터 N개줄: 종이에 쓰여있는 수, 수는 1,000을 넘지않는 자연수
 * 시간초과,,,
 */
public class BOJ14500 {
	private static int N, M;
	private static int[][] board;
	private static int value;
	
	private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	private static final int ROW = 0;
	private static final int COL = 1;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				boolean[][] check = new boolean[N][M];
				tetro1(new Node(i, j), check, 0, 4);
				tetro2(new Node(i, j));
			}
		}
		System.out.println(value);
	}
	
	public static boolean[][] deepCopy(boolean[][] check) {
		boolean[][] temp = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			System.arraycopy(check[i], 0, temp[i], 0, check[i].length);
		}
		return temp;
	}
	
	public static void tetro1(Node x, boolean[][] check, int val, int n) {
		if (n == 0) {
			value = (val > value ? val : value);
			return;
		}
		
		check[x.x][x.y] = true;
		val += board[x.x][x.y];
		n--;
		
		for (final int[] DIRECTION : DIRECTIONS) {
			int nextRow = x.x + DIRECTION[ROW];
			int nextCol = x.y + DIRECTION[COL];
			
			if (nextRow < 0 || nextRow > N - 1 || nextCol < 0 || nextCol > M - 1) {
				continue;
			}

			if (!check[nextRow][nextCol]) {
				check[nextRow][nextCol] = true;
				tetro1(new Node(nextRow, nextCol), check, val, n);
			}
		}
		check[x.x][x.y] = false;
	}
	
	public static void tetro2(Node x) {
		int val = board[x.x][x.y];
		int min = 1001;
		int cnt = 0;
		
		for (final int[] DIRECTION : DIRECTIONS) {
			int nextRow = x.x + DIRECTION[ROW];
			int nextCol = x.y + DIRECTION[COL];
			
			if (nextRow < 0 || nextRow > N - 1 || nextCol < 0 || nextCol > M - 1) {
				continue;
			}
			cnt++;
			int temp = board[nextRow][nextCol];
			if (temp < min) {
				min = temp;
			}
			val += temp;
		}
		
		if (cnt <= 2) {
			return;
		} else if (cnt == 3) {
			value = (val > value ? val : value);
		} else {
			val -= min;
			value = (val > value ? val : value);
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
