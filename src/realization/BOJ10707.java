package success;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ10707 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		int D = Integer.parseInt(br.readLine());
		int P = Integer.parseInt(br.readLine());
		
		int x = P * A;
		int y = P < C + 1 ? B : B + (P - C) * D;
		
		System.out.println(x > y ? y : x);
	}
}
