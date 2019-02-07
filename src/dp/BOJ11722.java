package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 가장 긴 감소하는 부분 수열
 */
public class BOJ11722 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] d = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			d[i] = 1;
			for (int j = 1; j < i; j++) {
				if (A[i] < A[j] && d[i] < d[j] + 1) {
					d[i] = d[j] + 1;
				}
			}
		}
		int max = 0;
		for (int i = 1; i <= N; i++) {
			if (max < d[i]) {
				max = d[i];
			}
		}
		System.out.println(max);
	}
}
