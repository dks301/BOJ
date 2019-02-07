package eratosthenesSieve;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
 * 골드바흐의 추측
 * 4보다 큰 모든 짝수는 두 홀수 소수의 합으로 나타낼 수 있다.(=골드바흐의 추측 10^16이하는 증명 완료)
 * 짝수 정수 n이 주어질 때, n = a + b이다, 이를 a b형태로 출력(a, b는 소수 & 여러가지라면 b-a가 가장 큰 것으로 출력)
 */
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
