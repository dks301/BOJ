package eratosthenesSieve;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/*
 * 거의 소수
 * 어떤 수가 소수의 N 제곱 꼴일때, 그 수를 거의 소수라 한다.
 * A와 B가 주어질 때 A(<=10^14), B(A<=B<=10^14)
 * A <= 거의 소수 <= B 인 거의 소수의 수 출력.
 */
public class BOJ1456 {
	private static final int INF = 10_000_001;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());

		boolean[] isNotPrime = new boolean[INF];
		isNotPrime[0] = true;
		isNotPrime[1] = true;
		for (int i = 2; i < INF; i++) {
			if (isNotPrime[i] == false) {
				for (long j = (long)i * i; j < INF; j += i) {
					isNotPrime[(int)j] = true;
				}
			}
		}

		int ans = 0;
		for (int i = 2; i < INF; i++) {
			if (isNotPrime[i] == false) {
				long temp = (long)i * i;
				
				for (long j = temp; j <= B; j = j * i) {
					if (j < A) {
						continue;
					}
					ans++;
					
					if (shift(j) + shift(i) > 62) { // 2진수 두 수를 곱했을 때의 자리수는 각 자릿수 의 합 -1
						break;
					}
				}
			}
		}
		System.out.println(ans);
	}
	
	public static int shift(long x) {
		int cnt = 0;
		while (x != 0) {
			x = x >> 1;
			cnt++;
		}
		return cnt;
	}
}
