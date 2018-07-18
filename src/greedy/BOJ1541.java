package realization;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1541 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), "-");
		
		String str[] = new String[st.countTokens()];
		int count = st.countTokens();
		for (int i = 0; i < count; i++) {
			str[i] = st.nextToken();
		}

		int result = 0;
		for (int i = 0; i < count; i++) {
			int sum = 0;
			StringTokenizer bracket = new StringTokenizer(str[i], "+");
			int count2 = bracket.countTokens();
			for (int j = 0; j < count2; j++) {
				sum += Integer.parseInt(bracket.nextToken());
			}
			if (i == 0) {
				result += sum;
			}
			else {
				result -= sum;
			}
		}
		System.out.println(result);
	}
}
