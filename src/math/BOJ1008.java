package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1008 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		sb.append(Double.parseDouble(st.nextToken()) / Double.parseDouble(st.nextToken()));
		System.out.println(sb.toString());
	}
}
