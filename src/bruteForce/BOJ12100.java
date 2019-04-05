package bruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * 2048(Easy)
 * N*N 보드의 2048게임(1<=N<=20)
 * 0은 빈칸, 이외의 값은 블록
 * 블록은 2보다 크거나 같고, 1024보다 작거나 같은 2의 제곱꼴
 * 한 번의 이동에서 이미 합쳐진 블록은 또 합쳐질 수 없다.
 * 최대 5번 이동시켜서 얻을 수 있는 가장 큰 블록 출력
 */
public class BOJ12100 {
	private static int[][] board;
	private static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int max = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				for (int k = 0; k < 4; k++) {
					for (int l = 0; l < 4; l++) {
						for (int m = 0; m < 4; m++) {
							int[][] temp = deepCopy();
							move(i, temp);
							move(j, temp);
							move(k, temp);
							move(l, temp);
							move(m, temp);
							
							int tempMax = findMax(temp);
							if (max < tempMax) {
								max = tempMax;
							}
						}
					}
				}
			}
		}
		System.out.println(max);
	}
	
	public static int findMax(int[][] board) {
		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] > max) {
					max = board[i][j];
				}
			}
		}
		return max;
	}
	
	public static int[][] deepCopy() {
		int[][] temp = new int[N][N];
		for (int i = 0; i < N; i++) {
			System.arraycopy(board[i], 0, temp[i], 0, board[i].length);
		}
		return temp;
	}
	
	public static void move(int num, int[][] board) {
		switch(num) {
		case 0:
			up(board);
			break;
			
		case 1:
			down(board);
			break;
			
		case 2:
			left(board);
			break;
			
		case 3:
			right(board);
			break;
		}
	}
	public static void up(int[][] board) {
		for (int j = 0; j < N; j++) {
			for (int i = 0; i < N; i++) {
				if (board[i][j] != 0) {
					for (int k = i + 1; k < N; k++) {
						if (board[k][j] != 0) {
							if (board[k][j] == board[i][j]) {
								board[i][j] = 2 * board[i][j];
								board[k][j] = 0;
							}
							break;
						}
					}
				} else {
					for (int k = i + 1; k < N; k++) {
						if (board[k][j] != 0) {
							board[i][j] = board[k][j];
							board[k][j] = 0;
							i--;
							break;
						}
					}
				}
			}
		}
	}

	public static void down(int[][] board) {
		for (int j = N - 1; j >= 0; j--) {
			for (int i = N - 1; i >= 0; i--) {
				if (board[i][j] != 0) {
					for (int k = i - 1; k >= 0; k--) {
						if (board[k][j] != 0) {
							if (board[k][j] == board[i][j]) {
								board[i][j] = 2 * board[i][j];
								board[k][j] = 0;
							}
							break;
						}
					}
				} else {
					for (int k = i - 1; k >= 0; k--) {
						if (board[k][j] != 0) {
							board[i][j] = board[k][j];
							board[k][j] = 0;
							i++;
							break;
						}
					}
				}
			}
		}
	}

	public static void left(int[][] board) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] != 0) {
					for (int k = j + 1; k < N; k++) {
						if (board[i][k] != 0) {
							if (board[i][k] == board[i][j]) {
								board[i][j] = 2 * board[i][j];
								board[i][k] = 0;
							}
							break;
						}
					}
				} else {
					for (int k = j + 1; k < N; k++) {
						if (board[i][k] != 0) {
							board[i][j] = board[i][k];
							board[i][k] = 0;
							j--;
							break;
						}
					}
				}
			}
		}
	}

	public static void right(int[][] board) {
		for (int i = N - 1; i >= 0; i--) {
			for (int j = N - 1; j > 0; j--) {
				if (board[i][j] != 0) {
					for (int k = j - 1; k >= 0; k--) {
						if (board[i][k] != 0) {
							if (board[i][k] == board[i][j]) {
								board[i][j] = 2 * board[i][j];
								board[i][k] = 0;
							}
							break;
						}
					}
				} else {
					for (int k = j - 1; k >= 0; k--) {
						if (board[i][k] != 0) {
							board[i][j] = board[i][k];
							board[i][k] = 0;
							j++;
							break;
						}
					}
				}
			}
		}
	}
}
