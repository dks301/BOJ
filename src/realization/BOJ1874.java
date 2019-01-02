package realization;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ1874 {
	private static final String NEW_LINE = "\n";
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int count = 0;
		boolean isPossible = true;
		myStack ms = new myStack(n);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			int input = Integer.parseInt(br.readLine());
			
			for (int j = count; j < input; j++) {
				ms.push(count + 1);
				sb.append("+").append(NEW_LINE);
				count++;
			}
			if (input != ms.pop()) {
				isPossible = false;
				break;
			}
			sb.append("-").append(NEW_LINE);
		}
		System.out.println(isPossible ? sb.toString() : "NO");
	}
	
	private static class myStack {
		private int top;
		private int[] stack;

		public myStack(int n) {
			top = -1;
			stack = new int[n];
		}
		
		private void push(int n) {
			stack[++top] = n;
		}
		
		private int pop() {
			return stack[top--];
		}
	}
}
