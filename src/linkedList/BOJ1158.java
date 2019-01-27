package linkedList;

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
		for (int i = 1; i <= N; i++) {
			q.add(i);
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		for (int i = 0; i < N - 1; i++) {
			for (int j = 0; j < M - 1; j++) {
				q.add(q.poll());
			}
			sb.append(q.poll()).append(COMMA).append(SPACE);
		}
		sb.append(q.poll()).append(">");
		
		System.out.println(sb.toString());
	}
}
