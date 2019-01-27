package eratosthenesSieve;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1929 {
	private static final int INF = 1000000;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
	
		boolean[] notPrime = new boolean[INF];
		notPrime[0] = notPrime[1] = true;
		for (int i = 2; i < INF; i++) {
			if (!notPrime[i]) {
				for (int j = i + i; j < INF; j += i) {
					notPrime[j] = true;
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = M; i <= N; i++) {
			if (!notPrime[i])
				sb.append(i + "\n");
		}
		System.out.println(sb.toString());
	}
}
