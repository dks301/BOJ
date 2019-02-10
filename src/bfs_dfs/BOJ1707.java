package bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 이분 그래프
 * 그래프가 입력으로 주어졌을 때, 이분 그래프인지 아닌지 판별하기
 * TC(2<=K<=5)
 * 정점(1<=V<=20,000), 간선(1<=E<=200,000)
 */
public class BOJ1707 {
	private static int[] check; //0: 방문x, 1: 방문o(빨), 2: 방문o(파)
	private static ArrayList<Integer>[] a;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		while (K-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			a = new ArrayList[V + 1];
			for (int i = 1; i <= V; i++) {
				a[i] = new ArrayList<>();
			}
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				a[u].add(v);
				a[v].add(u);
			}
			check = new int[V + 1];
			for (int i = 1; i <= V; i++) {
				if (check[i] == 0) {
					bfs(i);
				}
			}
			
			boolean isTrue = false;
			for (int i = 1; i < a.length; i++) {
				for (int j = 0; j < a[i].size(); j++) {
					if (check[i] == check[a[i].get(j)]) {
						sb.append("NO").append("\n");
						isTrue = true;
						break;
					}
				}
				if (isTrue == true) {
					break;
				}
			}
			if (isTrue == false) {
				sb.append("YES").append("\n");
			}
		}
		System.out.println(sb);
	}
	
	public static void bfs(int x) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(x);
		check[x] = 1;
		
		while (!q.isEmpty()) {
			x = q.remove();
			for (int i = 0; i < a[x].size(); i++) {
				int y = a[x].get(i);
				if (check[y] == 0) {
					if (check[x] == 1) {
						q.add(y);
						check[y] = 2;
					} else {
						q.add(y);
						check[y] = 1;
					}
				}
			}
		}
	}
}
