package realization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2442 {
	private static final String SPACE = " ";
	private static final String STAR = "*";
	private static final String NEW_LINE = "\n";
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = i; j < N - 1; j++) {
				sb.append(SPACE);
			}
			for (int j = 0; j < (2 * i + 1); j++) {
				sb.append(STAR);
			}
			sb.append(NEW_LINE);
		}
		System.out.println(sb.toString());
	}
}
