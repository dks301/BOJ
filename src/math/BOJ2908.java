package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2908 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer(br.readLine());
		StringTokenizer st = new StringTokenizer(sb.reverse().toString());
		int B = Integer.parseInt(st.nextToken());
		int A = Integer.parseInt(st.nextToken());
		System.out.println(B > A ? B : A);
	}
}
