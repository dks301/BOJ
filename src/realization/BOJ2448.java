package success;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ2448 {
	private static final String SPACE = " ";
	private static final String NEW_LINE = "\n";
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		String[] triangle = new String[N];
		triangle[0] = "  *  ";
		triangle[1] = " * * ";
		triangle[2] = "*****";
		
		for (int k = 1; 3 * (int)Math.pow(2, k) <= N; k++) {
			int bottom = 3 * (int)Math.pow(2, k);
			int mid = bottom / 2;
			
			for (int i = mid; i < bottom; i++)
				triangle[i] = triangle[i - mid] + SPACE + triangle[i - mid];
			
			String space = "";
			while (space.length() < mid)
				space += SPACE;
			for (int i = 0; i < mid; i++)
				triangle[i] = space + triangle[i] + space;
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++)
			sb.append(triangle[i]).append(NEW_LINE);
		System.out.println(sb.toString());
	}
	
}
