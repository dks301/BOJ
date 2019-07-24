package combination;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 부분수열의 합
 * N개의 정수로 이루어진 수열이 있을 때,
 * 길이가 양수인 부분수열 중에서 그 수열의 원소를 다 더한 값이 S
 * 
 * 입력
 * 첫째줄: N과 S(1<=N<=20, |S|<=1,000,000)
 * 둘째줄: N개의 정수가 공백으로 구분해서 주어진다(|정수|<=100,000)
 * 
 * 출력
 * 합이 S가 되는 부분수열의 개수 출력
 */
public class BOJ1182 {
	private static int N, S, ans;
	private static int[] A;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		A = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		ans = 0;
		for (int i = 1; i <= N; i++) {
			combination(new int[i], 0, N, i, 0);
		}
		System.out.println(ans);
	}
	
	public static void combination(int[] arr, int index, int n, int r, int target) {
		if (r == 0) {
			int sum = 0;
			for (int i = 0; i < arr.length; i++) {
				sum += A[arr[i]];
			}
			if (sum == S) {
				ans++;
			}
			
		} else if (target == n) {
			return;
		} else {
			arr[index] = target;
			combination(arr, index + 1, n, r - 1, target + 1);
			combination(arr, index, n, r, target + 1);
		}
	}
}
