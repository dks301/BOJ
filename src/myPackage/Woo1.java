package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Woo1 {
	private static final int[] UNITS = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int money = Integer.parseInt(br.readLine());
		int[] ans = solution(money);
		for (int i = 0; i < 9; i++) {
			System.out.print(ans[i] + " ");
		}
		System.out.println();
	}
	
	public static int[] solution(int money) {
		int[] result = new int[9];
		for (int i = 0; i < 9; i++) {
			int[] temp = count(money, i);
			result[i] = temp[0];
			money = temp[1];
		}
		
		
		return result;
	}
	
	public static int[] count(int money, int unit) {
		int[] arr = new int[2];
		arr[0] = money / UNITS[unit];
		arr[1] = money % UNITS[unit];
		return arr;
	}
}
