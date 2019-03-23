package realization;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA2050 {
	private static final String SPACE = " ";
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] in = br.readLine().toCharArray();
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < in.length; i++) {
			sb.append((int)(in[i] - 64)).append(SPACE);
		}
		System.out.print(sb);
	}
}
