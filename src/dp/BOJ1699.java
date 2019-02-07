package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * 제곱수의 합
 * 주어진 자연수 N을 제곱수들의 합으로 표현할 때 최소 항의 갯수 출력
 */
public class BOJ1699 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] d = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			d[i] = i;
			for (int j = 1; j * j <= i; j++) {
				if (d[i] > d[i - j * j] + 1) {
					d[i] = d[i - j * j] + 1;
				}
			}
		}
		System.out.println(d[N]);
	}
}
