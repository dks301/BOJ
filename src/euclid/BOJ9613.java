package euclid;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ9613 {
	private static final String NEW_LINE = "\n";
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			long total = 0;
			int size = Integer.parseInt(st.nextToken());
			int[] input = new int[size];
			for (int i = 0; i < size; i++) {
				input[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 0; i < size - 1; i++) {
				for (int j = i + 1; j < size; j++) {
					total += gcd(input[i], input[j]);
				}
			}
			sb.append(total).append(NEW_LINE);
		}
		System.out.println(sb.toString());
	}
	
	public static int gcd(int a, int b) {
		if (b == 0) {
			return a;
		}
		return gcd(b, a % b);
	}
}
