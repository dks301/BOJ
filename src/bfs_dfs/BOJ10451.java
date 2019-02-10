package bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 순열 사이클
 * 순열의 크기(2<=N<=1,000)
 * 순열 사이클의 갯수 출력.
 */
public class BOJ10451 {
	private static final String NEW_LINE = "\n";
	private static boolean[] check;
	private static int[] a;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());

			a = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}
			check = new boolean[N + 1];
			int cnt = 0;
			for (int i = 1; i <= N; i++) {
				if (check[i] == false) {
					cnt++;
					dfs(i);
				}
			}
			sb.append(cnt).append(NEW_LINE);
		}
		System.out.println(sb);
	}
	
	public static void dfs(int x) {
		check[x] = true;
		
		int y = a[x];
		if (check[y] == false) {
			dfs(y);
		}
	}
}
