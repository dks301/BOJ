package realization;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ1032 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[][] input = new char[N][];
		
		for (int i = 0; i < N; i++) {
			input[i] = br.readLine().toCharArray();
		}
		
		int[] count = new int[input[0].length];
		for (int i = 0; i < input[0].length; i++) {
			for (int j = 1; j < N; j++) {
				if (input[j][i] == input[j - 1][i])
					count[i]++;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < input[0].length; i++) {
			if (count[i] == (N - 1)) {
				sb.append(input[0][i]);
			}
			else
				sb.append("?");
		}
		System.out.println(sb.toString());
	}
}
