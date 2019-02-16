package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 바둑
 * 바둑판의 크기 (1<=N<=15)
 * 완전히 검은돌로 둘러쌓이면 집으로 친다.
 * 집의 크기를 출력
 */
public class BOJ2071 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N + 2][N + 2];
		int[][] board = new int[N + 2][N + 2];
		Arrays.fill(board, -1);
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) { // 위에서부터 아래로 각 행에 놓여 있는 돌의 갯수
			arr[i][0] = Integer.parseInt(st.nextToken());
			if (arr[i][0] == 0) {
				for (int j = 1; j <= N; j++) {
					board[i][j] = 0;
				}
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) { // 왼쪽부터 오른쪽까지 각 열에 놓여 있는 돌의 갯수
			arr[0][i] = Integer.parseInt(st.nextToken());
			for (int j = 1; j <= N; j++) {
				board[i][j] = 0;
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= 2 * N - 1; i++) { // 왼쪽 위부터 오른쪽 아래까지  /형태의 대각선 줄에 놓여있는 돌의 갯수
			int temp = Integer.parseInt(st.nextToken());
			for (int j = 1; j <= i; j++) {
				
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= 2 * N - 1; i++) { // 왼쪽 아래부터 오른쪽 위까지  \형태의 대각선 줄에 놓여있는 돌의 갯수
			
		}
	}
}
