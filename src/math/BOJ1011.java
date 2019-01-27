package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1011 {
	private static final String NEW_LINE = "\n";
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			long distance = y - x;
			long j;
			for (j = 1; j * j <= distance; j++) {}
			long result = distance - (j - 1) * (j - 1);
			result  = 2 * (j - 1) - 1 + (long)Math.ceil((double)result / (j - 1));
			sb.append(result).append(NEW_LINE);
		}
		System.out.println(sb.toString());
	}
}
