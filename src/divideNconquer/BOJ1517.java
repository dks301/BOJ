package divideNconquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/*
 * 버블 소트
 * N개의 수로 이루어진 수열 A[1], A[2], ..., A[N]
 * 버블 소트를 수행할 때, 스왑이 총 몇번 발생하는지 찾아내기
 * 
 * 입력
 * 첫쨰줄: N(1<=N<=500,000)
 * 둘째줄: A[1], ...., A[N](0<=A[i]<=1,000,000,000)
 */
public class BOJ1517 {
	private static int[] A, B;
	private static int N;
	private static long ans = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = new int[N];
		B = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		sort(0, N - 1);
		
		System.out.println(ans);
	}
	
	public static void sort(int start, int end) {
		if (start == end) {
			return;
		}
		
		int mid = (start + end) / 2;
		sort(start, mid);
		sort(mid + 1, end);
		merge(start, end);
	}
	
	public static void merge(int start, int end) {
		int mid = (start + end) / 2;
		int i = start, j = mid + 1, k = 0;
		
		while (i <= mid && j <= end) {
			if (A[i] <= A[j]) {
				B[k++] = A[i++];
			} else {
				B[k++] = A[j++];
				ans += (long)(mid - i + 1);
			}
		}
		
		while (i <= mid) {
			B[k++] = A[i++];
		}
		while (j <= end) {
			B[k++] = A[j++];
		}
		for (i = start; i <= end; i++) {
			A[i] = B[i - start];
		}
	}
}
