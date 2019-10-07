package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class N2 {
	private static final String ENQUEUE = "enqueue";
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		LinkedList<Node> FQ = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			if (cmd.equals(ENQUEUE)) {
				long val = Long.parseLong(st.nextToken());
				int freq = 1;
				
				boolean isContain = false;
				for (Node next : FQ) {
					if (next.val == val) {
						freq = next.freq + 1;
						isContain = true;
						break;
					}
				}
				if (isContain) {
					FQ.add(new Node(val, i, freq));	
				} else {
					FQ.add(new Node(val, i, 1));
				}
				
				for (Node next : FQ) {
					if (next.val == val) {
						next.freq = freq;
					}
				}
				
			} else {
				int max = 1;
				if (FQ.isEmpty()) {
					sb.append(-1).append(" ");
				} else {
					for (Node next : FQ) {
						if (max < next.freq) {
							max = next.freq;
						}
					}
					
					int tempIdx = 1000;
					
					for (Node next : FQ) {
						if (next.freq == max) {
							if (tempIdx > next.idx) {
								tempIdx = next.idx;
							}
						}
					}
					
					Iterator<Node> it = FQ.iterator();
					Node temp = null;
					while (it.hasNext()) {
						Node next = it.next();
						if (next.idx == tempIdx) {
							sb.append(next.val).append(" ");
							temp = next;
							it.remove();
						}
					}
					
					for (Node next : FQ) {
						if (temp.val == next.val) {
							next.freq--;
						}
					}
				}
			}
		}
		System.out.print(sb);
	}

	public static class Node {
		long val;
		int freq, idx;
		
		public Node(long val, int idx, int freq) {
			this.val = val;
			this.idx = idx;
			this.freq = freq;
		}
	}
}
