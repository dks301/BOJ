package bruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
 * 한수
 * 어떤 양의 정수 X의 자릿수가 등차수열 = 한수
 * 1보다 크거나 같고, N보다 작거나 같은 한수의 갯수 출력
 */
public class BOJ1065 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		if (N < 100)
			System.out.println(N);
		else {
			int count = 99;
			for (int i = 100; i <= N; i++) {
				String temp = String.valueOf(i);
				int hundreds = Character.getNumericValue(temp.charAt(0));
				int tens = Character.getNumericValue(temp.charAt(1));
				int units = Character.getNumericValue(temp.charAt(2));
				
				if (hundreds - tens == tens - units)
					count++;
			}
			System.out.println(count);
		}
	}
}
