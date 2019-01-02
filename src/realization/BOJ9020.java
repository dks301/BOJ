package realization;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ9020 {
	private static final String SPACE = " ";
	private static final String NEW_LINE = "\n";
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		boolean[] isNotPrime = new boolean[9974];
		isNotPrime[0] = true;
		isNotPrime[1] = true;
		for (int i = 2; i < 9974; i++) {
			if (!isNotPrime[i]) {
				for (int j = i * i; j < 9974; j += i) {
					isNotPrime[j] = true;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			int temp = n / 2;
			int j = 0, k = 0;
			for (j = n / 2; j < 9974; j++) {
				if (!isNotPrime[j]) {
					for (k = temp; k >= 2; k--) {
						if (!isNotPrime[k] && j + k <= n) {
							temp = k;
							break;
						}
					}
					if (j + k == n)
						break;
				}
			}
			sb.append(k + SPACE + j).append(NEW_LINE);
		}
		System.out.println(sb.toString());
	}
}
