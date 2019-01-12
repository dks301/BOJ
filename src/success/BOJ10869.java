package success;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10869 {
	private static final String NEW_LINE = "\n";
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		sb.append(A + B).append(NEW_LINE);
		sb.append(A - B).append(NEW_LINE);
		sb.append(A * B).append(NEW_LINE);
		sb.append(A / B).append(NEW_LINE);
		sb.append(A % B).append(NEW_LINE);
		System.out.println(sb.toString());
	}
}
