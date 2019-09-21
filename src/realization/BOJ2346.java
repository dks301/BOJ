package realization;

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
		while(!ll.isEmpty()) {
			if (curIdx == ll.size()) {
				curIdx = 0;
			} else if (curIdx == -1) {
				curIdx = ll.size() - 1;
			}
			System.out.println(curIdx);
			Balloon cur = ll.remove(curIdx);
			int cursor = curIdx;
			if (cur.val > 0) {
				for (int i = cur.val - 1; i > 0; i--) {
					if (cursor > ll.size() - 1) {
						cursor = 0;
					}
					cursor++;
				}
			} else {
				for (int i = cur.val; i < 0; i++) {
					if (cursor < 0) {
						cursor = ll.size() - 1;
					}
					cursor--;
				}
			}
			curIdx = cursor;
			sb.append(cur.idx + 1).append(SPACE);
		}
//		sb.append(ll.remove().idx + 1).append(SPACE);
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
