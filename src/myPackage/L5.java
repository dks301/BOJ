package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class L5 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] check = new int[m + 1][n + 1];
		
		st = new StringTokenizer(br.readLine());
		int col = Integer.parseInt(st.nextToken());
		int row = Integer.parseInt(st.nextToken());
		if (row < 0 || col < 0 || row > m || col > n) {
			System.out.println("fail");
		} else {
			int ans = row + col;
			System.out.println(ans);
			
			check = new int[m + 1][n + 1];
			for (int i = 0; i <= m; i++) {
				check[i][0] = 1;
			}
			for (int j = 0; j <= n; j++) {
				check[0][j] = 1;
			}
			for (int i = 1; i <= row; i++) {
				for (int j = 1; j <= col; j++) {
					check[i][j] = check[i - 1][j] + check[i][j - 1];
					System.out.print(check[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println(check[row][col]);
		}
	}
}
