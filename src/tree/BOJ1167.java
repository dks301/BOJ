package tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 트리의 지름
 * 정점(2<=V<=100,000), 간선V개, 가중치(<=10,000)
 * 트리의 지름을 출력
 */
public class BOJ1167 {
	private static ArrayList<Pair>[] a;
	private static int[] check;
	private static int diameter = 0;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		a = new ArrayList[N + 1];
		check = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			a[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v;
			while ((v = Integer.parseInt(st.nextToken())) != -1) {
				int weight = Integer.parseInt(st.nextToken());
				a[u].add(new Pair(v, weight));
				a[v].add(new Pair(u, weight));
			}
		}
		int maxIdx = bfs(1);
		check = new int[N + 1];
		bfs(maxIdx);
		System.out.println(diameter);
	}
	
	public static int bfs(int x) {
		Queue<Integer> q = new LinkedList<>();
		Pair max = new Pair(-1, 0);
		q.add(x);
		check[x] = 1;
		
		while (!q.isEmpty()) {
			x = q.remove();
			for (Pair y: a[x]) {
				if (check[y.v] == 0) {
					q.add(y.v);
					check[y.v] = check[x] + y.weight;
					max = getPair(max, new Pair(y.v, check[y.v]));
				}
			}
		}
		diameter = max.weight - 1;
		return max.v;
	}
	
	public static Pair getPair(Pair result, Pair comp){
		if (result.weight < comp.weight) {
			result = new Pair(comp.v, comp.weight);
		}
		
		return result;
	}
	
	public static class Pair {
		int v;
		int weight;
		
		public Pair(int v, int weight) {
			this.v = v;
			this.weight = weight;
		}
	}
}
