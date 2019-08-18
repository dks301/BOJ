package bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ16637 {
	private static int N, ans;
	private static char[] a;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		a = br.readLine().toCharArray(); // 짝수자리 숫자, 홀수자리 연산자
		ans = Integer.MIN_VALUE;
		
		dfs(a[0] - '0', 0);
		System.out.println(ans);
	}

	public static void dfs(int value, int idx) {
		if (idx == N - 1) {
			if (value > ans) {
				ans = value;
			}
			return;
		}

		dfs(operation(value, a[idx + 1], a[idx + 2] - '0'), idx + 2);

		if (idx < N - 3) {
			int temp = operation(a[idx + 2] - '0', a[idx + 3], a[idx + 4] - '0');
			dfs(operation(value, a[idx + 1], temp), idx + 4);
		}
	}

	public static int operation(int a, char op, int b) {
		switch (op) {
		case '+':
			return a + b;

		case '-':
			return a - b;

		case '*':
			return a * b;
		}

		return Integer.MIN_VALUE; // error!
	}
}
