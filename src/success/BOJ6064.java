package success;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ6064 {
	private static final String NEW_LINE = "\n";
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			int lcm = LCM(M, N);
			boolean isValid = false;
			for (int j = x; j <= lcm; j += M) {
				if (j % N == y || (j % N == 0 && N == y)) {
					sb.append(j);
					isValid = true;
					break;
				}
			}
			if (isValid)
				sb.append(NEW_LINE);
			else
				sb.append("-1").append(NEW_LINE);
		}
		System.out.println(sb.toString());
	}
	
	private static int LCM(int a, int b) {
		int gcd_value = GCD(a, b);
		if (gcd_value == 0)
			return 0;
		return Math.abs((a * b) / gcd_value);
	}
	
	private static int GCD(int a, int b) {
		while (b != 0) {
			int temp = a % b;
			a = b;
			b = temp;
		}
		return Math.abs(a);
	}
}
