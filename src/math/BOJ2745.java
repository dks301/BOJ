package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2745 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		char[] N = st.nextToken().toCharArray();
		int B = Integer.parseInt(st.nextToken());
		
		int result = 0;
		int len = N.length;
		for (int i = 0; i < len; i++) {
			int temp = (int)N[i];
			if (temp >= 65) {
				temp -= 55;
			} else {
				temp -= 48;
			}
			result += temp * (int)Math.pow(B, len - i - 1);
		}
		System.out.println(result);
	}
}
