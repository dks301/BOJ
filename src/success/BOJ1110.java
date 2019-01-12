package success;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ1110 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int A, B;
		if (N < 10) {
			A = 0;
			B = N;
		}
		else {
			A = N / 10;
			B = N % 10;
		}
		int num = N;
		int count = 0;
		while (true) {
			int sum = A + B >= 10 ? A + B - 10 : A + B;
			num = B * 10 + sum;
			count++;
			if (N == num)
				break;
			if (num < 10) {
				A = 0;
				B = num;
			}
			else {
				A = num / 10;
				B = num % 10;
			}
		}
		System.out.println(count);
	}
}
