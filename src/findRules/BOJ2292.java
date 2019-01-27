package findRules;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ2292 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int k = 1;
		while (((3 * k * k) - (3 * k) + 1) < N) {
			k++;
		}
		System.out.println(k);
	}
}
