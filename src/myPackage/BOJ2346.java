package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ2346 {
	private static final char SPACE = ' ';
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		LinkedList<Balloon> ll = new LinkedList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			ll.add(new Balloon(i, Integer.parseInt(st.nextToken())));
		}
		
		StringBuilder sb = new StringBuilder();
		int curIdx = 0;
		while(ll.size() > 1) {
			Balloon next = ll.remove(curIdx);
			int nextIdx = curIdx + next.val - 1;
			if (nextIdx < 0) {
				nextIdx = ll.size() + nextIdx;
			} else if (nextIdx >= ll.size()) {
				nextIdx = nextIdx % ll.size();
			}
			
			curIdx = nextIdx;
			System.out.println(curIdx);
			sb.append(next.idx + 1).append(SPACE);
		}
		sb.append(ll.remove().idx + 1).append(SPACE);
		System.out.println(sb);
	}
	
	public static class Balloon {
		int idx, val;
		
		public Balloon(int idx, int val) {
			this.idx = idx;
			this.val = val;
		}
	}
}
