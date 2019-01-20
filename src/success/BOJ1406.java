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
		Stack<Character> s1 = new Stack<>();
		Stack<Character> s2 = new Stack<>();
		
		for (int i = 0; i < str.length; i++) {
			s1.push(str[i]);
		}
		for (int i = 0; i < N; i++) {
			String cmd = br.readLine();
			switch (cmd.charAt(0)) {
			case 'L':
				if (s1.isEmpty()) {}
				else {
					s2.push(s1.pop());
				}
				break;
			case 'D':
				if (s2.isEmpty()) {}
				else {
					s1.push(s2.pop());
				}
				break;
			case 'B':
				if (s1.isEmpty()) {}
				else {
					s1.pop();
				}
				break;
			case 'P':
				s1.push(cmd.charAt(2));
				break;
			}
		}
		while (!s2.isEmpty()) {
			s1.push(s2.pop());
		}
		int size = s1.size();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < size; i++) {
			sb.append(s1.get(i));
		}
		System.out.println(sb.toString());
	}
}
