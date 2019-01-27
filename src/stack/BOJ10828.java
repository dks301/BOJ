package stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.EmptyStackException;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ10828 {
	private static final String NEW_LINE = "\n";
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<Integer>();
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			int X = 0;
			if (st.hasMoreTokens())
				X = Integer.parseInt(st.nextToken());
			
			switch (command) {
			case "push":
				stack.push(X);
				break;
			case "pop":
				int temp;
				try {
					temp = stack.pop();
				}catch (EmptyStackException e) {
					temp = -1;
				}
				sb.append(temp).append(NEW_LINE);
				break;
			case "size":
				sb.append(stack.size()).append(NEW_LINE);
				break;
			case "empty":
				sb.append(stack.isEmpty() ? "1" : "0").append(NEW_LINE);
				break;
			case "top":
				int top;
				try {
					top = stack.pop();
				}catch (EmptyStackException e){
					top = -1;
				}
				if (top != -1)
					stack.push(top);
				sb.append(top).append(NEW_LINE);
				break;
			}
		}
		System.out.println(sb.toString());
	}
}
