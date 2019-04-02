package bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 촌수계산
 * 여러 사람들에 대한 부모 자식들 간의 관계가 주어졌을 때,
 * 주어진 두 사람의 촌수를 계산하여 출력, 단 계산불가능할때는 -1출력
 */
public class BOJ2644 {
	private static ArrayList<Integer>[] al;
	private static int[] check;
	
	private static int n;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(br.readLine());
		
		al = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			al[i] = new ArrayList<>();
		}
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			al[u].add(v);
			al[v].add(u);
		}
		
		check = new int[n + 1];
//		System.out.println(bfs(a, b));
		dfs(a);
		System.out.println(check[b] != 0 ? check[b] : -1);
	}
	
	public static void dfs(int a) {
		for (int next : al[a]) {
			if (check[next] == 0) {
				check[next] = check[a] + 1;
				dfs(next);
			}
		}
	}
	
	public static int bfs(int a, int b) {
		Queue<Integer> q = new LinkedList<>();
		q.add(a);
		check[a] = 1;
		
		while (!q.isEmpty()) {
			a = q.remove();
			
			for (int next : al[a]) {
				if (check[next] == 0) {
					q.add(next);
					check[next] = check[a] + 1;
					if (next == b) {
						return check[next] - 1;
					}
				}
			}
		}
		
		return -1;
	}
}
