package realization;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ11721 {
	private static final String NEW_LINE = "\n";
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str = br.readLine().toCharArray();

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length; i++) {
			if (i % 10 == 0 && i != 0)
				sb.append(NEW_LINE);
			sb.append(str[i]);
		}
		System.out.println(sb.toString());
	}
}
