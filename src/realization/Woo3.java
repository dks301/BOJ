package realization;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Woo3 {	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine();
		
		System.out.println(solution(word));
	}
	
	public static String solution(String word) {
		char[] str = word.toCharArray();
		
		for (int i = 0; i < str.length; i++) {
			str[i] = change(str[i]);
		}
		
		return String.valueOf(str);
	}
	
	public static char change(char a) {
		int b = a - 0;
		if (b >= 65 && b <= 90) {
			b = 90 - a + 65;
		} else if (b >= 97 && b <= 122){
			b = 122 - a + 97;
		}
		return (char)b;
	}
}
