package floodFill;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 체스판 다시 칠하기
 * MN개의 단위 정사각형으로 나누어져 있는 M*N크기의 보드
 * 각 정사각형은 검정 or 흰색
 * 8*8로 잘라낸 후 색칠해서 체스판으로 만들기
 * 체스판은 변을 공유하는 두 개의 사각형이 같은 색이 아니다
 * 왼쪽 위가 흰색 or 검정 두 가지 체스판이 있음
 * M과 N은 8보다 크거나 같고, 50보다 작거나 같은 자연수
 * 8*8 크기로 자른 뒤에 다시 칠해야하는 정사각형 개수의 최솟값 출력
 */
public class BOJ1018 {
	private static boolean[][] board;
	private static boolean[][] check;

	private static final int[][] DIRECTIONS = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	private static final int ROW = 0;
	private static final int COL = 1;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		board = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				board[i][j] = temp[j] == 'B' ? true : false;
			}
		}
		
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < N - 7; i++) {
			for (int j = 0; j < M - 7; j++) {
				boolean[][] chess = cuttingBoard(i, j);
				check = new boolean[8][8];
				int temp = bfs(chess);
				if (temp < min) {
					min = temp;
				}
				
				check = new boolean[8][8];
				chess[0][0] = !chess[0][0];
				temp = bfs(chess) + 1;
				if (temp < min) {
					min = temp;
				}
			}
		}
		System.out.println(min);
	}

	public static boolean[][] cuttingBoard(int x, int j) {
		boolean[][] chess = new boolean[8][8];
		int k = 0;
		for (int i = x; i < x + 8; i++) {
			System.arraycopy(board[i], j, chess[k++], 0, 8);
		}
		return chess;
	}

	public static int bfs(boolean[][] chess) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(0, 0, chess[0][0]));
		check[0][0] = true;
		int cnt = 0;
		
		while (!q.isEmpty()) {
			Node x = q.remove();
			
			for (final int[] DIRECTION : DIRECTIONS) {
				int nextRow = x.x + DIRECTION[ROW];
				int nextCol = x.y + DIRECTION[COL];
				if (nextRow < 0 || nextRow > 7 || nextCol < 0 || nextCol > 7) {
					continue;
				}
				
				if (!check[nextRow][nextCol]) {
					if (chess[nextRow][nextCol] == x.color) {
						cnt++;
					}
					q.add(new Node(nextRow, nextCol, !x.color));
					check[nextRow][nextCol] = true;
				}
			}
		}
		
		return cnt;
	}

	public static class Node {
		int x, y;
		boolean color;

		public Node(int x, int y, boolean color) {
			this.x = x;
			this.y = y;
			this.color = color;
		}
	}
}
