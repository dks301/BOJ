/**
 * @author: AHJ
 */
package realization;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10951 {
	private static final String NEW_LINE = "\n";
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		String temp;
		while((temp = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(temp);
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			sb.append((A + B)).append(NEW_LINE);
		}
		System.out.println(sb.toString());
	}
}
