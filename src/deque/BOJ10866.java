package deque;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/*
 * 덱
 * 정수를 저장하는 덱을 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램 작성
 */
public class BOJ10866 {
	private static final String NEW_LINE = "\n";
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Deque<Integer> dq = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();
		while (N-- > 0) {
			String cmd = br.readLine();
			char[] c = cmd.toCharArray();
			
			switch (c[0]) {
			case 'p':
				if (c[5] == 'f') {
					dq.addFirst(Integer.parseInt(cmd.substring(11)));
				
				} else if (c[5] == 'b') {
					dq.addLast(Integer.parseInt(cmd.substring(10)));
				
				} else if (c[5] == 'r') {
					sb.append(dq.isEmpty() ? "-1" : dq.removeFirst()).append(NEW_LINE);
					
				} else { // c[5] == 'a'
					sb.append(dq.isEmpty() ? "-1" : dq.removeLast()).append(NEW_LINE);
				
				}
				break;
				
			case 's':
				sb.append(dq.size()).append(NEW_LINE);
				break;
				
			case 'e':
				sb.append(dq.isEmpty() ? "1" : "0").append(NEW_LINE);
				break;
				
			case 'f':
				sb.append(dq.isEmpty() ? "-1" : dq.getFirst()).append(NEW_LINE);
				break;
				
			case 'b':
				sb.append(dq.isEmpty() ? "-1" : dq.getLast()).append(NEW_LINE);
				break;
			}
		}
		System.out.print(sb);
	}
}
