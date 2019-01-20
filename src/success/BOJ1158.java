package success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1158 {
	private static final String SPACE = " ";
	private static final String COMMA = ",";
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 1 <= N <= 5,000
		int M = Integer.parseInt(st.nextToken()); // <= N
		Queue<Integer> q = new LinkedList<Integer>();
		int count = 1;
		for (int i = 1; i <= N; i++) {
			q.add(i);
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		while (!q.isEmpty()) {
			if (count == M) {
				count = 1;
				sb.append(q.poll());
				if (!q.isEmpty()) {
					sb.append(COMMA).append(SPACE);
				}
			} else {
				q.add(q.poll());
				count++;
			}
		}
		sb.append(">");
		System.out.println(sb.toString());
	}
}
