package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * KMP는 왜 KMP일까?
 * Knuth-Morris-Pratt: 긴형태
 * KMP: 짧은 형태
 * 입력은 최대 100글자의 알파벳 대소문자, 하이픈'-'로만 이루어져있다.
 * 첫글자와 하이픈 뒤는 항상 대문자, 그 외는 모두 소문자
 * 긴 형태가 주어질 때, 짧은 형태를 출력
 */
public class BOJ2902 {
	private static final String HYPHEN = "-";
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), HYPHEN);
		
		StringBuilder sb = new StringBuilder();
		while (st.hasMoreTokens()) {
			sb.append(st.nextToken().charAt(0));
		}
		System.out.print(sb);
	}
}
