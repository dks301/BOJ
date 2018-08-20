package success;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ9012 {
	private static final String NEW_LINE = "\n";
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			Stack<Boolean> s = new Stack<>();
			char[] str = br.readLine().toCharArray();
			boolean isYes = true;
			
			for (int j = 0; j < str.length; j++) {
				if (str[j] == ')' && s.isEmpty()) {
					isYes = false;
					sb.append("NO").append(NEW_LINE);
					break;
				}
				else if (str[j] == ')' && !s.isEmpty())
					s.pop();
				
				else if (str[j] == '(')
					s.push(true);
				
			}
			if (isYes && s.isEmpty())
				sb.append("YES").append(NEW_LINE);

			else if (isYes && !s.isEmpty())
				sb.append("NO").append(NEW_LINE);				
		}
		System.out.println(sb.toString());
	}
}
