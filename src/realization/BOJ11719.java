package realization;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ11719 {
	private static final String NEW_LINE = "\n";
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		String temp;
		while((temp = br.readLine()) != null) {
			sb.append(temp).append(NEW_LINE);
		}
		System.out.println(sb.toString());
	}
}
