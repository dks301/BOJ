package backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 알파벳
 * 세로R, 가로C칸으로 된 보드가 있다.
 * 보드의 각 칸에는 알파벳이 하나씩 적혀있고, 1행1열에는 말이 놓여있다
 * 말은 상화좌우로 인접한 네 칸으로 이동가능
 * 새로 이동한 칸에 적혀있는 알파벳은 지금까지 지나온 알파벳과 달라야한다
 * 좌측 상단에서 시작해서, 말이 최대한 몇 칸을 지날 수 있는지 찾기
 * 
 * 입력
 * 첫째줄: R C(1<=R,C<=20)
 * 둘째줄~R개줄: C개의 알파벳이 빈칸없이 주어진다
 * 
 * 출력
 * 말이 지날 수 있는 최대의 칸 수 출력
 */
public class BOJ1987 {
	private static int R, C, ans;
	private static char[][] board;
	private static boolean[] alpha;
	
	private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	private static final int ROW = 0;
	private static final int COL = 1;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new char[R][C];
		for (int i = 0; i < R; i++) {
			char[] in = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				board[i][j] = in[j];
			}
		}
		
		alpha = new boolean[26];
		alpha[board[0][0] - 'A'] = true;
		
		ans = 1;
		dfs(0, 0, 1);
		System.out.println(ans);
	}
	
	public static void dfs(int row, int col, int depth) {
		if (depth > ans) {
			ans = depth;
		}
		
		for (final int[] DIRECTION : DIRECTIONS) {
			int nextRow = row + DIRECTION[ROW];
			int nextCol = col + DIRECTION[COL];
			if (nextRow < 0 || nextCol < 0 || nextRow > R - 1 || nextCol > C - 1) {
				continue;
			}
			if (!alpha[board[nextRow][nextCol] - 'A']) {
				alpha[board[nextRow][nextCol] - 'A'] = true;
				dfs(nextRow, nextCol, depth + 1);
				alpha[board[nextRow][nextCol] - 'A'] = false;
			}
		}
	}
}
