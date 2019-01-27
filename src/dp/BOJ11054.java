package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11054 {
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
				if (A[i] > A[j] && d[i] < d[j] + 1) {
					d[i] = d[j] + 1;
				}
			}
		}
		int[] d2 = new int[N + 1];
		for (int i = N; i >= 1; i--) {
			d2[i] = 1;
			for (int j = N; j > i; j--) {
				if (A[i] > A[j] && d2[i] < d2[j] + 1) {
					d2[i] = d2[j] + 1;
				}
			}
		}
		
		int max = 0;
		for (int i = 1; i <= N; i++) {
			if (max < (d[i] + d2[i] - 1)) {
				max = d[i] + d2[i] - 1;
			}
		}
		System.out.println(max);
	}
}
