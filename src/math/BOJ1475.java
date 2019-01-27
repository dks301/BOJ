package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ1475 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] N = br.readLine().toCharArray();
		int [] digit = new int[10];

		for (int i = 0; i < N.length; i++) {
			digit[Character.getNumericValue(N[i])]++;
		}
		digit[6] = (int)Math.ceil((double)(digit[6] + digit[9]) / 2);
		int max = 0;
		for (int i = 0; i < 9; i++) {
			if (digit[i] > max) {
				max = digit[i];
			}
		}
		System.out.println(max);
	}
}
