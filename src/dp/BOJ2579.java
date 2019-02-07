package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * 계단 오르기
 * 1. 계단은 한 번에 한 계단씩 또는 두 계단씩 오를 수 있다.
 * 2. 연속된 세 개의 계단을 모두 밟아서는 안 된다. 단, 시작점 포함x
 * 3. 마지막 계단은 반드시 밟아야 한다.
 * 위 3조건을 만족하는 총 점수의 최댓값 출력.
 */
public class BOJ2579 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			a[i] = Integer.parseInt(br.readLine());
		}
		
		int[][] d = new int[n + 1][3];
		d[1][0] = 0;
		d[1][1] = a[1];
		d[1][2] = 0;
		for (int i = 2; i <= n; i++) {
			d[i][0] = Math.max(d[i - 1][1], d[i - 1][2]);
			d[i][1] = d[i - 1][0] + a[i];
			d[i][2] = d[i - 1][1] + a[i];
		}
		System.out.println(Math.max(d[n][1], d[n][2]));
	}
}
