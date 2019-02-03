package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * -2진수
 * (-2)^0=1, (-2)^1 =-2
 * -2진수: 1, 110, 111, 100, 101 -> 10진수: 1 ,2 ,3, 4
 */
public class BOJ2089 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		if (N == 0) {
			System.out.println(0);
			System.exit(0);
		}
		StringBuilder sb = new StringBuilder();
		while (N != 0) {
			int r = N % (-2);
			N = N / (-2);
			if (r == -1) {
				r = 1;
				N++;
			}
			sb.append(r);
		}
		System.out.println(sb.reverse().toString());
	}
}
