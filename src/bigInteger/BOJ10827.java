package bigInteger;

import java.math.BigDecimal;
import java.util.Scanner;
/*
 * a^b
 * a^b를 정확하게 출력
 */
public class BOJ10827 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BigDecimal a = sc.nextBigDecimal();
		System.out.println(a.pow(sc.nextInt()).toPlainString());
	}
}
