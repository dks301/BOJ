package realization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1002 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Pos p1 = new Pos();
		Pos p2 = new Pos();
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			p1.setX(Integer.parseInt(st.nextToken()));
			p1.setY(Integer.parseInt(st.nextToken()));
			p1.setR(Integer.parseInt(st.nextToken()));
			p2.setX(Integer.parseInt(st.nextToken()));
			p2.setY(Integer.parseInt(st.nextToken()));
			p2.setR(Integer.parseInt(st.nextToken()));
			
			sb.append(getCount(p1, p2)).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static int getCount(Pos p1, Pos p2) {
		if (p1.x == p2.x && p1.y == p2.y && p1.r == p2.r) {
			return -1;
		}
		double d = Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
		if (Math.abs(p1.r - p2.r) < d && d < p1.r + p2.r) {
			return 2;
		} else if (Math.abs(p1.r - p2.r) == d || p1.r + p2.r == d) {
			return 1;
		} else {
			return 0;
		}
	}
	
	public static class Pos {
		private int x;
		private int y;
		private int r;
		
		public Pos() {}
		
		public void setX(int x) {
			this.x = x;
		}
		public void setY(int y) {
			this.y = y;
		}
		public void setR(int r) {
			this.r = r;
		}
		
		public int getX() {
			return x;
		}
		public int getY() {
			return y;
		}
		public int getR() {
			return r;
		}
	}
}
