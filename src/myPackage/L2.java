package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class L2 {
	private static int num, N;
	private static int[] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = st.countTokens();
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		num = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < num - 1; i++) {
			nextPermutation();
		}
		
		for (int j = 0; j < N; j++) {
			System.out.print(arr[j]);
		}
		System.out.println();
	}
	
	public static void swap(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static boolean nextPermutation() {
		int i = N - 1;
		while (i > 0 && arr[i - 1] >= arr[i]) {
			i--;
		}
		if (i < 1) return false;
		
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
}
