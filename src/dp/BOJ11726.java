package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * 2xn 타일링
 * 2xn 크기의 직사각형을 1x2, 2x1 타일로 채우는 방법의 수 출력
 */
public class BOJ11726 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] d = new int[n + 1];
		d[0] = 1;
		d[1] = 1;
		for (int i = 2; i <= n; i++) {
			d[i] = (d[i - 2] + d[i - 1]) % 10007;
		}
		System.out.println(d[n]);
	}
}
