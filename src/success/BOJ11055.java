package success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11055 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] A = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] d = new int[N + 1];
		d[1] = A[1];
		for (int i = 2; i <= N; i++) {
			d[i] = A[i];
			for (int j = 1; j < i; j++) {
				if (A[i] > A[j] && (d[j] + A[i] > d[i])) {
					d[i] = d[j] + A[i];
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
