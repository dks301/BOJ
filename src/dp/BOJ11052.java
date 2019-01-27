package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11052 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] p = new int[N + 1];
		p[0] = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			p[i] = Integer.parseInt(st.nextToken());
		}
		int[] d = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			int max = 0;
			for (int j = 1; j <= i; j++) {
				if (max < d[i - j] + p[j]) {
					max = d[i - j] + p[j];
				}
			}
			d[i] = max;
		}
		System.out.println(d[N]);
	}
}
