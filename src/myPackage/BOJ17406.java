package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ17406 {
	private static int N, M, K;
	private static int[][] A;
	private static ArrayList<Rotate> r;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		A = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		r = new ArrayList<>();
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			r.add(new Rotate(a, b, c));
		}
	}
	
	public static void calc(Rotate x) {
		int a = x.r - x.s;
		int b = x.c - x.s;
		int c = x.r + x.s;
		int d = x.c + x.s;
		
		while (a != c && b != d) {
			//go(a, b, c, d);
			
			a++;
			b++;
		}
		
	}
	
	public static void permutation(int[] arr, int depth, int n, int k) {
		if (depth == k) {
			
			return;
		}
		
		for (int i = depth; i < n; i++) {
			swap(arr, i, depth);
			permutation(arr, depth + 1, n, k);
			swap(arr, i, depth);
		}
	}
	
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static class Rotate {
		int r, c, s;
		
		public Rotate(int r, int c, int s) {
			this.r = r;
			this.c = c;
			this.s = s;
		}
	}
}
