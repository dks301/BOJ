package realization;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ5585 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int pay = Integer.parseInt(br.readLine());
		int change = 1000 - pay;
		int count = 0;
		count += change / 500; change = change % 500;
		count += change / 100; change = change % 100;
		count += change / 50; change = change % 50;
		count += change / 10; change = change % 10;
		count += change / 5; change = change % 5;
		count += change / 1; change = change % 1;
		
		System.out.println(count);
	}
}
