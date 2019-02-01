package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 진법 변환
 * B진법 수 N이 주어질 때, 이 수를 10진법으로 바꿔 출력
 * A:10, B:11, ..., F:15, ..., Z:35
 */
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
