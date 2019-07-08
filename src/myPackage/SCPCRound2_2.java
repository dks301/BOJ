package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SCPCRound2_2 {
	private static final String CASE = "Case #";
	private static final char NEW_LINE = '\n';
	private static final char SPACE = ' ';

	private static int n, ans, sum, max;
	private static int[] a, b, c;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringBuilder sb = new StringBuilder();
			sb.append(CASE).append(t).append(NEW_LINE);
			n = Integer.parseInt(br.readLine());
			a = new int[n + 1];
			b = new int[n + 1];
			for (int i = 0; i < 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= n; j++) {
					if (i == 0) {
						a[j] = Integer.parseInt(st.nextToken());
					} else {
						b[j] = Integer.parseInt(st.nextToken());
					}
				}
			}
			
			c = new int[n + 1];
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= i; j++) {
					if (a[j] == b[j]) {
						c[i]++;
					}
				}
			}
			
			ans = 0;
			for (int i = 1; i <= n; i++) {
				for (int j = n; j > i + ans; j--) {
					if (a[i] == b[j]) {
						max = 0;
						solve(i, j, i, j, 1);
					}
				}
				
				int val = max + c[i];
				if (val > ans) {
					ans = val;
				}
			}
			
			
			System.out.print(sb);
			System.out.println(ans);
		}
	}
	
	public static void solve(int start, int end, int origin, int last, int cnt) {
		if (last == start) {
			if (max < cnt) {
				max = cnt;
			}
			return;
		} else if ((c[origin] + last - start) < ans) {
			return;
		}
		if (a[start] == b[end]) {
			solve(start + 1, end - 1, origin, last, cnt + 1);
		} else {
			solve(start + 1, end - 1, origin , last, cnt);
		}
	}
}
