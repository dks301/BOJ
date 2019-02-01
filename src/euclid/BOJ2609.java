package euclid;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2609 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int gcd = gcd(a, b);
		
		System.out.println(gcd + "\n" + lcm(a, b, gcd));
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
	
	public static int lcm(int a, int b, int gcd) {
		return a * b / gcd;
	}
}
