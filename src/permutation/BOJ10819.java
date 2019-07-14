package permutation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 차이를 최대로
 * N개의 정수로 이루어진 배열 A
 * 배열에 들어있는 정수의 순서를 적절히 바꿔서 다음식의 최댓값 찾기
 * |A[0]-A[1]| + |A[1]-A[2]| + ... + |A[N-2]-A[N-1]|
 * 
 * 입력
 * 첫째줄: N(3<=N<=8)
 * 둘째줄: 배열 A에 들어있는 정수(-100이상, 100이하)
 * 
 * 출력
 * 배열 에들어있는 수를 바꿔서 얻을 수 있는 식의 최댓값
 */
public class BOJ10819 {
	private static int N;
	private static int[] A;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(A);
		
		int max = 0;
		do {
			int val = solve(A);
			if (val > max) {
				max = val;
			}
		
		} while(nextPermutation());
		
		System.out.println(max);
	}
	
	public static boolean nextPermutation() {
		int i = N - 1;
		while (i > 0 && A[i - 1] >= A[i]) {
			i--;
		}
		if (i < 1) return false;
		
		int j = N - 1;
		while (A[j] <= A[i - 1]) {
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
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
	
	public static int solve(int[] arr) {
		int val = 0;
		for (int i = 1; i < arr.length; i++) {
			val += Math.abs(arr[i - 1] - arr[i]);
		}
		return val;
	}
}
