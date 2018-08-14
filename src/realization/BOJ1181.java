package success;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1181 {
	private static final String NEW_LINE = "\n";
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		String[][] words = new String[51][N];
		for (int i = 0; i < 51; i++)
			Arrays.fill(words[i], " ");
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			words[temp.length()][i] = temp;
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 51; i++) {
			Arrays.sort(words[i]);
			for (int j = 0; j < N; j++) {
				if (j == 0 && !words[i][j].equals(" ")) {
					sb.append(words[i][j]).append(NEW_LINE);
				}
				else {
					if (!words[i][j].equals(" ") && !words[i][j - 1].equals(words[i][j])) {
						sb.append(words[i][j]).append(NEW_LINE);
					}
				}
			}
		}
		System.out.println(sb.toString());
	}
}
