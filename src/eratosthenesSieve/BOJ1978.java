package eratosthenesSieve;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 소수 찾기
 * 주어진 수들 중 소수의 갯수 출력
 */
public class BOJ1978 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		boolean[] isNotPrime = new boolean[1001];
		isNotPrime[0] = true;
		isNotPrime[1] = true;
		for (int i = 2; i < 1001; i++) {
			if (!isNotPrime[i]) {
				for (int j = i * i; j < 1001; j += i) {
					isNotPrime[j] = true;
				}
			}
		}
		
		int count = 0;
		for (int i = 0; i < N; i++) {
			if (!isNotPrime[Integer.parseInt(st.nextToken())])
				count++;
		}
		System.out.println(count);
	}
}
