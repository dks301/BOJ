package simulation;

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
 */
public class BOJ14500 {
	private static int N, M;
	private static int[][] board;

	private static final int[][][] TETROMINO = { { { 0, 0 }, { 1, 0 }, { 2, 0 }, { 3, 0 } },
			{ { 0, 0 }, { 0, 1 }, { 0, 2 }, { 0, 3 } }, { { 0, 0 }, { 0, 1 }, { 1, 0 }, { 1, 1 } },
			{ { 0, 0 }, { 1, 0 }, { 2, 0 }, { 2, 1 } }, { { 0, 0 }, { 1, -2 }, { 1, -1 }, { 1, 0 } },
			{ { 0, 0 }, { 0, 1 }, { 1, 1 }, { 2, 1 } }, { { 0, 0 }, { 0, 1 }, { 0, 2 }, { 1, 0 } },
			{ { 0, 0 }, { 1, 0 }, { 2, 0 }, { 2, -1 } }, { { 0, 0 }, { 0, 1 }, { 0, 2 }, { 1, 2 } },
			{ { 0, 0 }, { 0, 1 }, { 1, 0 }, { 2, 0 } }, { { 0, 0 }, { 1, 0 }, { 1, 1 }, { 1, 2 } },
			{ { 0, 0 }, { 1, 0 }, { 1, 1 }, { 2, 1 } }, { { 0, 0 }, { 0, 1 }, { 1, -1 }, { 1, 0 } },
			{ { 0, 0 }, { 1, -1 }, { 1, 0 }, { 2, -1 } }, { { 0, 0 }, { 0, 1 }, { 1, 1 }, { 1, 2 } },
			{ { 0, 0 }, { 0, 1 }, { 0, 2 }, { 1, 1 } }, { { 0, 0 }, { 1, 0 }, { 1, 1 }, { 2, 0 } },
			{ { 0, 0 }, { 1, -1 }, { 1, 0 }, { 1, 1 } }, { { 0, 0 }, { 1, -1 }, { 1, 0 }, { 2, 0 } } };
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
		
		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int temp = tetromino(new Node(i, j));
				if (temp > max) {
					max = temp;
				}
			}
		}
		System.out.println(max);
	}

	public static int tetromino(Node x) {
		int max = 0;
		for (int i = 0; i < 19; i++) {
			int val = 0;
			for (final int[] NEXT : TETROMINO[i]) {
				int nextRow = x.x + NEXT[ROW];
				int nextCol = x.y + NEXT[COL];
				
				if (nextRow < 0 || nextRow > N - 1 || nextCol < 0 || nextCol > M - 1) {
					val = 0;
					break;
				}
				val += board[nextRow][nextCol];
			}
			
			if (val > max) {
				max = val;
			}
		}
		
		return max;
	}
	
	public static class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
