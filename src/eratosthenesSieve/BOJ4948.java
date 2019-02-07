package eratosthenesSieve;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
 * 베르트랑 공준
 * 임의의 자연수 n에 대하여, n보다 크고 2n보다 작거나 같은 소수는 적어도 하나 존재한다(= 베르트랑 공준)
 * n이 주어졌을 때, n보다 크고 2n보다 작거나 같은 소수의 갯수 출력
 */
public class BOJ4948 {
	private static final String ENTER = "\n";
	private static final int MAX = 246912; // max 2n(n <= 123456)
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		boolean[] isNotPrime = new boolean[MAX + 1];
		isNotPrime[0] = true;
		isNotPrime[1] = true;
		
		for (int i = 2; i <= MAX; i++) { // Find the 1 ~ MAX is prime or not.
			if (isNotPrime[i]) // skip if checked already.
				continue;
			for (int j = 2 * i; j <= MAX; j += i)
				isNotPrime[j] = true;
		}
		
		while (true) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0)
				break;
			int primeNum = 0;
			for (int i = n + 1; i <= 2 * n; i++) {
				if (!isNotPrime[i])
					primeNum++;
			}
			sb.append(primeNum).append(ENTER);
		}
		br.close();
		System.out.println(sb.toString());
		
	}
}
