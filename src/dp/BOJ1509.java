package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 팰린드롬 분할
 */
public class BOJ1509 {
	private static char[] str;
	private static int[][] c;
	private static int[] d;
	private static int len;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine().toCharArray();
		len = str.length;
		c = new int[len + 1][len + 1];
		for (int i = 1 ; i <= len; i++) {
			Arrays.fill(c[i], -1);
		}
		
		for (int i = 1; i <= len; i++) {
			go(i, i);
		}
		
		d = new int[len + 1];
		d[0] = 0;
		for (int i = 1; i <= len; i++) {
			d[i] = -1;
			for (int j = 1; j <= i; j++) {
				if (c[j][i] == 1) {
					if (d[i] == -1 || d[i] > d[j - 1] + 1) {
						d[i] = d[j - 1] + 1;
					}
				}
			}
		}
		System.out.println(d[len]);
		
	}
	
	public static void go(int s, int e) {
		if (c[s][e] != -1) {
			return;
		}
		
		if (str[s - 1] == str[e - 1]) {
			c[s][e] = 1;
			
			if (s >= 2 && c[s - 1][s] == -1) {
				go(s - 1, s);
			}
			if (e <= len - 1 && c[e][e + 1] == -1) {
				go(e, e + 1);
			}
			
			if (s >= 2 && e <= len - 1 && c[s - 1][e + 1] == -1) {
				go(s - 1, e + 1);
			}
		} else {
			c[s][e] = 0;
		}
	}
}
