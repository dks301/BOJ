package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 구슬 탈출2
 * 보드의 세로 크기N, 가로 크기M(3<=N,M<=10)
 * '.':빈 칸, '#':벽, 'o':구멍, 'R':빨간 구슬, 'B':파란 구슬
 * 빨간 구슬을 구멍에 빠뜨리면 성공, 파란 구슬이 빠지면 실패, 동시에 빠져도 실패
 * 성공할 수 있는 최소 기울이기 수 출력, 10번 이하로 성공하지 못하면 -1 출력
 */
public class BOJ13460 {
	public static char[][] board;
	public static final char BLANK = '.';
	public static final char WALL = '#';
	public static final char HOLE = 'O';
	public static final char RED = 'R';
	public static final char BLUE = 'B';
	
	public static final int[] UP = {0, 1};
	public static final int[] DOWN = {0, -1};
	public static final int[] LEFT = {-1, 0};
	public static final int[] RIGHT = {1, 0};
	public static final int ROW = 0;
	public static final int COL = 1;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		board = new char[N][M];
		for (int i = 0; i < N; i++) {
			board[i] = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
}
