package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ4948 {
	private static final String ENTER = "\n";
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while (true) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0)
				break;
			
			int prime = 0;
			
			for (int i = n + 1; i <= 2 * n; i++) {
				int count = 0;
				for (int j = 1; j <= i; j++) {
					if (i % j == 0)
						count++;
				}
				if (count == 2)
					prime++;
			}
			sb.append(prime).append(ENTER);
		}
		br.close();
		System.out.println(sb.toString());
	}
}
