package realization;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10430 {
	private static final String NEW_LINE = "\n";
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		StringBuilder sb = new StringBuilder();
		sb.append((A + B) % C).append(NEW_LINE);
		sb.append((A % C + B % C) % C).append(NEW_LINE);
		sb.append((A * B) % C).append(NEW_LINE);
		sb.append((A % C * B % C) % C).append(NEW_LINE);
		System.out.println(sb.toString());
	}
}
