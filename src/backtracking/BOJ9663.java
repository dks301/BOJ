package backtracking;

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
	private static boolean[] check_col, check_diag1, check_diag2;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		check_col = new boolean[N];
		check_diag1 = new boolean[N + N];
		check_diag2 = new boolean[N + N];

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
			if (check(row, col)) {
				check_col[col] = true;
				check_diag1[row + col] = true;
				check_diag2[row - col + N - 1] = true;
				
				dfs(row + 1);
				
				check_col[col] = false;
				check_diag1[row + col] = false;
				check_diag2[row - col + N - 1] = false;
			}
		}
	}

	public static boolean check(int row, int col) {
		if (check_col[col]) {
			return false;
		}
		
		if (check_diag1[row + col]) {
			return false;
		}
		
		if (check_diag2[row - col + N - 1]) {
			return false;
		}
		return true;
	}
}
