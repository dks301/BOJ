package myPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11052 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int max = 0;
		P[] P = new P[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			P[i] = new P(i, Integer.parseInt(st.nextToken()));
			if (max < P[i].value) {
				max = P[i].value;
			}
		}
	}
	static class P {
		int idx;
		int value;
		double price;
		
		public P(int idx, int price) {
			this.idx = idx;
			this.price = price;
			this.value = price / idx;
		}
	}
}
