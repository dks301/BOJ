package euclid;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1934 {
	private static final String NEW_LINE = "\n";
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int gcd = gcd(A, B);
			long lcm = A * B / gcd;
			sb.append(lcm).append(NEW_LINE);
		}
		System.out.println(sb.toString());
	}
	
	public static int gcd(int a, int b) {
		int gcd = 0;
		while (b != 0) {
			gcd = b;
			b = a % b;
			a = gcd;
		}
		return gcd;
	}
}
