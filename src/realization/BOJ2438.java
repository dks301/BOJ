package success;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ2438 {
private static final String NEW_LINE = "\n";
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < i; j++) {
				sb.append("*");
			}
			sb.append(NEW_LINE);
		}
		System.out.println(sb.toString());
	}
}
