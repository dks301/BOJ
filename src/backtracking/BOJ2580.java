package backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 스도쿠
 * 스도쿠 게임 클리어하기
 * 
 * 입력
 * 9줄에 걸쳐 스도쿠 판이 주어진다. 빈 칸은 0
 * 
 * 출력
 * 모든 빈칸이 채워진 최종 스도쿠 판을 출력
 */
public class BOJ2580 {
	private static int[][] map;
	private static boolean[][] check_row, check_col, check_box;
	
	private static final char SPACE = ' ';
	private static final char NEW_LINE = '\n';

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[9][9];
		check_row = new boolean[9][10];
		check_col = new boolean[9][10];
		check_box = new boolean[9][10];
		for (int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0) {
					check_row[i][map[i][j]] = true;
					check_col[j][map[i][j]] = true;
					check_box[box(i, j)][map[i][j]] = true;
				}
			}
		}
		dfs(0);
	}
	
	public static int box(int row, int col) {
		return ((row / 3) * 3) + (col / 3);
	}
	
	public static boolean dfs(int z) {
		if (z == 81) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(map[i][j]).append(SPACE);
				}
				sb.append(NEW_LINE);
			}
			System.out.print(sb);
			return true;
		}
		
		int nextRow = z / 9;
		int nextCol = z % 9;
		
		if (map[nextRow][nextCol] != 0) {
			return dfs(z + 1);
		
		} else {
			for (int i = 1; i <= 9; i++) {
				if (!check_row[nextRow][i] && !check_col[nextCol][i] && !check_box[box(nextRow, nextCol)][i]) {
					check_row[nextRow][i] = check_col[nextCol][i] = check_box[box(nextRow, nextCol)][i] = true;
					map[nextRow][nextCol] = i;
					if (dfs(z + 1)) {
						return true;
					}
					map[nextRow][nextCol] = 0;
					check_row[nextRow][i] = check_col[nextCol][i] = check_box[box(nextRow, nextCol)][i] = false;
				}
			}
		}
		return false;
	}
}
