package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * 피보나치 함수
 * 0 <= N <= 40
 * N번째 피보나치 함수에서 fib[0]과 fib[1]이 출력되는 횟수
 */
public class BOJ1003 {
	private static final String SPACE = " ";
	private static final String NEW_LINE = "\n";
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		int[] fib = new int[41];
		fib[0] = 0;
		fib[1] = 1;
		int temp, current = 1, last = 1;
		for (int i = 2; i <= 40; i++) {
			temp = current;
			current += last;
			last = temp;
			fib[i] = last;
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0) {
				sb.append("1").append(SPACE).append("0").append(NEW_LINE);
			} else {
				sb.append(fib[n - 1]).append(SPACE).append(fib[n]).append(NEW_LINE);
			}
		}
		System.out.println(sb.toString());
	}
}
