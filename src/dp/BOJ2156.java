package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * 포도주 시식
 * 1. 포도주 잔을 선택하면 그 잔의 포도주는 모두 마셔야하고, 마신 후에는 원래 위치에 놓아야 함.
 * 2. 연속으로 놓여 있는 3잔을 모두 마실 순 없다.
 * 위 2조건을 만족하면서 최대로 마실 수 있는 포도주의 양 출력 
 */
public class BOJ2156 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] podo = new int[n + 1];
		
		for (int i = 1; i <= n; i++) {
			podo[i] = Integer.parseInt(br.readLine());
		}
		
		int[][] d = new int[n + 1][2];
		d[0][0] = 0;
		d[0][1] = 0;
		d[1][0] = 0;
		d[1][1] = podo[1];
		for (int i = 2; i <= n; i++) {
			d[i][0] = d[i - 1][1];
			d[i][1] = max(d[i - 2][0] + podo[i - 1] + podo[i], d[i - 1][0] + podo[i], d[i - 1][1]);
		}
		System.out.println(d[n][1]);
	}
	
	public static int max(int a, int b, int c) {
		return a > b ? (a > c ? a : c) : (b > c ? b : c);
	}
}
