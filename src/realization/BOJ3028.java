package realization;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 창영마을
 * A: 1과 2를 바꾸기
 * B: 2와 3을 바꾸기
 * C: 1과 3을 바꾸기
 * 컵을 섞은 방법이 주어질 때, 어떤 컵에 공이 있는지 출력
 */
public class BOJ3028 {
	private static byte cup = 4;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] shuffle = br.readLine().toCharArray();
		
		for (int i = 0; i < shuffle.length; i++) {
			switch (shuffle[i]) {
			case 'A':
				A();
				break;
				
			case 'B':
				B();
				break;
				
			case 'C':
				C();
				break;
			}
		}
		
		if (cup == 4) {
			System.out.println(1);
		} else if (cup == 2) {
			System.out.println(2);
		} else {
			System.out.println(3);
		}
	}
	
	public static void A() {
		if (cup == 4) {
			cup = (byte)(cup >> 1);
		} else if (cup == 2) {
			cup = (byte)(cup << 1);
		}
	}
	
	public static void B() {
		if (cup == 2) {
			cup = (byte)(cup >> 1);
		} else if (cup == 1) {
			cup = (byte)(cup << 1);
		}
	}
	
	public static void C() {
		if (cup == 4) {
			cup = (byte)(cup >> 2);
		} else if (cup == 1) {
			cup = (byte)(cup << 2);
		}
	}
}
