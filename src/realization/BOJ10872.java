package realization;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ10872 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int result = 1;
		for (int i = N; i > 1; i--) {
			result *= i;
		}
		System.out.println(result);
	}
}
