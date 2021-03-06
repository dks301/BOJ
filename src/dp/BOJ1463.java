package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * 1로 만들기
 * 1. X가 3으로 나누어 떨어지면, 3으로 나눈다.
 * 2. X가 2로 나누어 떨어지면, 2로 나눈다.
 * 3. 1을 뺀다.
 * 정수 N에 위 연산 3개를 적절히 사용해서 1을 만드는 최소 연산의 수 출력
 */
public class BOJ1463 {
	private static final int MAX = 1000001;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // <= 1,000,000
		int[] memo = new int[N + 1];
		memo[1] = 0;
		for (int i = 2; i < N + 1; i++) {
			int temp1 = MAX;
			int temp2 = MAX;
			int temp3 = MAX;
			if (i % 3 == 0) {
				temp1 = memo[i / 3] + 1;
			}
			if (i % 2 == 0) {
				temp2 = memo[i / 2] + 1;
			}
			temp3 = memo[i - 1] + 1;
			memo[i] = min(temp1, temp2, temp3);
		}
		System.out.println(memo[N]);
	}
	
	public static int min(int a, int b, int c) {
		return a < (b = b < c ? b : c) ? a : b;
	}
}
