package stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

/*
 * 문자열 폭발
 * 문자열이 폭발 문자열을 포함하고 있는 경우에, 모든 폭발 문자열이 폭발
 * 이후 남은 문자열을 순서대로 이어붙여 새로운 문자열을 만든다.
 * 새로 생긴 문자열에 폭발 문자열이 포함되어 있을 수 도 있다.
 * 문자열에 폭발 문자열이 없을때까지 반복
 * 
 * 입력
 * 첫째줄: 1이상 1,000,000이하 길이의 문자열
 * 둘째줄: 폭발 문자열  1이상 36이하 길이
 * 두 문자열은 모두 알파벳 대소문자 or 숫자 0~9로 이루어짐
 * 
 * 출력
 * 폭발이 끝난 후 남는 문자열 출력 남아있는 문자가 없으면 "FRULA"출력
 */
public class BOJ9935 {
	private static char[] bomb;
	private static int len;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		bomb = br.readLine().toCharArray();
		len = bomb.length;
		
		Stack<Bomb> result = solution(str);
		StringBuilder sb = new StringBuilder();
		while (!result.isEmpty()) {
			sb.append(result.pop().val);
		}
		String ans = sb.reverse().toString();
		if (ans.length() == 0) {
			System.out.println("FRULA");
		} else {
			System.out.println(ans);
		}
	}
	
	public static Stack<Bomb> solution(String in) {
		Stack<Bomb> stack = new Stack<>();
		char[] str = in.toCharArray();
		int top = -1;
		
		for (int i = 0; i < str.length; i++) {
			if (str[i] == bomb[top + 1]) {
				top++;
				if (top == len - 1) {
					while (top > 0) {
						stack.pop();
						top--;
					}
					
					if (!stack.isEmpty()) {
						top = stack.peek().top;
					} else {
						top = -1;
					}
					
				} else {
					stack.push(new Bomb(str[i], top));
				}
			} else {
				if (str[i] == bomb[0]) {
					stack.push(new Bomb(str[i], 0));
					top = 0;
				} else {
					stack.push(new Bomb(str[i], -1));
					top = -1;
				}
			}
		}
		return stack;
	}
	
	public static class Bomb {
		char val;
		int top;
		
		public Bomb (char val, int top) {
			this.val = val;
			this.top = top;
		}
	}
}
