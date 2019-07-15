package bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 숨바꼭질
 * 수빈이는 점 N, 동생은 점 K에 있다. 수빈이는 걷거나 순간이동을 할 수 있다
 * 수빈이의 현재 위치가 X일때 걷는다면 1초 후에 X-1, X+1
 * 순간이동을 한경우에는 1초 후에 2 * X로 이동
 * 
 * 입력
 * 첫째줄: N과 K(0이상, 100_000이하인 정수)
 * 
 * 출력
 * 수빈이가 동생을 찾는 가장 빠른 시간(초)
 */
public class BOJ1697 {
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
					
				}
			}
		}
		return check[K];
	}
}
