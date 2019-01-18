package success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ10799 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = br.readLine().toCharArray();
		int size = input.length;
		int total = 0;
		int top = 0;
		
		for (int i = 0; i < size; i++) {
			if (input[i] == '(') {
				top++;
			} else {
				top--;
				if (input[i - 1] == ')') {
					total++;
				} else {
					total += top;
				}
			}
		}
		System.out.println(total);
	}
}
