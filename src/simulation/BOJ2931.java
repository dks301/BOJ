package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2931 {
	private static int R, C;
	private static char[][] map;
	private static boolean[][][] check;
	private static boolean isEnd = false;
	private static Node M, Z;

	private static final int[][] DIRECTIONS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	private static final int ROW = 0;
	private static final int COL = 1;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		check = new boolean[R][C][2]; // 0: vertical, 1: horizontal
		M = Z = null;

		for (int i = 0; i < R; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				map[i][j] = temp[j];
				if (map[i][j] == 'M') {
					M = new Node(i, j);

				} else if (map[i][j] == 'Z') {
					Z = new Node(i, j);
				}
			}
		}
		
		Node ans = null;
		char board = '0';
		boolean isTrue = false;
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == '.') {

					check = new boolean[R][C][2];
					char[][] temp = deepCopy();
					temp[i][j] = '|';
					go(temp, null, M);
					if (isPossible(temp)) {
						isTrue = true;
						ans = new Node(i, j);
						board = temp[i][j];
						break;
					}
					
					check = new boolean[R][C][2];
					temp[i][j] = '-';					
					go(temp, null, M);
					if (isPossible(temp)) {
						isTrue = true;
						ans = new Node(i, j);
						board = temp[i][j];
						break;
					}
					
					check = new boolean[R][C][2];
					temp[i][j] = '+';
					go(temp, null, M);
					if (isPossible(temp)) {
						isTrue = true;
						ans = new Node(i, j);
						board = temp[i][j];
						break;
					}
					
					check = new boolean[R][C][2];
					temp[i][j] = '1';
					go(temp, null, M);
					if (isPossible(temp)) {
						isTrue = true;
						ans = new Node(i, j);
						board = temp[i][j];
						break;
					}
					
					check = new boolean[R][C][2];
					temp[i][j] = '2';
					go(temp, null, M);
					if (isPossible(temp)) {
						isTrue = true;
						ans = new Node(i, j);
						board = temp[i][j];
						break;
					}
					
					check = new boolean[R][C][2];
					temp[i][j] = '3';
					go(temp, null, M);
					if (isPossible(temp)) {
						isTrue = true;
						ans = new Node(i, j);
						board = temp[i][j];
						break;
					}
					
					check = new boolean[R][C][2];
					temp[i][j] = '4';
					go(temp, null, M);
					if (isPossible(temp)) {
						isTrue = true;
						ans = new Node(i, j);
						board = temp[i][j];
						break;
					}
				}
			}
			if (isTrue) {
				break;
			}
		}
		
		System.out.println((ans.row + 1) + " " + (ans.col + 1) + " " + board);
	}
	
	public static char[][] deepCopy() {
		char[][] result = new char[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				result[i][j] = map[i][j];
			}
		}
		return result;
	}
	public static boolean isPossible(char[][] m) {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (m[i][j] != '.') {
					if (map[i][j] == '+') {
						if (!check[i][j][0]) {
							return false;
						} else if (!check[i][j][1]) {
							return false;
						}
					} else {
						if (!check[i][j][0]) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}
	
	public static void go(char[][] map, Node prev, Node cur) {
		int nextRow, nextCol;
		nextRow = nextCol = -1;

		switch (map[cur.row][cur.col]) {
		case 'M':
			for (final int[] D : DIRECTIONS) {
				nextRow = cur.row + D[ROW];
				nextCol = cur.col + D[COL];
				if (nextRow < 0 || nextCol < 0 || nextRow > R - 1 || nextCol > C - 1) {
					continue;
				}

				if (map[nextRow][nextCol] == '.') {
					continue;
				}
				
				go(map, cur, new Node(nextRow, nextCol));
				if (!isEnd) {
					check = new boolean[R][C][2];
				}
				check[cur.row][cur.col][0] = true;
			}
			break;

		case '|':
			check[cur.row][cur.col][0] = true;
			nextRow = cur.row + (cur.row - prev.row);
			nextCol = cur.col;
			if (cur.col - prev.col != 0) {
				return;
			}
			if (nextRow < 0 || nextCol < 0 || nextRow > R - 1 || nextCol > C - 1) {
				return;
			}
			if (map[nextRow][nextCol] == '.') {
				return;
			}
			if (nextRow == cur.row && nextCol == cur.col) {
				return;
			}
			go(map, cur, new Node(nextRow, nextCol));
			break;

		case '-':
			check[cur.row][cur.col][0] = true;
			nextRow = cur.row;
			nextCol = cur.col + (cur.col - prev.col);
			if (cur.row - prev.row != 0) {
				return;
			}
			if (nextRow < 0 || nextCol < 0 || nextRow > R - 1 || nextCol > C - 1) {
				return;
			}
			if (map[nextRow][nextCol] == '.') {
				return;
			}

			if (nextRow == cur.row && nextCol == cur.col) {
				return;
			}
			go(map, cur, new Node(nextRow, nextCol));
			break;

		case '+':
			if (cur.row - prev.row == 0) {
				check[cur.row][cur.col][1] = true;
			} else {
				check[cur.row][cur.col][0] = true;
			}
			nextRow = cur.row + (cur.row - prev.row);
			nextCol = cur.col + (cur.col - prev.col);
			if (nextRow < 0 || nextCol < 0 || nextRow > R - 1 || nextCol > C - 1) {
				return;
			}
			if (map[nextRow][nextCol] == '.') {
				return;
			}
			if (nextRow == cur.row && nextCol == cur.col) {
				return;
			}
			
			if (cur.row - prev.row == 0) {
				go(map, cur, new Node(nextRow, nextCol));
			} else {
				go(map, cur, new Node(nextRow, nextCol));
			}
			break;

		case '1':
			check[cur.row][cur.col][0] = true;
			if (cur.row - prev.row == 0) {
				if (cur.col - prev.col == 1) {
					return;
				}
				nextRow = cur.row + 1;
				nextCol = cur.col;
			} else {
				if (cur.row - prev.row == 1) {
					return;
				}
				nextRow = cur.row;
				nextCol = cur.col + 1;
			}
			if (nextRow < 0 || nextCol < 0 || nextRow > R - 1 || nextCol > C - 1) {
				return;
			}
			if (map[nextRow][nextCol] == '.') {
				return;
			}
			if (nextRow == cur.row && nextCol == cur.col) {
				return;
			}
			
			go(map, cur, new Node(nextRow, nextCol));
			break;

		case '2':
			check[cur.row][cur.col][0] = true;
			if (cur.row - prev.row == 0) {
				if (cur.col - prev.col == 1) {
					return;
				}
				nextRow = cur.row - 1;
				nextCol = cur.col;
			} else {
				if (cur.row - prev.row == -1) {
					return;
				}
				nextRow = cur.row;
				nextCol = cur.col + 1;
			}
			if (nextRow < 0 || nextCol < 0 || nextRow > R - 1 || nextCol > C - 1) {
				return;
			}
			if (map[nextRow][nextCol] == '.') {
				return;
			}
			if (nextRow == cur.row && nextCol == cur.col) {
				return;
			}
			
			go(map, cur, new Node(nextRow, nextCol));
			break;

		case '3':
			check[cur.row][cur.col][0] = true;
			if (cur.row - prev.row == 0) {
				if (cur.col - prev.col == -1) {
					return;
				}
				nextRow = cur.row - 1;
				nextCol = cur.col;
			} else {
				if (cur.row - prev.row == -1) {
					return;
				}
				nextRow = cur.row;
				nextCol = cur.col - 1;
			}
			if (nextRow < 0 || nextCol < 0 || nextRow > R - 1 || nextCol > C - 1) {
				return;
			}
			if (map[nextRow][nextCol] == '.') {
				return;
			}
			if (nextRow == cur.row && nextCol == cur.col) {
				return;
			}
			
			go(map, cur, new Node(nextRow, nextCol));
			break;

		case '4':
			check[cur.row][cur.col][0] = true;
			if (cur.row - prev.row == 0) {
				if (cur.col - prev.col == -1) {
					return;
				}
				nextRow = cur.row + 1;
				nextCol = cur.col;
			} else {
				if (cur.row - prev.row == 1) {
					return;
				}
				nextRow = cur.row;
				nextCol = cur.col - 1;
			}
			
			if (map[nextRow][nextCol] == '.') {
				return;
			}
			if (nextRow == cur.row && nextCol == cur.col) {
				return;
			}
			
			go(map, cur, new Node(nextRow, nextCol));
			break;
			
		case 'Z':
			check[cur.row][cur.col][0] = true;
			isEnd = true;
			break;
		}
	}

	public static class Node {
		int row, col;

		public Node(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
}
