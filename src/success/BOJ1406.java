package success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ1406 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str = br.readLine().toCharArray(); // 영어 소문자, <= 100,000
		int N = Integer.parseInt(br.readLine()); // 1 <= N <= 500,000
		Stack<Character> left = new Stack<>();
		Stack<Character> right = new Stack<>();
		
		for (int i = 0; i < str.length; i++) {
			left.push(str[i]);
		}
		for (int i = 0; i < N; i++) {
			String cmd = br.readLine();
			switch (cmd.charAt(0)) {
			case 'L':
				if (!left.isEmpty()) {
					right.push(left.pop());
				}
				break;
			case 'D':
				if (!right.isEmpty()) {
					left.push(right.pop());
				}
				break;
			case 'B':
				if (!left.isEmpty()) {
					left.pop();
				}
				break;
			case 'P':
				left.push(cmd.charAt(2));
				break;
			}
		}
		while (!left.isEmpty()) {
			right.push(left.pop());
		}

		StringBuilder sb = new StringBuilder();
		while (!right.isEmpty()) {
			sb.append(right.pop());
		}
		System.out.println(sb.toString());
	}
}
