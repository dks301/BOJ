package success;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ11720 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[] numbers = br.readLine().toCharArray();
		int total = 0;
		
		for (int i = 0; i < N; i++) {
			total += Integer.parseInt(String.valueOf(numbers[i]));
		}
		System.out.println(total);
	}
}
