package realization;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ9498 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int score = Integer.parseInt(br.readLine());
		if (score < 60)
			System.out.print("F");
		else if (score < 70)
			System.out.print("D");
		else if (score < 80)
			System.out.print("C");
		else if (score < 90)
			System.out.print("B");
		else
			System.out.print("A");
	}
}
