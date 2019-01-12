package success;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ10039 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int total = 0;
		for (int i = 0; i < 5; i++) {
			int temp = Integer.parseInt(br.readLine());
			if (temp < 40) {
				total += 40;
			}
			else {
				total += temp;
			}
		}
		System.out.println(total / 5);
	}
}
