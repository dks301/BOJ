package permutation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 이전 순열
 * 다음 순열 반대
 */
public class BOJ10973 {
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
		
		if (prevPermutation()) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < N; i++) {
				sb.append(arr[i]).append(SPACE);
			}
			System.out.println(sb);
		} else {
			System.out.println(-1);
		}
	}
	
	public static boolean prevPermutation() {
		int i = N - 1;
		while (i > 0 && arr[i - 1] <= arr[i]) {
			i--;
		}
		if (i <= 0) return false;
		
		int j = N - 1;
		while (arr[j] >= arr[i - 1]) {
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
