package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ2839 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int five = N / 5;
		int three = (N % 5) / 3;
		if (N % 3 == 0 && ((N % 5) % 3) != 0)
			System.out.println(N / 3);
		else
			System.out.println(((N % 5) % 3) != 0 ? -1 : five + three);
	}
}
