package success;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ11772 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int result = 0;
		
		for (int i = 0; i < N; i++) {
			String P = br.readLine();
			String a = P.substring(0, P.length() - 1);
			String b = P.substring(P.length() - 1);
			int number = Integer.parseInt(a);
			int pot = Integer.parseInt(b);
			result += Math.pow(number, pot);
		}
		System.out.println(result);
	}
}
