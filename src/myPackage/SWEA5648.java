package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class SWEA5648 {
	private static int N, ans;
	private static PriorityQueue<Node>[] rpq, cpq;
	
	private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	private static final int ROW = 0;
	private static final int COL = 1;
	
	private static final char NUMBER = '#';
	private static final char SPACE = ' ';
	private static final char NEW_LINE = '\n';
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t <= T; t++) {
			sb.append(NUMBER).append(t).append(SPACE);
			N = Integer.parseInt(br.readLine());
			rpq = new PriorityQueue[2001];
			cpq = new PriorityQueue[2001];
			
			for (int i = 0; i <= 2000; i++) {
				rpq[i] = new PriorityQueue<>();
				cpq[i] = new PriorityQueue<>();
			}
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int row = Integer.parseInt(st.nextToken());
				int col = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				int K = Integer.parseInt(st.nextToken());
				
				if (d == 0 || d == 1) {
					rpq[row + 1000].add(new Node(row, col, d, K));
					
				} else {
					cpq[col + 1000].add(new Node(row, col, d, K));
				}
			}
			
			ans = 0;
			for (int i = 0; i <= 2000; i++) {
				Stack<Node> s = new Stack<>();
				while (!rpq[i].isEmpty()) {
					Node n = rpq[i].peek();
					if (n.d == 0) {
						if (!s.isEmpty()) {
							ans += rpq[i].poll().K;
							ans += s.pop().K;
						} else {
							rpq[i].poll();
						}
					} else {
						s.push(rpq[i].poll());
					}
				}
				
				s.clear();
				
				while (!cpq[i].isEmpty()) {
					Node n = cpq[i].peek();
					if (n.d == 2) {
						if (!s.isEmpty()) {
							ans += cpq[i].poll().K;
							ans += s.pop().K;
						} else {
							cpq[i].poll();
						}
					} else {
						s.push(cpq[i].poll());
					}
				}
			}
			
			sb.append(ans).append(NEW_LINE);
		}
		System.out.print(sb);
	}
	
	public static class Node implements Comparable<Node>{
		int row, col, d, K;
		
		public Node(int row, int col, int d, int K) {
			this.row = row + 1000;
			this.col = col + 1000;
			this.d = d;
			this.K = K;
		}
		
		@Override
		public int compareTo(Node that) {
			// TODO Auto-generated method stub
			if (d == 0 || d == 1) {
				if (this.row < that.row) {
					return -1;
				} else if (this.row == that.row) {
					return 0;
				} else {
					return 1;
				}
			} else {
				if (this.col < that.col) {
					return -1;
				} else if (this.col == that.col) {
					return 0;
				} else {
					return 1;
				}
			}
		} 
	}
}
