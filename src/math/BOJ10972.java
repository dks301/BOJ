package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 다음 순열
 * 1부터 N까지의 수로 이루어진 순열이 있다.
 * 사전 순으로 가장 앞서는 수열은 오름차순 수열
 * 가장 마지막은 내림차순 수열
 * 
 * 입력
 * 첫째줄: N(1<=N<=10000)
 * 둘째줄: 순열
 * 
 * 출력
 * next_permutation 출력, 마지막인 경우 -1 출력
 */
public class BOJ10972 {
	private static int N;
	private static int[] arr;
	private static final char SPACE = ' ';
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		if (nextPermutation()) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < N; i++) {
				sb.append(arr[i]).append(SPACE);
			}
			System.out.println(sb);
		} else {
			System.out.println(-1);
		}
	}
	
	public static boolean nextPermutation() {
		int i = N - 1;
		while (i > 0 && arr[i - 1] >= arr[i]) {
			i--;
		}
		if (i <= 0) return false;
		
		int j = N - 1;
		while (arr[j] <= arr[i - 1]) {
			j--;
		}
		
		swap(i - 1, j);
		
		j = N - 1;
		while (i < j) {
			swap(i, j);
			i++;
			j--;
		}
		return true;
	}
	
	public static void swap(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
