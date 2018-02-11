package realization;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ5212 {
	private static final String SPACE = " ";
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), SPACE);
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		char map[][] = new char[R + 2][C + 2];
		char tmp[][] = new char[R + 2][C + 2];
		char map2[][] = new char[R + 2][C + 2];
		
		for(int i = 0; i < R + 2; i++){
			Arrays.fill(map[i], '.');
		}
		
		for(int i = 0; i < R; i++){
			tmp[i] = br.readLine().toCharArray();
		}
		br.close();
		
		for (int i = 1; i < R + 1; i++) {
			for (int j = 1; j < C + 1; j++) {
				map[i][j] = tmp[i - 1][j - 1];
				map2[i][j] = map[i][j];
			}
		}
		int count = 0;
		for (int i = 1; i < R + 1; i++) {
			for (int j = 1; j < C + 1; j++) {
				if (map[i][j] == 'X') {
					count = 0;
					if (map[i - 1][j] == '.')
						count++;
					if (map[i + 1][j] == '.')
						count++;
					if (map[i][j - 1] == '.')
						count++;
					if (map[i][j + 1] == '.')
						count++;
					if (count >= 3)
						map2[i][j] = '.';
				}
			}
		}
		int i, j;
		int RS = 1, RE = R, Rcount = 0;
		int CS = 1, CE = C, Ccount = 0;
		
		for (i = 1; i < R + 1; i++) {
			Rcount = 0;
			for (j = 1; j < C + 1; j++) {
				if (map2[i][j] == '.')
					Rcount++;
			}
			if (Rcount == C && i == RS)
				RS++;
			else if (Rcount == C && i == RE) {
				RE--;
				i = i - 2;
			}
		}
		
		for (j = 1; j < C + 1; j++) {
			Ccount = 0;
			for (i = 1; i < R + 1; i++) {
				if (map2[i][j] == '.')
					Ccount++;
			}
			if (Ccount == R && j == CS)
				CS++;
			else if (Ccount == R && j == CE) {
				CE--;
				j = j - 2;
			}
		}
		
		for (i = RS; i < RE + 1; i++) {
			for (j = CS; j < CE + 1; j++) {
				System.out.print(map2[i][j]);
			}
			System.out.println();
		}
	}
}
