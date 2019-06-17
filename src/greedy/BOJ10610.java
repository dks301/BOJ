package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 30
 * 양수 N을 섞어서 30의 배수가 되는 가장 큰 수 만들기
 * 
 * 입력
 * N을 입력 받는다. N은 최대 10^5개의 숫자로 구성, 0으로 시작x
 * 
 * 출력
 * 30의 배수중 가장 큰수, 30의 배수가 없다면 -1;
 */
public class BOJ10610 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] N = br.readLine().toCharArray();
		Arrays.sort(N);
		StringBuilder sb = new StringBuilder();
		if (N[0] != '0') {
			sb.append(-1);
		} else {
			int sum = 0;
			for (int i = 0; i < N.length; i++) {
				sum += (N[i] - '0');
			}
			if (sum % 3 == 0) {
				for (int i = N.length - 1; i >= 0; i--) {
					sb.append(N[i]);
				}
			} else {
				sb.append(-1);
			}
		}
		System.out.println(sb.toString());
	}
}
