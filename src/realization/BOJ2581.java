package realization;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ2581 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		boolean[] isNotPrime = new boolean[10001];
		isNotPrime[0] = true;
		isNotPrime[1] = true;
		for (int i = 2; i < 10001; i++) {
			if (!isNotPrime[i]) {
				for (int j = i * i; j < 10001; j += i) {
					isNotPrime[j] = true;
				}
			}
		}
		
		int sum = 0;
		int min = 0;
		boolean isFirst = true;
		for (int i = M; i <= N; i++) {
			if (!isNotPrime[i]) {
				if (isFirst) {
					isFirst = false;
					min = i;
				}
				sum += i;
			}
		}
		System.out.println(isFirst == true ? "-1" : sum + "\n" + min);
		
	}
}
