package myPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11722 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}
		
	}
}
