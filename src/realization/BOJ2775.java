package realization;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ2775 {
	private static final String NEW_LINE = "\n";
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		int[][] numOfPeople = new int[15][15];
		for (int i = 1; i <= 14; i++) {
			numOfPeople[0][i] = i;
		}
		for (int i = 1; i <= 14; i++) {
			int sum = 0;
			for (int j = 1; j <= 14; j++) {
				sum += numOfPeople[i - 1][j];
				numOfPeople[i][j] += sum;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			sb.append(numOfPeople[k][n]).append(NEW_LINE);
		}
		System.out.println(sb.toString());
	}
}
