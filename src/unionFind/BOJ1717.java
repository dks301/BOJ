package unionFind;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 집합의 표현
 */
public class BOJ1717 {
	private static int[] p;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		p = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			p[i] = i;
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int cal = Integer.parseInt(st.nextToken());
			switch (cal) {
			case 0:
				union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				break;
				
			case 1:
				int a = find(Integer.parseInt(st.nextToken()));
				int b = find(Integer.parseInt(st.nextToken()));
				System.out.println(a == b ? "YES" : "NO");
				break;
			}
		}
	}
	
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		p[y] = x;
	}
	
	public static int find(int x) {
		if (x == p[x]) {
			return x;
		} else {
			int y = find(p[x]);
			p[x] = y;
			return y;
		}
	}
}
