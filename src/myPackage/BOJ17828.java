package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ17828 {
	private static final char A = 'A';
	private static final char Z = 'Z';
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		if (!isPossible(N, X)) { // 다 Z여도 표현 불가능
			System.out.println("!");
			System.exit(0);
		}
		
		System.out.println(solve(N, X));
	}
	
	public static boolean isPossible(int N, int X) {
		return (N * 26) >= X ? (N <= X ? true : false) : false;
	}
	
	public static String solve(int N, int X) {
		StringBuilder sb = new StringBuilder();
		int zLen = getZLen(N, X);
		int aLen = N - zLen;
		
		int remainder = X - (26 * zLen) - aLen;
		if (remainder == 0) {
			for (int i = 0; i < aLen; i++) {
				sb.append(A);
			}
			
			for (int i = 0; i < zLen; i++) {
				sb.append(Z);
			}
			
		} else {
			for (int i = 0; i < aLen - 1; i++) {
				sb.append(A);
			}

			sb.append((char)(remainder + 'A'));
			
			for (int i = 0; i < zLen; i++) {
				sb.append(Z);
			}
		}
		
		return sb.toString();
	}
	
	public static int getZLen(int N, int X) {
		int len = 0;
		while (true) {
			X -= 26;
			if (X < 0) {
				break;
			}
			len++;
		}
		
		return checkTrue(N, len, X - (26 * len)) ? len : len - 1;
	}
	
	public static boolean checkTrue(int N, int zLen, int remainder) {
		int aLen = N - zLen;
		remainder -= aLen;
		if (remainder < 0) {
			System.out.println(remainder + " " + aLen);
			return false; // zLen값 한개 줄이기
		} else {
			return true;
		}
	}
}
