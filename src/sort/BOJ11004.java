package sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/*
 * K번째 수
 * 수열 An이 주어질 때, 오름차순 정렬 후 k번째에 있는 수 출력 
 */
public class BOJ11004 {
	private static int[] A, B;
	private static int N, K;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		A = new int[N];
		B = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		sort(0, N - 1);
		for (int i = 0; i < N; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
		System.out.println(A[K - 1]);
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
