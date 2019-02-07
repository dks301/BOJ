package eratosthenesSieve;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
 * 소수
 * M이상 N이하의 자연수 중 소수를 찾아서 합과 그 중 가장 작은 소수 찾기 
 */
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
