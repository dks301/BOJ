package realization;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10822 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), ",");
		
		int total = 0;
		while (st.hasMoreTokens()) {
			total += Integer.parseInt(st.nextToken());
		}
		System.out.println(total);
	}
}
