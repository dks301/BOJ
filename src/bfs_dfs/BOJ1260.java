package bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * DFS와 BFS
 * 정점의 개수 N(1<=N<=1,000), 간선의 개수 M(1<=M<=10,000)
 * 이 그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력
 */
public class BOJ1260 {
	private static final String SPACE = " ";
	private static StringBuilder sb = new StringBuilder();
	private static boolean[] check;
	//private static boolean[][] a; // 인접 행렬
	private static ArrayList<Integer>[] b; // 인접 리스트
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		check = new boolean[N + 1];
		//a = new boolean[N + 1][N + 1];
		b = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			b[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			//a[v1][v2] = a[v2][v1] = true;
			b[v1].add(v2);
			b[v2].add(v1);
		}
		for (int i = 1; i <= N; i++) {
			Collections.sort(b[i]);
		}
		dfs(V);
		sb.append("\n");
		Arrays.fill(check, false);
		bfs(V);
		System.out.println(sb);
	}
	public static void dfs(int x) { // 인접 리스트 dfs
		check[x] = true;
		sb.append(x).append(SPACE);
		for (int i = 0; i < b[x].size(); i++) {
			int y = b[x].get(i);
			if (check[y] == false) {
				dfs(y);
			}
		}
	}
	
	public static void bfs(int x) { // 인접 리스트 bfs
		Queue<Integer> q = new LinkedList<>();
		check[x] = true;
		q.add(x);
		while (!q.isEmpty()) {
			x = q.poll();
			sb.append(x).append(SPACE);
			for (int i = 0; i < b[x].size(); i++) {
				int y = b[x].get(i);
				if (check[y] == false) {
					check[y] = true;
					q.add(y);
				}
			}
		}
	}
//	public static void dfs(int x) { // 인접 행렬 dfs
//		check[x] = true;
//		sb.append(x).append(SPACE);
//		for (int i = 1; i < a.length; i++) {
//			if (a[x][i] == true && check[i] == false) {
//				dfs(i);
//			}
//		}
//	}
//	
//	public static void bfs(int x) { // 인접 행렬 bfs
//		Queue<Integer> q = new LinkedList<>();
//		check[x] = true;
//		q.add(x);
//		while (!q.isEmpty()) {
//			x = q.poll();
//			sb.append(x).append(SPACE);
//			for (int i = 1; i < a.length; i++) {
//				if (a[x][i] == true && check[i] == false) {
//					check[i] = true;
//					q.add(i);
//				}
//			}
//		}
//	}
}
