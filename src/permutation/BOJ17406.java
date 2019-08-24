package permutation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ17406 {
	private static int N, M, K, ans;
	private static int[][] A;
	private static ArrayList<Rotate> al;
	
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
		
		al = new ArrayList<>();
		int[] arr = new int[K];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			al.add(new Rotate(a, b, c));
			arr[i] = i;
		}
		
		ans = Integer.MAX_VALUE;
		permutation(arr, 0, K, K);
		
		System.out.println(ans);
	}
	
	public static int calculation(int[][] arr) {
		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= N; i++) {
			int sum = 0;
			for (int j = 1; j <= M; j++) {
				sum += arr[i][j];
			}
			
			if (sum < min) {
				min = sum;
			}
		}
		return min;
	}
	
	public static void rotate(int[][] arr, int a, int b, int c, int d) {
		if (a == c) {
			return;
		}
		
		int temp = arr[a][b];
		for (int i = a; i < c; i++) {
			arr[i][b] = arr[i + 1][b];
		}
		
		for (int j = b; j < d; j++) {
			arr[c][j] = arr[c][j + 1];
		}
		
		for (int i = c; i > a; i--) {
			arr[i][d] = arr[i - 1][d];
		}
		
		for (int j = d; j > b; j--) {
			arr[a][j] = arr[a][j - 1];
		}
		
		arr[a][b + 1] = temp;
		
	}
	
	public static void go(int[][] arr, Rotate x) {
		int a = x.r - x.s;
		int b = x.c - x.s;
		int c = x.r + x.s;
		int d = x.c + x.s;
		
		for (int i = a, j = b, k = c, l = d; i < ((a + c) / 2); i++, j++, k--, l--) {
			rotate(arr, i, j, k, l);
		}
	}
	
	public static void permutation(int[] arr, int depth, int n, int k) {
		if (depth == k) {
			int[][] result = new int[N + 1][M + 1];
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					result[i][j] = A[i][j];
				}
			}
			
			for (int i = 0; i < arr.length; i++) {
				go(result, al.get(arr[i]));
			}
			
			int val = calculation(result);
			if (val < ans) {
				ans = val;
			}
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
