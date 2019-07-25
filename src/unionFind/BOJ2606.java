package unionFind;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 바이러스
 */
public class BOJ2606 {
	private static int[] p;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		p = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			p[i] = i;
		}
		
		int m = Integer.parseInt(br.readLine());
		while (m-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a, b);
		}
		
		int ans = 0;
		for (int i = 2; i <= n; i++) {
			if (find(1) == find(i)) 
				ans++;
		}
		System.out.println(ans);
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
