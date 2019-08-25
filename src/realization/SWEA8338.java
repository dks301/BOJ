package realization;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA8338 {
	private static final char NUMBER = '#';
	private static final char SPACE = ' ';
	private static final char NEW_LINE = '\n';
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			sb.append(NUMBER).append(t).append(SPACE);
			
			int N = Integer.parseInt(br.readLine());
			int[] A = new int[N + 1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			
			int result = A[1];
			for (int i = 2; i <= N; i++) {
				result = calculation(result, A[i]);
			}
			
			sb.append(result).append(NEW_LINE);
		}
		System.out.println(sb);
	}
	
	public static int calculation(int a, int b) {
		int t1 = a + b;
		int t2 = a * b;
		
		return t1 > t2 ? t1 : t2;
	}
}
