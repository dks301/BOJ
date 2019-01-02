package realization;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.EmptyStackException;
import java.util.Stack;

public class BOJ2504 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<String> s = new Stack<>();
		char[] str = br.readLine().toCharArray();
		int result = 0;
		
		for (int i = 0; i < str.length; i++) {
			if (str[i] == '(' || str[i] == '[') {
				s.push(Character.toString(str[i]));
			}
			else {
				if (s.isEmpty()) {
					System.out.println("0");
					System.exit(0);				
				}
				else {
					String temp = s.pop();
					
					if (str[i] == ')' && temp.equals("[")) {
						System.out.println("0");
						System.exit(0);									
					}
					else if (str[i] == ']' && temp.equals("(")) {
						System.out.println("0");
						System.exit(0);			
					}
					if (temp.equals("("))
						s.push("2");
					else if (temp.equals("["))
						s.push("3");
					else {
						int X = 0;
						while (!temp.equals("(") && !temp.equals("[")) {
							X += Integer.parseInt(temp);
							try {
								temp = s.pop();
							} catch (EmptyStackException e){
								System.out.println("0");
								System.exit(0);
							}
						}
						if (temp.equals("(")) {
							if (str[i] == ']') {
								System.out.println("0");
								System.exit(0);		
							}
							X *= 2;
						}
						else if (temp.equals("[")) {
							if (str[i] == ')') {
								System.out.println("0");
								System.exit(0);		
							}
							X *= 3;
						}
						s.push(String.valueOf(X));
					}
				}
			}
		}
		if (s.contains("(") || s.contains(")") || s.contains("[") || s.contains("]")) {
			System.out.println("0");
			System.exit(0);
		}
		
		while (!s.isEmpty()) {
			result += Integer.parseInt(s.pop());
		}
		System.out.println(result);
	}
}
