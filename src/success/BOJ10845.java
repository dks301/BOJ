package success;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ10845 {
	private static final String NEW_LINE = "\n";
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<Integer>();
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			switch (st.nextToken()) {
			case "push":
				q.offer(Integer.parseInt(st.nextToken()));
				break;
			case "pop":
				sb.append(q.peek() == null ? "-1" : q.poll()).append(NEW_LINE);
				break;
			case "size":
				sb.append(q.size()).append(NEW_LINE);
				break;
			case "empty":
				sb.append(q.isEmpty() ? "1" : "0").append(NEW_LINE);
				break;
			case "front":
				sb.append(q.peek() == null ? "-1" : q.peek()).append(NEW_LINE);
				break;
			case "back":
				if (q.isEmpty()) {
					sb.append("-1").append(NEW_LINE);
				}
				else {
					int temp = 0;
					for (int j = 0; j < q.size(); j++) {
						temp = q.poll();
						q.offer(temp);
					}
					sb.append(temp).append(NEW_LINE);
				}
				break;
			}
		}
		System.out.println(sb.toString());
	}
}
