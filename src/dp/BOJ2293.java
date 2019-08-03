package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 동전 1
 * 중복을 제거해야하는 경우 포문 2개 맞바꾸기
 * (한개씩 먼저해서 중복 제거)
 */
public class BOJ2293 {
	private static int n, k;
	private static int[] A, d;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		A = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}
		
		d = new int[k + 1];
		d[0] = 1;
		for (int j = 0; j < n; j++) {
			for (int i = 1; i <= k; i++) {
				if (i - A[j] >= 0) {
					d[i] += d[i - A[j]];
				}
			}
		}
		
		System.out.println(d[k]);
	}
}
