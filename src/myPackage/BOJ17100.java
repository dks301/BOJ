package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/*
 * Candy Boxes
 * N개의 특가 상품, i번째 특가 상품에는 당도 ai의 사탕 mi개, 가격 ci
 * 1부터 L까지의 모든 k에 대해서, 당도의 합이 k가 되게 사탕을 먹을 수 있게 구매하는 최소비용출력
 * 한 특가상품을 구매했을때, 모든 사탕을 먹을 필요는 없다.
 * 어떠한 k에 대해 방법이 없으면 -1출력
 * 
 * 첫줄: N과 L이 공백으로 구분되어 주어진다(1<=N,L<=10000)
 * 둘째줄~N개줄: ai mi ci가 공백으로 구분(1<=ai,mi,ci<=10,000)
 */
public class BOJ17100 {
	private static final String SPACE = " ";
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		ArrayList<Set> s = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			s.add(new Set(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		Collections.sort(s);
		int[] k = new int[L + 1];
		Arrays.fill(k, -1);
		
		for (Set next : s) {
			for (int i = 1; i <= next.m; i++) {
				if (k[next.a * i] == -1) {
					k[next.a * i] = next.c;
				}
			}
		}

		combination(new int[2], 0, 5, 2, 1);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= L; i++) {
			sb.append(k[i]).append(SPACE);
		}
		System.out.println(sb);
		
	}
	
	
	public static void combination(int[] arr, int index, int n, int r, int target) {
		if (r == 0) {
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		} else if (target == n) {
			return;
		} else {
			arr[index] = target;
			combination(arr, index + 1, n, r - 1, target + 1);
			combination(arr, index, n, r, target + 1);
		}
	}
	
	public static class Set implements Comparable<Set> {
		int a, m, c;
		double pricePerUnit;
		
		public Set(int a, int m, int c) {
			this.a = a;
			this.m = m;
			this.c = c;
			
			this.pricePerUnit = c / m;
		}
		
		@Override
		public int compareTo(Set that) {
			if (this.pricePerUnit < that.pricePerUnit) {
				return -1;
			} else if (this.pricePerUnit == that.pricePerUnit) {
				if (this.m < that.m) {
					return -1;
				} else if (this.m == that.m){
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
