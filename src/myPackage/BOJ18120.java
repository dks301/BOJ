package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ18120 {
	private static double r = 0.0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int A = Integer.parseInt(st.nextToken());
		
		LinkedList<Crop> cropsList = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			cropsList.add(new Crop(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		Collections.sort(cropsList);
		
	}
	
	public static double findMaxGain(LinkedList<Crop> cropList, int N, int A) {
		for (int i = 0; i < N; i++) {
			double[] f = doDifferential(i, A);
			
		}
		return 0.0;
	}
	
	public static double[] doDifferential(int n, int A) {
		return new double[]{-2 * A, n};
	}
	
	public static class Crop implements Comparable<Crop> {
		int x, y, w; // -1000 <= x,y <= 1000, 1 <= w <= 200)
		double d;
		
		public Crop (int x, int y, int w) {
			this.x = x;
			this.y = y;
			this.w = w;
			this.d = Math.sqrt(Math.pow(this.x, 2.0) + Math.pow(this.y, 2.0));
			
		}
		
		@Override
		public int compareTo(Crop that) {
			// TODO Auto-generated method stub
			if (this.d < that.d) {
				return -1;
			} else if (this.d == that.d) {
				return 0;
			} else {
				return 1;
			}
		}
	}
}
