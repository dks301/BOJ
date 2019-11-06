package realization;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Woo4 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] pobi = new int[2];
		int[] crong = new int[2];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		pobi[0] = Integer.parseInt(st.nextToken());
		pobi[1] = Integer.parseInt(st.nextToken());
		crong[0] = Integer.parseInt(st.nextToken());
		crong[1] = Integer.parseInt(st.nextToken());
		
		System.out.println(solution(pobi, crong));
	}
	
	public static int solution(int[] pobi, int[] crong) {
		int a = pobi[0];
		int b = pobi[1];
		int c = crong[0];
		int d = crong[1];
		if (b - a != 1 || d - c != 1) { // 페이지 차이가 1이 아닐때 
 			return -1;
		} else if (a % 2 != 1 || b % 2 != 0) { // 왼쪽 페이지는 홀수여야하고, 오른쪽 페이지는 짝수여야한다.(나머진 불가능)
			return -1;
		} else if (c % 2 != 1 || d % 2 != 0) { //  "
			return -1;
		}
		
		int maxPobi = comparison(comparison(add(a), add(b)), comparison(multip(a), multip(b)));
		int maxCrong = comparison(comparison(add(c), add(d)), comparison(multip(c), multip(d)));;
		
		if (maxPobi == maxCrong) {
			return 0;
		} else if (maxPobi > maxCrong) {
			return 1;
		} else {
			return 2;
		}
	}
	
	public static int comparison(int a, int b) {
		return Math.max(a, b);
	}
	
	public static int add(int val) {
		int[] digits = toDigit(val);
		
		int total = 0;
		for (int i = 0; i < 3; i++) {
			total += digits[i];
		}
		
		return total;
	}
	
	public static int multip(int val) {
		int[] digits = toDigit(val);
		
		boolean isNotZero = false;
		int total = 1;
		for (int i = 0; i < 3; i++) {
			if (digits[i] == 0 && !isNotZero) {
				continue;
				
			} else {
				total *= digits[i];
				isNotZero = true;
			}
		}
		
		return total;
	}
	
	public static int[] toDigit(int val) {
		int[] digits = new int[3];
		
		int div = 100;
		for (int i = 0; i < 3; i++) {
			digits[i] = val / div;
			val %= div;
			div /= 10;
		}
		
		return digits;
	}
}
