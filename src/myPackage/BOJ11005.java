package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ11005 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		Stack<Integer> s = new Stack<>();
		
		while (N != 0) {
			s.push(N % B);
			N /= B;
		}
		
		StringBuilder sb = new StringBuilder();
		while (!s.isEmpty()) {
			int temp = s.pop();
			if (temp >= 10 && temp <= 35) {
				temp = temp + 55;
				sb.append((char)temp);
			} else {
				sb.append(temp);
			}
		}
		System.out.println(sb.toString());
	}
}
