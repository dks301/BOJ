package realization;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11575 {
	static final String SPACE = " ";
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), SPACE);
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			String s = br.readLine();
			char[] e = new char[26];
			char[] temp = s.toCharArray();
			for (int j = 0; j < 26; j++) {
				e[j] = (char)(((a * j + b) % 26) + 65);
			}
			
			for (int j = 0; j < s.length(); j++) {
				sb.append(e[temp[j] - 65]);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
