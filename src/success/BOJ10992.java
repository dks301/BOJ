package success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10992 {
	private static final String NEW_LINE = "\n";
	private static final String SPACE = " ";
	private static final String STAR = "*";
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		if (N == 1) {
			sb.append(STAR);
		}
		else if (N == 2) {
			sb.append(SPACE).append(STAR).append(NEW_LINE);
			sb.append(STAR).append(STAR).append(STAR);
		}
		else {
			for (int i = 0; i < N; i++) {
				if (i != N - 1) {
					for (int j = 0; j < N - i - 1; j++) {
						sb.append(SPACE);
					}
					sb.append(STAR);
					for (int j = 0; j < 2 * i - 1; j++) {
						sb.append(SPACE);
					}
					if (i != 0) {
						sb.append(STAR);
					}
				}
				else {
					for (int j = 0; j < 2 * N - 1; j++) {
						sb.append(STAR);
					}
				}
				sb.append(NEW_LINE);
			}
		}
		System.out.println(sb.toString());
	}
}
