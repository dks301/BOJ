package success;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ2941 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = br.readLine().toCharArray();
		int count = input.length;
		
		for (int i = 0; i < input.length; i++) {
			if (i == 1 && (input[i] == '=' || input[i] == '-'))
				count--;
			else {
				count = (input[i] == '=' || input[i] == '-') ? (input[i - 2] == 'd' && input[i - 1] == 'z' ? count - 2 : count - 1) : count;
				count = input[i] == 'j' ? (input[i - 1] == 'l' || input[i - 1] == 'n' ? count - 1 : count) : count;
			}
		}
		System.out.println(count);
	}
}
