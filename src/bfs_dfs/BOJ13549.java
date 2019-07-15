package bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 숨바꼭질3
 * 숨바꼭질 기본 + 순간이동은 0초소요
 */
public class BOJ13549 {
	private static int N, K;
	private static int[] check;
	
	private static final int INF = 100_001;
	private static final int[] MOVING = {1, -1, 2};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		System.out.println(bfs() - 1);
	}
	
	public static int bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		check = new int[INF];
		check[N] = 1;
		
		while (!q.isEmpty()) {
			int x = q.remove();
			
			for (int i = 2; i >= 0; i--) {
				int next = x;
				if (i < 2) {
					next += MOVING[i];
				} else {
					next *= MOVING[i];
				}
				
				if (next < 0 || next >= INF) {
					continue;
				}
				
				if (check[next] == 0) {
					q.add(next);
					check[next] = (i == 2 ? check[x] : check[x] + 1);		
				}
			}
		}
		return check[K];
	}
}
