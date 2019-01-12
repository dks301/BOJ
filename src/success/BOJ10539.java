package success;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10539 {
	private static final String SPACE = " ";
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		int[] B = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), SPACE);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			B[i] = Integer.parseInt(st.nextToken());
			int sum = 0;

			for (int j = 0; j < i; j++) {
				sum += A[j];
			}
			A[i] = B[i] * (i + 1) - sum;
			sb.append(A[i]).append(SPACE);
		}
		System.out.println(sb.toString());
	}
}
