package myPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11052 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] p = new int[N + 1];
		int[] d = new int[N + 1];
		
		p[0] = 0;
		d[0] = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		p[1] = Integer.parseInt(st.nextToken());
		d[1] = p[1];
		for (int i = 2; i <= N; i++) {
			p[i] = Integer.parseInt(st.nextToken());
			d[i] = Math.max(d[i - 1] + d[1], p[i]);
			System.out.print("P[" + i + "]: " + p[i]);
			System.out.println(" D[" + i + "]: " + d[i]);
		}
		System.out.println(d[N]);
	}
}
