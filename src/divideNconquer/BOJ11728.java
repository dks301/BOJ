package divideNconquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 배열 합치기
 * 정렬되어있는 두 배열 A와 B를 합친 다음 정렬해서 출력
 * 
 * 입력
 * 첫째 줄: 배열 A의 크기N, 배열 B의 크기 M(1<=N,M<-1,000,000)
 * 둘째 줄: 배열 A의 내용
 * 셋째 줄: 배열 B의 내용 (배열의 값은 절대값이 10^9이하인 정수)
 */
public class BOJ11728 {
	private static final String SPACE = " ";
	private static int[] A, B, result;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		A = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		B = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		result = new int[N + M];
		merge(N, M);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N + M; i++) {
			sb.append(result[i]).append(SPACE);
		}
		System.out.println(sb);
	}
	
	public static void merge(int N, int M) {
		int i = 0, j = 0, k = 0;
		
		while (i < N && j < M) {
			if (A[i] <= B[j]) {
				result[k++] = A[i++];
			} else {
				result[k++] = B[j++];
			}
		}
		
		while (i < N) {
			result[k++] = A[i++];
		}
		while (j < M) {
			result[k++] = B[j++];
		}
	}
}
