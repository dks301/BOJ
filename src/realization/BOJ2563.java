package success;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2563 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numOfPaper = Integer.parseInt(br.readLine());
		boolean[][] coloredArea = new boolean[100][100];
		for (int i = 0; i < numOfPaper; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			for (int j = x; j < x + 10; j++) {
				for (int k = y; k < y + 10; k++) {
					coloredArea[j][k] = true;
				}
			}
		}
		
		int result = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (coloredArea[i][j])
					result++;
			}
		}
		System.out.println(result);
	}
}
