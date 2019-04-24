package realization;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 두 수 비교하기
 * 두 정수 A와 B가 주어졌을 때, A와 B를 비교하는 프로그램 작성
 */
public class BOJ1330 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int result = Integer.parseInt(st.nextToken()) - Integer.parseInt(st.nextToken());
		
		System.out.println(compare(result));
	}
	
	public static String compare(int num) {
		if (num > 0) {
			return ">";
		} else if (num == 0) {
			return "==";
		} else {
			return "<";
		}
	}
}
