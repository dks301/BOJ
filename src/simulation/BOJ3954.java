package simulation;

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
	private static int[] input;
	private static int i_idx;
	
	private static final int MOD = 256;
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
			
			char[] temp = br.readLine().toCharArray();
			input = new int[si];
			for (int i = 0; i < si; i++) {
				input[i] = (int)temp[i];
			}
			temp = null;
			i_idx = 0;
			
			Stack<Pair> a = new Stack<>();
			int cnt = 0;
			boolean isTerminate = false;
			for (int i = 0; i < sc; i++) {
				if (++cnt > 50_000_000) {
					break;
				}
				char c = code[i];
				if (c == '[') {
					int j = i + 1;
					int size = 1;
					while (size != 0) {
						if (code[j] == '[') {
							size++;
						}
						if (code[j] == ']') {
							size--;
						}
						j++;
					}
					a.push(new Pair(i, j - 1));
				}
				
				int result = cmd(c);
				//System.out.println(cnt + ": " + c + " " + result);
				if (result < 0) {
					isTerminate = true;
					break;
					
				} else if (result == 1) {
					Pair p = a.pop();
					i = p.end;
					p = null;
					
					if (i == sc - 1) {
						isTerminate = true;
						break;
					}
					
				} else if (result == 2) {
					i = a.peek().start;
					
				} else if (result == 0) {
					if (c == ']') {
						Pair p = a.pop();
						p = null;
				
					}
					if (i == sc - 1) {
						isTerminate = true;
					}
				}
			}
			
			if (isTerminate) {
				sb.append(T).append(NEW_LINE);
			} else {
				Pair p;
				while (a.size() != 1) {
					p = a.pop();
					p = null;
				}
				p = a.pop();
				sb.append(L).append(p.start).append(SPACE).append(p.end).append(NEW_LINE);
				p = null;
			}
			
			data = null;
			code = null;
			input = null;
			a = null;
			Runtime.getRuntime().gc();
		}
//		Runtime.getRuntime().gc();
//		long used = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
//		System.out.println("used memory is: " + used + "bytes");
		System.out.print(sb);
		
		br.close();
	}
	
	public static int cmd(char ch) {
		switch (ch) {
		case '-':
			data[p]--;
			if (data[p] == -256) {
				data[p] %= MOD;
			}
			break;
			
		case '+':
			data[p]++;
			if (data[p] == 256) {
				data[p] %= MOD;
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
			}
			break;
		}
		return 0; // 정상 종료 -> 다음 c_idx로 넘어가기
	}
	
	public static class Pair {
		int start, end;
		
		public Pair(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
}
