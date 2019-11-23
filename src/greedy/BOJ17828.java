package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17828 {
	private static final char A = 'A';
	private static final char Z = 'Z';
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		if (!isPossible(N, X)) { // 전부 A, Z여도 불가능
			System.out.println("!");
			System.exit(0);
		}
		
		System.out.println(solve(N, X));
	}
	
	public static boolean isPossible(int N, int X) {
		return (N * 26) >= X ? (N <= X ? true : false) : false;
	}
	
	public static String solve(int N, int X) {
		StringBuilder sb = new StringBuilder();
		int sum = N;
		
		for (int i = N - 1; i >= 0; i--) {
			int remainder = X - sum;
			if (remainder == 0) {
				sb.append(A);
			} else if (remainder >= 26){
				sb.append(Z);
				sum += 25; // 'Z' - 'A'
			} else { // 0 < remainder < 26
				sb.append((char)(A + remainder));
				sum += remainder;
			}
		}
		
		return sb.reverse().toString();
	}
}
