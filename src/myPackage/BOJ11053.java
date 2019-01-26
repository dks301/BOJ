package myPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11053 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] d = new int[N + 1];
		d[1] = 1;
		int maxIdx = 1;
		for (int i = 2; i <= N; i++) {
			if (A[i] > A[maxIdx]) {
				d[i] = d[maxIdx] + 1;
				maxIdx = i;
			}
		}
		System.out.println(d[maxIdx]);
	}
}
