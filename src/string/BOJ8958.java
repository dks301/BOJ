package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ8958 {
	private static final String NEW_LINE = "\n";
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < tc; i++) {
			int score = 0;
			int result = 0;
			char[] ox = br.readLine().toCharArray();
			for (int j = 0; j < ox.length; j++) {
				if (ox[j] == 'O') {
					score++;
					result += score;
				}
				else if (ox[j] == 'X') {
					score = 0;
				}
			}
			sb.append(result).append(NEW_LINE);
		}
		System.out.println(sb.toString());
	}
}
