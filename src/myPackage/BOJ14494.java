package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 다이나믹이 뭐예요?
 * →, ↓, ↘의 세 방향만 사용해서 한 번에 한 칸씩 이동할 때, 왼쪽 위 (1, 1)에서 출발하여 오른쪽 아래 (n, m)에 도착하는 경우의 수를 구하여라.
 * n과 m이 주어진다. (1 <= n, m <= 1,000)
 * 경우의 수를 1,000,000,007로 나눈 나머지를 출력
 */
public class BOJ14494 {
	private static final int MOD = 1_000_000_007;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		long[][] d = new long[n + 1][m + 1];
		d[0][0] = 1;
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				d[i][j] = ((d[i][j - 1] % MOD) + (d[i - 1][j] % MOD) + (d[i - 1][j - 1] % MOD)) % MOD;
			}
		}
		
		System.out.println(d[n][m]);
	}
}
