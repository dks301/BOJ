package myPackage;

import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Test {
	public static void main(String[] args) {
		long s = System.currentTimeMillis();
		
		int[][] src = new int[2048][2048];
		int[][] dst = new int[2048][2048];
		
		for (int j = 0; j < 2048; j++) {
			for (int i = 0; i < 2048; i++) {
				dst[i][j] = src[i][j];
			}
		}
		
		System.out.println(System.currentTimeMillis() - s);
	}
}
