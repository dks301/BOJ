package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
 * 8진수 -> 2진수
 */
public class BOJ1212 {
	private static final String[] bi = { "000", "001", "010", "011", "100", "101", "110", "111" };
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] oct = br.readLine().toCharArray();
		int first = oct[0] - '0';
		int len = oct.length;
		
		StringBuilder sb = new StringBuilder();
		sb.append(Integer.toBinaryString(first));
		for (int i = 1; i < len; i++) {
			sb.append(bi[oct[i] - '0']);
		}
		System.out.println(sb.toString());
	}
}
