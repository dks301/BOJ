package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 2진수 8진수
 * 2진수 -> 8진수로 변환
 */
public class BOJ1373 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int len = input.length();
		switch (len % 3) {
		case 0:
			break;
		case 1:
			input = "00" + input;
			break;
		case 2:
			input = "0" + input;
			break;
		}
		char[] binary = input.toCharArray();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < binary.length; i = i + 3) {
			int temp = (binary[i] - '0') * 4;
			temp += (binary[i + 1] - '0') * 2;
			temp += binary[i + 2] - '0';
			sb.append(temp);
		}
		System.out.println(sb.toString());
	}
}
