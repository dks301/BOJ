package eratosthenesSieve;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2960 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int count = 0;
		
		int[] integer = new int[N + 1];
		for (int i = 2; i < N + 1; i++)
			integer[i] = i;
		
		for (int i = 2; i < N + 1; i++) {
			if (integer[i] != 0 && count < K) {
				for (int j = 1; i * j < N + 1; j++) {
					if (integer[i * j] != 0) {
						count++;
						if (count == K) {
							System.out.println(integer[i * j]);
							break;
						}
						integer[i * j] = 0;
					}
				}
			}
		}
	}
}
