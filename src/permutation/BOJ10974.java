package permutation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 모든 순열
 * N이 주어졌을 때, 1부터 N까지의 수로 이루어진 순열만들기
 * 
 * 입력
 * N(1<=N<=8)
 * 
 * 출력
 * N!개의 줄에 걸쳐 모든 순열을 사전순으로 출력
 */
public class BOJ10974 {
	private static int N;
	private static int[] arr;
	private static final char SPACE = ' ';
	private static final char NEW_LINE = '\n';
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = i;
		}
		
		StringBuilder sb = new StringBuilder();
		do {
			for (int i = 1; i <= N; i++) {
				sb.append(arr[i]).append(SPACE);
			}
			sb.append(NEW_LINE);
		} while(nextPermutation());
		System.out.print(sb);
	}
	
	public static boolean nextPermutation() {
		int i = N;
		while (i > 1 && arr[i - 1] >= arr[i]) {
			i--;
		}
		if (i <= 1) return false;
		
		int j = N;
		while (arr[j] <= arr[i - 1]) {
			j--;
		}
		
		swap(i - 1, j);
		
		j = N;
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
