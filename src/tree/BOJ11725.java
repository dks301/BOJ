package tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 트리의 부모 찾기
 * 노드의 개수 (2<=N<=100,000)
 * 트리의 루트를 1이라고 정했을 때, 각 노드의 부모 노드를 출력
 */
public class BOJ11725 {
	private static final String NEW_LINE = "\n";
	private static ArrayList<Integer>[] a;
	private static int[] check;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		check = new int[N + 1];
		a = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			a[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			a[u].add(v);
			a[v].add(u);
		}
		bfs();

		StringBuilder sb = new StringBuilder();
		for (int i = 2; i <= N; i++) {
			sb.append(check[i]).append(NEW_LINE);
		}
		System.out.println(sb);
	}

	public static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		check[1] = 1;

		while (!q.isEmpty()) {
			int x = q.remove();
			
			for (int i = 0; i < a[x].size(); i++) {
				int y = a[x].get(i);
				if (check[y] == 0) {
					q.add(y);
					check[y] = x;
				}
			}
		}
	}
}
