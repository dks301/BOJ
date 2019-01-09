package realization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BOJ10826 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		BigInteger[] bi = new BigInteger[Math.max(n + 1, 2)];
		bi[0] = BigInteger.ZERO;
		bi[1] = BigInteger.ONE;
		for (int i = 2; i <= n; i++) {
			bi[i] = bi[i - 2].add(bi[i - 1]);
		}
		System.out.println(bi[n]);
	}
}
