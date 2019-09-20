package realization;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ2231 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] ans = new int[1_000_054];
		for (int i = 1; i <= 1_000_000; i++) {
			int temp = calculation(i);
			if (ans[temp] == 0) {
				ans[temp] = i;
			} else if (ans[temp] > i) {
				ans[temp] = i;
			}
		}
		
		System.out.println(ans[N]);
	}
	
	public static int calculation(int M) {
		int N = M;
		
		while (M / 10 != 0) {
			N += M % 10;
			M /= 10;
		}
		
		return N + M;
	}
}
