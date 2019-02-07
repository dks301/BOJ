package eratosthenesSieve;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 골드바흐의 추측
 * 4보다 큰 모든 짝수는 두 홀수 소수의 합으로 나타낼 수 있다.(=골드바흐의 추측 10^16이하는 증명 완료)
 * 짝수 정수 n이 주어질 때, n = a + b형태로 출력(a, b는 소수 & 여러가지라면 b-a가 가장 큰 것으로 출력)
 */
public class BOJ6588 {
	private static final String NEW_LINE = "\n";
	private static final String PLUS = " + ";
	private static final String EQUAL = " = ";

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[] isNotPrime = new boolean[1000001];
		isNotPrime[0] = true;
		isNotPrime[1] = true;
		for (int i = 2; i <= 1000000; i++) {
			if (!isNotPrime[i]) {
				for (int j = i + i; j <= 1000000; j += i) {
					isNotPrime[j] = true;
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		int n;
		while ((n = Integer.parseInt(br.readLine())) != 0) {
			int x = 0;
			for (int i = 3; i <= n / 2; i++) {
				x = n - i;
				if (!isNotPrime[i] && !isNotPrime[x]) {
					sb.append(n).append(EQUAL).append(i).append(PLUS).append(x).append(NEW_LINE);
					break;
				} 
			}
		}
		System.out.println(sb.toString());
	}
}
