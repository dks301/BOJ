package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ1157 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = br.readLine().toCharArray();
		int[] alpha = new int[26];
		
		for (int i = 0; i < input.length; i++) {
			input[i] = Character.toUpperCase(input[i]);
			alpha[(int)input[i] - 65]++;
		}
		
		int max = 0;
		for (int i = 0; i < 26; i++) {
			max = max < alpha[i] ? alpha[i] : max;
		}
		int countMax = 0;
		char alpha_max = ' ';
		for (int i = 0; i < 26; i++) {
			if (max == alpha[i]) {
				alpha_max = (char)(i + 65);
				countMax++;
			}
		}
		System.out.println(countMax > 1 ? "?" : alpha_max);
	}
}
