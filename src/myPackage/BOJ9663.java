package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * N-Queen
 * NxN 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 문제
 * 
 * 입력
 * N(1<=N<=15)
 * 
 * 출력
 * 퀸 N개를 서로 공격할 수 없게 놓는 경우의 수를 출력
 */
public class BOJ9663 {
	private static int N, ans;
	private static boolean[][] map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new boolean[N][N];
		
		ans = 0;
		dfs(0);
		
		System.out.println(ans);
	}
	
	public static void dfs(int row) {
		if (row == N) {
			ans++;
			return;
		}
		for (int col = 0; col < N; col++) {
			map[row][col] = true;
			if (check(row, col)) {
				dfs(row + 1);
			}
			map[row][col] = false;
		}
	}
	
	public static boolean check(int row, int col) {
		for (int i = 0; i < row; i++) { // 위
			if (map[i][col]) {
				return false;
			}
		}
		
		int x = row - 1;
		int y = col - 1;
		while (x >= 0 && y >= 0) { // 왼쪽위 대각선
			if (map[x][y]) {
				return false;
			}
			x--;
			y--;
		}
		
		x = row - 1;
		y = col + 1;
		while (x >= 0 && y < N) { // 오른쪽위 대각선
			if (map[x][y]) {
				return false;
			}
			x--;
			y++;
		}
		
		return true;
	}
}
