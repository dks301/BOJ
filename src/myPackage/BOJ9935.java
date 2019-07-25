package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 문자열 폭발
 * 문자열이 폭발 문자열을 포함하고 있는 경우에, 모든 폭발 문자열이 폭발
 * 이후 남은 문자열을 순서대로 이어붙여 새로운 문자열을 만든다.
 * 새로 생긴 문자열에 폭발 문자열이 포함되어 있을 수 도 있다.
 * 문자열에 폭발 문자열이 없을때까지 반복
 * 
 * 입력
 * 첫째줄: 1이상 1,000,000이하 길이의 문자열
 * 둘째줄: 폭발 문자열  1이상 36이하 길이
 * 두 문자열은 모두 알파벳 대소문자 or 숫자 0~9로 이루어짐
 * 
 * 출력
 * 폭발이 끝난 후 남는 문자열 출력 남아있는 문자가 없으면 "FRULA"출력
 */
public class BOJ9935 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String bomb = br.readLine();
		
		while (str.contains(bomb)) {
			str = str.replaceAll(bomb, "");
		}
		if (str.isEmpty()) {
			System.out.println("FRULA");
		} else {
			System.out.println(str);
		}
	}
}
