package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class KakaoC {
	private static final String AND = "&&";
	private static final String EQUAL = "==";
	private static final String NOT_EQUAL = "!=";

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		if (str.contains(AND)) {
			StringTokenizer st = new StringTokenizer(br.readLine(), "&&");

			int count = st.countTokens();
			String[] S = new String[count * 2];
			for (int i = 0; i < count; i++) {
				String temp = st.nextToken();
				if (temp.contains(EQUAL)) {
					StringTokenizer st2 = new StringTokenizer(temp, EQUAL);
				}
				else if (temp.contains(NOT_EQUAL)) {
					StringTokenizer st2 = new StringTokenizer(temp, NOT_EQUAL);
				}
					
			}
		}
		else {
			System.out.println(str);
		}
	}
}
