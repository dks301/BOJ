package realization;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2675 {
	private static final String NEW_LINE = "\n";
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			char[] S = st.nextToken().toCharArray();
			
			for (int j = 0; j < S.length; j++) {
				for (int k = 0; k < R; k++) {
					sb.append(S[j]);
				}
			}
			sb.append(NEW_LINE);
		}
		System.out.println(sb.toString());
	}
}
