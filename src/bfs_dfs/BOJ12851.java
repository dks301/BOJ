package bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 숨바꼭질 2
 * 솜바꼭질1 + 최단시간에 도달하는 방법의 수 출력
 */
public class BOJ12851 {
	private static int N, K, cnt;
	private static int[] check;
	
	private static final int INF = 100_001;
	private static final int[] MOVING = {1, -1, 2};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		System.out.println(bfs() - 1);
		System.out.println(cnt == 0 ? 1 : cnt);
	}
	
	public static int bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		check = new int[INF];
		check[N] = 1;
		cnt = 0;
		
		while (!q.isEmpty()) {
			int x = q.remove();
			
			for (int i = 0; i < 3; i++) {
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
					check[next] = check[x] + 1;
					if (next == K) {
						cnt++;
					}
				} else if (check[next] != 0 && check[next] == check[x] + 1) {
					q.add(next);
					if (next == K) {
						cnt++;
					}
				}
			}
		}
		return check[K];
	}
}
