package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class SCPCRound2_5 {
	private static final String CASE = "Case #";
	private static final char NEW_LINE = '\n';
	private static final char SPACE = ' ';
	
	private static int M, N, sum;
	private static ArrayList<Node> al;
	private static ArrayList<Point> al2;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringBuilder sb = new StringBuilder();
			sb.append(CASE).append(t).append(NEW_LINE);
			M = Integer.parseInt(br.readLine());
			N = Integer.parseInt(br.readLine());
			
			al = new ArrayList<>();
			al2 = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				al.add(new Node(x, y));
			}
			
			Collections.sort(al);
			
			Node n = al.get(0);
			al2.add(new Point(n.x, n.y));
			sum = M - n.x < M - n.y ? M - n.x : M - n.y;
			for (int i = 1; i < N; i++) {
				n = al.get(i);
				int min = M - n.x < M - n.y ? M - n.x : M - n.y;
				
				Collections.sort(al2);
				int left = n.x, right = M;
				while (left <= right) {
					int mid = (left + right) / 2;
					int val = al2.get(mid).x;
					if (val > min) {
						left = mid + 1;
					} else {
						right = mid - 1;
					}
				}
				System.out.println(left + 1);
				for (Point next : al2) {
					if (next.x >= n.x) {
						int x_dif = next.x - n.x;
						int y_dif = next.y - n.y;
						if (x_dif > y_dif && x_dif < min) {
							min = x_dif;
						} else if (x_dif <= y_dif && y_dif < min){
							min = y_dif;
						}
					}
				}
				sum += min;
				al2.add(new Point(n.x, n.y));
			}
			System.out.print(sb);
			System.out.println(sum);
		}
	}
	
	public static void solve(Node n) {
		int startX = n.x;
		int endX = M;
		
		int startY = n.y;
		int endY = M;
		
		while (startX <= endX) {
			int midX = startX + ((endX - startX) / 2);
			
		}
	}
	public static class Point implements Comparable<Point> {
		int x, y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public int compareTo(Point that) {
			if (this.x < that.x) {
				return -1;
			} else if (this.x == that.x) {
				if (this.y < that.y) {
					return -1;
				} else if(this.y == that.y) {
					return 0;
				} else {
					return 1;
				}
			} else {
				return 1;
			}
		}
	}
	public static class Node implements Comparable<Node>{
		int x, y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(Node that) {
			if (this.y < that.y) {
				return 1;
			} else if (this.y == that.y) {
				if (this.x < that.x) {
					return 1;
				} else if (this.x == that.x) {
					return 0;
				} else {
					return -1;
				}
			} else {
				return -1;
			}
		}
	}
}
