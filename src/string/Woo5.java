package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Woo5 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		
		System.out.println(solution(num));
	}
	
	public static int solution(int number) {
		int cnt = 0;
		for (int i = 1; i <= number; i++) {
			cnt += count(i);
		}
		return cnt;
	}
	
	public static int count(int number) {
		char[] digits = String.valueOf(number).toCharArray();
		int cnt = 0;
		
		for (char next : digits) {
			if (next == '3' || next == '6' || next == '9') {
				cnt++;
			}
		}
		
		return cnt;
	}
}
