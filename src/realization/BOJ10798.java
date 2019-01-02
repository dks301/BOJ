package realization;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ10798 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[][] input = new char [5][15];
		int maxLength = 0;
		for (int i = 0; i < 5; i++) {
			char[] temp = br.readLine().toCharArray();
			if (maxLength < temp.length)
				maxLength = temp.length;
			
			for (int j = 0; j < 15; j++) {
				input[i][j] = ' ';
			}
			for (int j = 0; j < temp.length; j++) {
				input[i][j] = temp[j];
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < maxLength; i++) {
			for (int j = 0; j < 5; j++) {
				if (input[j][i] == ' ') {continue;}
				sb.append(input[j][i]);
			}
		}
		System.out.println(sb.toString());
	}
}
