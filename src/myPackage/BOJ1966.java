package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 프린터 큐
 * 문서(N<=100), 내가원하는 문서의 위치(0<=M<N), 중요도(1이상9이하)
 * 여러개의 문서와 각 문서의 중요도가 주어질 때,
 * 내가 원하는 문서가 몇 번째로 인쇄되는지 출력
 */
public class BOJ1966 {
	private static final String NEW_LINE = "\n";
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		while (tc-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			PriorityQueue<Document> pq = new PriorityQueue<>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				pq.add(new Document(i, Integer.parseInt(st.nextToken())));
			}
			int cnt = 0;
			while (!pq.isEmpty()) {
				Document d = pq.remove();
				cnt++;
				if (d.idx == M) {
					break;
				}
			}
			sb.append(cnt).append(NEW_LINE);
		}
		System.out.println(sb);
	}
	
	public static class Document implements Comparable<Document>{
		int idx;
		int importance;
		
		public Document(int idx, int importance) {
			this.idx = idx;
			this.importance = importance;
		}
		
		public int compareTo(Document that) {
			if (this.importance < that.importance) {
				return 1;
			} else if (this.importance == that.importance) {
				return 0;
			} else {
				return -1;
			}
		}
	}
}
