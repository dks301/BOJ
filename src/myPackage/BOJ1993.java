package myPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1993 {
	private static final String NEW_LINE = "\n";
	private static final String SPACE = " ";
	/* 점수가 낮은 순으로 버리기! */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n;
		int Race = 1;
		StringBuilder sb = new StringBuilder();
		while ((n = Integer.parseInt(br.readLine())) != 0) {
			sb.append("Race ").append(Race++).append(NEW_LINE);
			
			StringTokenizer st;
			Point[] p = new Point[n + 1];
			p[0] = new Point(0, 0, 0);
			for (int i = 1; i <= n; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				p[i] = new Point(x, y, s);
			}
			double[][] arr = new double[n + 1][n + 1];
			for (int i = 0; i <= n; i++) {
				for (int j = i + 1; j <= n; j++) {
					arr[i][j] = Math.sqrt(Math.pow(p[i].x - p[j].x, 2) + Math.pow(p[i].y - p[j].y, 2));
					System.out.printf("%.2f  ", arr[i][j]);
				}
				System.out.println();
			}
			
			String temp;
			while (!(temp = br.readLine()).equals("# 0")) {
				st = new StringTokenizer(temp);
				String name = st.nextToken();
				int d = Integer.parseInt(st.nextToken());
				int score = 0;
				
				
				sb.append(name + ": ").append(score).append(NEW_LINE);
			}
		}
		System.out.println(sb.toString());
	}
	
	public static class Point {
		private int x, y, s;
		
		public Point(int x, int y, int s) {
			this.x = x;
			this.y = y;
			this.s = s;
		}
	}
}
