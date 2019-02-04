package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2004 {
	private static final int TWO = 2;
	private static final int FIVE = 5;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int cntFive = 0, cntTwo = 0;
		for (int i = 2; i <= n; i += 2) {
			
		}
		for (int i = 1; i <= n; i++) {
			int temp = i;
			while (temp % TWO == 0) {
				temp /= TWO;
				cntTwo++;
			}
			while (temp % FIVE == 0) {
				temp /= FIVE;
				cntFive++;
			}
			if (i == m) {
				cntFive_m = cntFive;
				cntTwo_m = cntTwo;
			}
			if (i == (n - m)) {
				cntFive_mn = cntFive;
				cntTwo_mn = cntTwo;
			}
		}
		cntTwo = cntTwo - cntTwo_m - cntTwo_mn;
		cntFive = cntFive - cntFive_m - cntFive_mn;
		System.out.println(Math.min(cntTwo, cntFive));
	}
}
