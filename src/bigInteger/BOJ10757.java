package bigInteger;

import java.util.Scanner;

/*
 * 큰 수 A + B
 */

public class BOJ10757 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(sc.nextBigInteger().add(sc.nextBigInteger()));
	}
}
