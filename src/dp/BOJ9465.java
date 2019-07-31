package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 스티커
 * 스티커 한 장을 떼면, 그 스티커와 변을 공유하는 스티커는 모두 찢어진다.
 * 스티커 2n개 중 여러개를 뗄 때, 스티커 점수의 최댓값을 출력  
 */
public class BOJ9465 {
	private static final char NEW_LINE = '\n';
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			
			int[][] s = new int[2][n + 1];
			for (int j = 1; j <= n; j++) {
				s[0][j] = Integer.parseInt(st1.nextToken());
			}
			for (int j = 1; j <= n; j++) {
				s[1][j] = Integer.parseInt(st2.nextToken());
			}
			
			int[][] d = new int[n + 1][3];
			for (int j = 1; j <= n; j++) {
				d[j][0] = max(d[j - 1][0], d[j - 1][1], d[j - 1][2]);
				d[j][1] = Math.max(d[j - 1][0], d[j - 1][2]) + s[0][j];
				d[j][2] = Math.max(d[j - 1][0], d[j - 1][1]) + s[1][j];
			}
			sb.append(max(d[n][0], d[n][1], d[n][2])).append(NEW_LINE);
		}
		System.out.println(sb);
	}
	
	public static int max(int a, int b, int c) {
		return Math.max(Math.max(a, b), c);
	}
}
