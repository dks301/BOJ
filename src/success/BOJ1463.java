package success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1463 {
	private static final int MAX = 1000001;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // <= 1,000,000
		int[] memo = new int[N + 1];
		memo[1] = 0;
		for (int i = 2; i < N + 1; i++) {
			int temp1 = MAX;
			int temp2 = MAX;
			int temp3 = MAX;
			if (i % 3 == 0) {
				temp1 = memo[i / 3] + 1;
			}
			if (i % 2 == 0) {
				temp2 = memo[i / 2] + 1;
			}
			temp3 = memo[i - 1] + 1;
			memo[i] = min(temp1, temp2, temp3);
		}
		System.out.println(memo[N]);
	}
	
	public static int min(int a, int b, int c) {
		return a < (b = b < c ? b : c) ? a : b;
	}
}
