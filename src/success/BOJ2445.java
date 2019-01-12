package success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2445 {
	private static final String NEW_LINE = "\n";
	private static final String SPACE = " ";
	private static final String STAR = "*";
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i + 1; j++) {
				sb.append(STAR);
			}
			for (int j = 0; j < N - i - 1; j++) {
				sb.append(SPACE);
			}
			for (int j = 0; j < N - i - 1; j++) {
				sb.append(SPACE);
			}
			for (int j = 0; j < i + 1; j++) {
				sb.append(STAR);
			}
			sb.append(NEW_LINE);
		}
		for (int i = 0; i < N - 1; i++) {
			for (int j = 0; j < N - i - 1; j++) {
				sb.append(STAR);
			}
			for (int j = 0; j < i + 1; j++) {
				sb.append(SPACE);
			}
			for (int j = 0; j < i + 1; j++) {
				sb.append(SPACE);
			}
			for (int j = 0; j < N - i - 1; j++) {
				sb.append(STAR);
			}
			sb.append(NEW_LINE);
		}
		System.out.println(sb.toString());
	}
}
