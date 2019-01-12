package success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11650 { //Comparable, Comparator 두가지 방법
	private static final String NEW_LINE = "\n";
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Point[] p = new Point[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			p[i] = new Point(x, y);
		}
		Arrays.sort(p);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(p[i].x + " " + p[i].y).append(NEW_LINE);
		}
		System.out.println(sb.toString());
	}
	
	public static class Point implements Comparable<Point>{
		private int x, y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public int compareTo(Point that) {
			if (this.x < that.x) {
				return -1;
			} else if (this.x == that.x) {
				if (this.y < that.y) {
					return -1;
				} else if (this.y == that.y) {
					return 0;
				} else { // this.y > that.y
					return 1;
				}
			} else { // this.x > that.x
				return 1;
			}
		}
	}
}

