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
 * 
 * 10 10
##########
#R.....#B#
#........#
#........#
#........#
#........#
#........#
#.....#..#
#....#O..#
##########
 */
public class BOJ13460 {
	private static char[][] board;
	private static int[][] check;
	private static Ball[] ball;
	private static int N, M, ans = 11;
	
	private static final char WALL = '#';
	private static final char HOLE = 'O';

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new char[N][M];
		check = new int[N][M];
		ball = new Ball[2]; // 0: red , 1: blue
		
		for (int i = 0; i < N; i++) {
			board[i] = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				if (board[i][j] == WALL) {
					check[i][j] = 1;
				} else if (board[i][j] == 'R') {
					ball[0] = new Ball(i, j);
				} else if (board[i][j] == 'B') {
					ball[1] = new Ball(i, j);
				}
			}
		}
		
		dfs(ball, 1);
		System.out.println(ans == 11 ? -1 : ans);
	}
	
	public static Ball[] deepCopy(Ball[] b) {
		Ball[] next = new Ball[2];
		next[0] = new Ball(b[0].x, b[0].y);
		next[1] = new Ball(b[1].x, b[1].y);
		return next;
	}
	
	public static void dfs(Ball[] b, int depth) {
		if (depth > 10) {
			return;
		}
//		System.out.print("depth: " + depth);
		// 위로 기울이기
		Ball[] next = deepCopy(b);
		int[] val = new int[4];
		val[0] = toUp(next);
		if (val[0] == 0) {
			System.out.print("위 ");
			dfs(next, depth + 1);
			System.out.println();
		}
		
		// 아래로기울이기
		next = deepCopy(b);
		val[1] = toDown(next);
		if (val[1] == 0) {
			System.out.print("아래 ");
			dfs(next, depth + 1);
			System.out.println();
		}
		
		// 왼쪽으로 기울이기
		next = deepCopy(b);
		val[2] = toLeft(next);
		if (val[2] == 0) {
			System.out.print("왼쪽 ");
			dfs(next, depth + 1);
			System.out.println();
		}
		
		// 오른쪽으로 기울이기
		next = deepCopy(b);
		val[3] = toRight(next);
		if (val[3] == 0) {
			System.out.print("오른쪽 ");
			dfs(next, depth + 1);
			System.out.println();
		}
		
		for (int i = 0; i < 4; i++) {
			if (val[i] == 1) {
				if (ans > depth) {
					ans = depth;
				}
			}
		}
	}

	public static int toLeft(Ball[] b) { // -1 파랑구슬이 골인, 0 다음으로 진행, 1 빨간구슬만 골인
		int redRow = b[0].x;
		int redCol = b[0].y;
		int blueRow = b[1].x;
		int blueCol = b[1].y;
		
		if (redRow == blueRow) {
			if (redCol < blueCol) {
				while (board[redRow][redCol] != WALL) {
					redCol--;
					if (board[redRow][redCol] == HOLE) {
						return -1;
					}
				}
				b[0].y = redCol + 1;
				
				while (board[blueRow][blueCol] != WALL && blueCol != b[0].y) {
					blueCol--;
					if (board[blueRow][blueCol] == HOLE) {
						return -1;
					}
				}
				b[1].y = blueCol + 1;
				
			} else {
				while (board[blueRow][blueCol] != WALL) {
					blueCol--;
					if (board[blueRow][blueCol] == HOLE) {
						return -1;
					}
				}
				b[1].y = blueCol + 1;
				
				while (board[redRow][redCol] != WALL && redCol != b[1].y) {
					redCol--;
					if (board[redRow][redCol] == HOLE) {
						return -1;
					}
				}
				b[0].y = redCol + 1;
			}
			
		} else {
			while (board[redRow][redCol] != WALL) {
				redCol--;
				if (board[redRow][redCol] == HOLE) {
					return 1;
				}
			}
			b[0].y = redCol + 1;
			
			while (board[blueRow][blueCol] != WALL) {
				blueCol--;
				if (board[blueRow][blueCol] == HOLE) {
					return -1;
				}
			}
			b[1].y = blueCol + 1;
		}
		
		return 0;
	}

	public static int toRight(Ball[] b) { // -1 파랑구슬이 골인, 0 다음으로 진행, 1 빨간구슬만 골인
		int redRow = b[0].x;
		int redCol = b[0].y;
		int blueRow = b[1].x;
		int blueCol = b[1].y;
		
		if (redRow == blueRow) {
			if (redCol > blueCol) {
				while (board[redRow][redCol] != WALL) {
					redCol++;
					if (board[redRow][redCol] == HOLE) {
						return 1;
					}
				}
				b[0].y = redCol - 1;
				
				while (board[blueRow][blueCol] != WALL && blueCol != b[0].y) {
					blueCol++;
					if (board[blueRow][blueCol] == HOLE) {
						return -1;
					}
				}
				b[1].y = blueCol - 1;
				
			} else {
				while (board[blueRow][blueCol] != WALL) {
					blueCol++;
					if (board[blueRow][blueCol] == HOLE) {
						return -1;
					}
				}
				b[1].y = blueCol - 1;
				
				while (board[redRow][redCol] != WALL && redCol != b[1].y) {
					redCol++;
					if (board[redRow][redCol] == HOLE) {
						return 1;
					}
				}
				b[0].y = redCol - 1;
			}
			
		} else {
			while (board[redRow][redCol] != WALL) {
				redCol++;
				if (board[redRow][redCol] == HOLE) {
					return 1;
				}
			}
			b[0].y = redCol - 1;
			
			while (board[blueRow][blueCol] != WALL) {
				blueCol++;
				if (board[blueRow][blueCol] == HOLE) {
					return -1;
				}
			}
			b[1].y = blueCol - 1;
		}
		
		return 0;
	}

	public static int toUp(Ball[] b) { // -1 파랑구슬이 골인, 0 다음으로 진행, 1 빨간구슬만 골인
		int redRow = b[0].x;
		int redCol = b[0].y;
		int blueRow = b[1].x;
		int blueCol = b[1].y;
		
		if (redCol == blueCol) {
			if (redRow < blueRow) {
				while (board[redRow][redCol] != WALL) {
					redRow--;
					if (board[redRow][redCol] == HOLE) {
						return 1;
					}
				}
				b[0].x = redRow + 1;
				
				while (board[blueRow][blueCol] != WALL && blueRow != b[0].x) {
					blueRow--;
					if (board[blueRow][blueCol] == HOLE) {
						return -1;
					}
				}
				b[1].x = blueRow + 1;
				
			} else {
				while (board[blueRow][blueCol] != WALL) {
					blueRow--;
					if (board[blueRow][blueCol] == HOLE) {
						return -1;
					}
				}
				b[1].x = blueRow + 1;

				while (board[redRow][redCol] != WALL && redRow != b[1].x) {
					redRow--;
					if (board[redRow][redCol] == HOLE) {
						return 1;
					}
				}
				b[0].x = redRow + 1;
			}
			
		} else {
			while (board[redRow][redCol] != WALL) {
				redRow--;
				if (board[redRow][redCol] == HOLE) {
					return 1;
				}
			}
			b[0].x = redRow + 1;
			
			while (board[blueRow][blueCol] != WALL) {
				blueRow--;
				if (board[blueRow][blueCol] == HOLE) {
					return -1;
				}
			}
			b[1].x = blueRow + 1;
		}
		
		return 0;
	}

	public static int toDown(Ball[] b) { // -1 파랑구슬이 골인, 0 다음으로 진행, 1 빨간구슬만 골인
		int redRow = b[0].x;
		int redCol = b[0].y;
		int blueRow = b[1].x;
		int blueCol = b[1].y;
		
		if (redCol == blueCol) {
			if (redRow > blueRow) {
				while (board[redRow][redCol] != WALL) {
					redRow++;
					if (board[redRow][redCol] == HOLE) {
						return 1;
					}
				}
				b[0].x = redRow - 1;
				
				while (board[blueRow][blueCol] != WALL && blueRow != b[0].x) {
					blueRow++;
					if (board[blueRow][blueCol] == HOLE) {
						return -1;
					}
				}
				b[1].x = blueRow - 1;
				
			} else {
				while (board[blueRow][blueCol] != WALL) {
					blueRow++;
					if (board[blueRow][blueCol] == HOLE) {
						return -1;
					}
				}
				b[1].x = blueRow - 1;

				while (board[redRow][redCol] != WALL && redRow != b[1].x) {
					redRow++;
					if (board[redRow][redCol] == HOLE) {
						return 1;
					}
				}
				b[0].x = redRow - 1;
			}
			
		} else {
			while (board[redRow][redCol] != WALL) {
				redRow++;
				if (board[redRow][redCol] == HOLE) {
					return 1;
				}
			}
			b[0].x = redRow - 1;
			
			while (board[blueRow][blueCol] != WALL) {
				blueRow++;
				if (board[blueRow][blueCol] == HOLE) {
					return -1;
				}
			}
			b[1].x = blueRow - 1;
		}
		
		return 0;
	}

	public static class Ball {
		int x, y;

		public Ball(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
