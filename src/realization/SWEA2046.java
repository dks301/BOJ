package realization;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA2046 {
	private static final String STAMP = "#";
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		while (n-- > 0) {
			sb.append(STAMP);
		}
		System.out.println(sb);
	}
}
