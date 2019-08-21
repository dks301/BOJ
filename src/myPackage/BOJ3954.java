package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ3954 {
	private static int sm, sc, si;
	
	private static int[] data;
	private static int p;
	private static char[] code;
	private static int c_idx;
	private static int[] input;
	private static int i_idx;
	
	private static final int MAX = 255;
	private static final int MIN = 0;
	private static final String T = "Terminates";
	private static final String L = "Loops ";
	private static final char SPACE = ' ';
	private static final char NEW_LINE = '\n';
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			sm = Integer.parseInt(st.nextToken());
			sc = Integer.parseInt(st.nextToken());
			si = Integer.parseInt(st.nextToken());
			
			data = new int[sm];
			p = 0;
			
			code = br.readLine().toCharArray();
			c_idx = 0;
			
			input = new int[si];
			i_idx = 0;
			
			ArrayList<Pair> al = new ArrayList<>();
			Stack<Pair> a = new Stack<>();
			int cnt = 0;
			boolean isTerminate = false;
			for (int i = 0; i < sc; i++) {
				if (++cnt > 50_000_000) {
					break;
				}
				char c = code[i];
				if (c == '[') {
					a.push(new Pair(i));
				}
				
				int result = cmd(c);
				if (result < 0) {
					isTerminate = true;
					break;
					
				} else if (result == 1) {
					int j = i;
					while (code[j] == ']') {
						
					}
				} else if (result == 2) {
					int j = i - 1;
					while (code[j] != '[') {
						j--;
					}
					i = j + 1;
					
				} else if (result == 0) {
					if (c == ']') {
						a.pop();
					}
				}
			}
			
			if (isTerminate) {
				sb.append(T).append(NEW_LINE);
			} else {
				sb.append(L).append('a').append(SPACE).append('b').append(NEW_LINE);
			}
		}
		
		System.out.print(sb);
	}
	
	public static int cmd(char ch) {
		switch (ch) {
		case '-':
			data[p]--;
			if (data[p] < MIN) {
				// value underflow
				return -1;
			}
			break;
			
		case '+':
			data[p]++;
			if (data[p] > MAX) {
				// value overflow
				return -2;
			}
			break;
			
		case '<':
			p--;
			if (p < 0) {
				p = sm - 1;
			}
			break;
			
		case '>':
			p++;
			if (p > sm - 1) {
				p = 0;
			}
			break;
			
		case '[':
			if (data[p] == 0) {
				return 1; // 반복문통과
			}
			break;
			
		case ']':
			if (data[p] != 0) { // 반복
				return 2;
			}
			break;
			
		case '.':
			break;
			
		case ',':
			if (i_idx < si) {
				data[p] = input[i_idx++];
			} else if (i_idx == si) {
				data[p] = 255;
			} else { // 읽을 문자가 없을 때
				return -3;
			}
			break;
		}
		return 0; // 정상 종료 -> 다음 c_idx로 넘어가기
	}
	
	public static class Pair {
		int a, b;
		
		public Pair(int a) {
			this.a = a;
		}
	}
}
