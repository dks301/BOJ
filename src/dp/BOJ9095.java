package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9095 {
	private static final String NEW_LINE = "\n";
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] d = new int[11];
		d[0] = 1;
		d[1] = 1;
		d[2] = 2;
		for (int i = 3; i < 11; i++) {
			d[i] = d[i - 3] + d[i - 2] + d[i - 1];
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			sb.append(d[Integer.parseInt(br.readLine())]).append(NEW_LINE);
		}
		System.out.println(sb.toString());
	}
}
