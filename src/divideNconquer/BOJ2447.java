package divideNconquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 별 찍기-10
 * 예제를 보고 규칙을 유추한 뒤에 별 찍기
 * 
 * 입력
 * 첫째줄: N(N은 항상 3의 제곱꼴, 3<=N<=2187)
 * 
 * 출력
 * 별 출력
 */
public class BOJ2447 {
	private static char[][] result;
	private static final char STAR = '*';
	private static final char SPACE = ' ';
	private static final char NEW_LINE = '\n';
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		result = new char[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(result[i], STAR);
		}
		
		solve(0, 0, N);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(result[i][j]);
			}
			sb.append(NEW_LINE);
		}
		System.out.print(sb);
	}
	
	public static void solve(int x, int y, int n) {
		if (n == 1) {
			return;
		}
		int val = n / 3;
		
		for (int i = x + val; i < x + (2 * val); i++) {
			for (int j = y + val; j < y + (2 * val); j++) {
				result[i][j] = SPACE;
			}
		}
		for (int i = x; i < x + n; i += val) {
			for (int j = y; j < y + n; j += val) {
				if (!(i == x + val && j == y + val)) {
					solve(i, j, val);
				}
			}
		}
	}
}
