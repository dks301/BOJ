package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 펠린드롬?
 */
public class BOJ10942 {
	private static int N;
	private static int[] A;
	private static int[][] d;
	
	private static final char TRUE = '1';
	private static final char FALSE = '0';
	private static final char NEW_LINE = '\n';
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		A = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		d = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			Arrays.fill(d[i], -1);
		}
		
		for (int i = 1; i <= N; i++) {
			go(i, i);
		}
		
		int M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			sb.append(d[S][E] == 1 ? TRUE : FALSE).append(NEW_LINE);
		}
		System.out.print(sb);
	}
	
	public static void go(int s, int e) {
		if (d[s][e] != -1) {
			return;
		}
		
		if (A[s] == A[e]) {
			d[s][e] = 1;
			if (s >= 2 && d[s - 1][s] == -1) {
				go(s - 1, s);
			}
			
			if (e <= N - 1 && d[e][e + 1] == -1) {
				go(e, e + 1);
			}
			
			if (s >= 2 && e <= N - 1 && d[s - 1][e + 1] == -1) {
				go(s - 1, e + 1);
			}
		} else {
			d[s][e] = 0;
		}
	}
}
