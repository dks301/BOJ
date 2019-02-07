package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11651 {
	private static final String SPACE = " ";
	private static final String NEW_LINE = "\n";
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Point[] p = new Point[N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			p[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(p);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(p[i].x).append(SPACE).append(p[i].y).append(NEW_LINE);
		}
		System.out.println(sb.toString());
	}
	
	private static class Point implements Comparable<Point>{
		int x, y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public int compareTo(Point that) {
			if (this.y < that.y) {
				return -1;
			} else if (this.y == that.y) {
				if (this.x < that.x) {
					return -1;
				} else if (this.x == that.x) {
					return 0;
				} else {
					return 1;
				}
			} else {
				return 1;
			}
		}
	}
}
