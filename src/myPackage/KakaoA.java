package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class KakaoA {
	private static final String NEW_LINE = "\n";
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int prize = first(a) + second(b);
			sb.append(prize).append(NEW_LINE);
		}
		System.out.println(sb.toString());
	}
	
	private static int first(int grade) {
		if (grade >= 1 && grade <= 21) {
			if (grade <= 1)
				return 5000000;
			else if (grade <= 3)
				return 3000000;
			else if (grade <= 6)
				return 2000000;
			else if (grade <= 10)
				return 500000;
			else if (grade <= 15)
				return 300000;
			else
				return 100000;
		}
		return 0;
	}
	
	private static int second(int grade) {
		if (grade >= 1 && grade <= 31) {
			if (grade <= 1)
				return 5120000;
			else if (grade <= 3)
				return 2560000;
			else if (grade <= 7)
				return 1280000;
			else if (grade <= 15)
				return 640000;
			else
				return 320000;
		}
		return 0;
	}
}
