package bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 연결 요소의 개수
 * 정점의 갯수(1<=N<=1,000), 간선의 갯수(0<=M<=N(N-1)/2)
 * 연결 요소의 개수 출력
 */
public class BOJ11724 {
	private static boolean[] check;
	private static ArrayList<Integer>[] a;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		a = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			a[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			a[u].add(v);
			a[v].add(u);
		}
		
		check = new boolean[N + 1];
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			if (check[i] == false) {
				cnt++;
				bfs(i);
				//dfs(i);
			}
		}
		System.out.println(cnt);
	}
	
	public static void dfs(int x) {
		check[x] = true;
		for (int i = 0; i < a[x].size(); i++) {
			int y = a[x].get(i);
			if (check[y] == false) {
				dfs(y);
			}
		}
	}
	
	public static void bfs(int x) {
		Queue<Integer> q = new LinkedList<>();
		q.add(x);
		check[x] = true;
		while (!q.isEmpty()) {
			x = q.poll();
			for (int i = 0; i < a[x].size(); i++) {
				int y = a[x].get(i);
				if (check[y] == false) {
					check[y] = true;
					q.add(y);
				}
			}
		}
	}
}
