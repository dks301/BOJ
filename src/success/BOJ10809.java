package success;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ10809 {
	private static final String SPACE = " ";
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		char[] input = new char[str.length()];
		input = str.toCharArray();
		int[] output = new int[26];
		
		char[] alpha = new char[26];
		for (int i = 0; i < 26; i++) {
			alpha[i] = (char)('a' + i);
			output[i] = -1;
		}
		

		for (int i = 0; i < 26; i++) {
			for (int j = 0; j < str.length(); j++) {
				if (alpha[i] == input[j] && output[i] == -1)
					output[i] = j;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 26; i++)
			sb.append(output[i]).append(SPACE);
		System.out.println(sb.toString());
	}
}
