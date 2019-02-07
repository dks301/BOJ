package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * 이친수
 * 1. 이친수는 0으로 시작하지 않는다.
 * 2. 이친수에서는 1이 두 번 연속으로 나타나지 않는다.
 * 위 2조건을 만족하는 N자리 이진수(=이친수)의 갯수를 출력
 */
public class BOJ2193 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		long[] d = new long[91];
		d[0] = 0;
		d[1] = 1;
		for (int i = 2; i <= N; i++) {
			d[i] = d[i - 1] + d[i - 2];
		}
		System.out.println(d[N]);
	}
}
