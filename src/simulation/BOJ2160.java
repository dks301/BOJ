package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 그림 비교
 * N(2<=N<=50)개의 그림이 있다.
 * 각 그림은 5x7 크기이고, 두 가지 색으로 되어 있다. ('X' or '.')
 * 가장 비슷한 두 개의 그림을 출력
 */
public class BOJ2160 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		char[][][] paint = new char[N][5][7];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 5; j++) {
				char[] temp = br.readLine().toCharArray();
				for (int k = 0; k < 7; k++) {
					paint[i][j][k] = temp[k];
				}
			}
		}
		
		int min = Integer.MAX_VALUE;
		int minA = -1;
		int minB = -1;
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				int temp = compare(paint[i], paint[j]);
				if (temp < min) {
					min = temp;
					minA = i;
					minB = j;
				}
			}
		}
		System.out.println((minA + 1) + " " + (minB + 1));
	}
	
	public static int compare(char[][] a, char[][] b) {
		int cnt = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 7; j++) {
				if (a[i][j] != b[i][j]) {
					cnt++;
				}
			}
		}
		return cnt;
	}
}
