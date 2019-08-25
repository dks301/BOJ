package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA8016 {
	private static final char NUMBER = '#';
	private static final char SPACE = ' ';
	private static final char NEW_LINE = '\n';
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			sb.append(NUMBER).append(t).append(SPACE);
			
			long N = Long.parseLong(br.readLine());
			long right = 2 * N * N - 1;
			long left = right - (4 * N) + 4;
			sb.append(left).append(SPACE).append(right).append(NEW_LINE);
		}
		
		System.out.println(sb);
	}
}
