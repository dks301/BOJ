package binarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 나무 자르기
 * 나무 M미터가 필요
 * 절단기에 높이 H를 지정->톱날이 H미터로 올라감
 * ->한줄에서 높이가 H보다 큰 나무는 H미터 윗부분이 모두 잘림->잘린부분을 가져감
 * 
 * 입력
 * 첫째줄: 나무의 수 N, 필요한 나무의 길이 M(1<=N<=1_000_000, 1<=M<=2_000_000_000)
 * 둘째줄: 나무의 높이(나무의 높이의 합은 항상 M을 넘는다, 0<=높이<=1_000_000_000)
 * 
 * 출력
 * 적어도 M미터의 나무를 집에 가져갈 수 있는 높이의 최댓값
 */
public class BOJ2805 {
	private static int N, M;
	private static int[] tree;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		tree = new int[N];
		for (int i = 0; i < N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
		}
		
		int left = 1, right = 2_000_000_000;
		while (left <= right) {
			int mid = (left + right) / 2;
			long sum = cutting(mid);
			
			if (sum < M) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		System.out.println(left - 1);
	}
	
	public static long cutting(int h) {
		long sum = 0;
		for (int i = 0; i < N; i++) {
			sum += (tree[i] - h > 0 ? tree[i] - h : 0);
		}
		return sum;
	}
}
