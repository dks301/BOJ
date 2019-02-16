package queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 조세퍼스 문제0
 * 1<=M<=N<=1,000
 * 조세퍼스 순열을 출력
 */
public class BOJ11866 {
	private static final String COMMA = ", ";
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			q.add(i);
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		int cnt = 0;
		int last = 0;
		while(!q.isEmpty()) {
			cnt++;
			if (cnt == M) {
				sb.append(q.remove());
				last++;
				if (last != N) {
					sb.append(COMMA);
					}
				cnt = 0;
			} else {
				q.add(q.remove());	
			}
		}
		sb.append(">");
		System.out.println(sb);
	}
}
