package success;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ8393 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int result = 0;

		for (int i = 1; i <= N; i++) {
			result += i;
		}
		System.out.println(result);
	}
}
