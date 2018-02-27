package realization;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1316 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int count = N;
		
		for (int i = 0; i < N; i++) {
			char[] input = br.readLine().toCharArray();	
			int[] alpha = new int[26];
			Arrays.fill(alpha, 0);
			
			alpha[input[0] - 97] = 1;
			for (int j = 1; j < input.length; j++) {
				alpha[input[j] - 97]++;
				if (input[j] == input[j - 1])
					alpha[input[j] - 97]--;
			}
			
			for (int j = 0; j < 26; j++) {
				if (alpha[j] > 1) {
					count--;
					break;
				}
			}
		}
		System.out.println(count);
	}
}
