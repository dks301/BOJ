package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
/*
 * 사회망 서비스(SNS)
 * 정점(2<=N<=1,000,000)
 * 얼리어덥터가 아닌 사람들은 친구가 모두 얼리어덥터일 때만 새로운 아이디어를 받아들임
 * 트리가 주어질 때, 모든 사람이 새로운 아이디어를 받아들일 수 있도록 하는 얼리어덥터의 최소 수 출력
 */
public class BOJ2533 {
	private static ArrayList<Integer>[] a;
	private static int[] check;
	private static int[] d;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		a = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			a[i] = new ArrayList<Integer>();
		}
		check = new int[N + 1];
		d = new int[N + 1];
		
		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			a[u].add(v);
			a[v].add(u);
		}
		for (int i = 1; i <= N; i++) {
			Collections.sort(a[i]);
		}
		d[1] = 1;
		dfs(1);
	}
	
	public static void dfs(int x) {
		if (x == 1) {
			check[x] = a[x].size();
		} else {
			check[x] = a[x].size() - 1;
		}
		if (x > 1) {
			d[x] = Math.min(d[x - 1] + check[x - 1], d[x - 2] + check[x]);
		}
		System.out.println(x + " " + d[x]);
		for (int i = 0; i < a[x].size(); i++) {
			int y = a[x].get(i);
			if (check[y] == 0) {
				dfs(y);
			}
		}
	}
}
