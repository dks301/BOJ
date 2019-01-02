package realization;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ2920 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String ascending = "1 2 3 4 5 6 7 8";
		String descending= "8 7 6 5 4 3 2 1";
		String output = input.equals(ascending) ? 
				"ascending" : (input.equals(descending) ? "descending" : "mixed");
		System.out.println(output);
	}
}
