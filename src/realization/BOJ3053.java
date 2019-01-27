package realization;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ3053 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int R = Integer.parseInt(br.readLine());

		System.out.printf("%.6f\n", Math.PI * (R * R));
		System.out.printf("%.6f\n", 2.0 * R * R);
	}
}
