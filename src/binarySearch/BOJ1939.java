package binarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 중량제한
 * 섬 N개(2<=N<=10,000) 중 몇개의 섬사이에는 다리가 있다
 * 다리의 중량제한을 초과하면 다리가 무너진다.
 * 두 공장중 한 공장에서 나머지 공장으로 물품을 수송해야한다.
 * 두 섬 사이에 여러개의 다리가 있을 수도 있다.
 * 모든 다리는 양방향이다.
 * 
 * 입력
 * 첫째줄: N, M(1<=M<=100,000)
 * 다음 M개줄: 다리 정보 A, B, C(1<=A,B<=N , 1<=C<=1,000,000,000)
 *          A번 섬과 B번 섬 사이에 중량제한이 C인 다리가 존재한다는 뜻
 * 마지막줄: 공장이 있는 두 섬의 번호
 * 
 * 출력
 * 한 번의 이동에서 옮길 수 있는 물품 중량의 최댓값
 */
public class BOJ1939 {
	private static int start, end;
	private static ArrayList<Bridge>[] al;
	private static boolean[] check;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		al = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			al[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			al[A].add(new Bridge(B, C));
			al[B].add(new Bridge(A, C));
		}
		
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		int left = 1, right = 1_000_000_000;
		while (left <= right) {
			int mid = (left + right) / 2;
			boolean check = bfs(mid);
			
			if (check) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}

		}
		System.out.println(left - 1);
	}

	public static boolean bfs(int weight) {
		Queue<Bridge> q = new LinkedList<>();
		check = new boolean[100001];
		
		for (Bridge next : al[start]) {
			if (next.C >= weight) {
				q.add(next);
				check[next.B] = true;
				if (next.B == end) {
					return true;
				}
			}
		}
		check[start] = true;

		while (!q.isEmpty()) {
			Bridge b = q.remove();
			
			for (Bridge next : al[b.B]) {
				if (next.C >= weight && !check[next.B]) {
					q.add(next);
					check[next.B] = true;
					if (next.B == end) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public static class Bridge {
		int B, C;

		public Bridge(int B, int C) {
			this.B = B;
			this.C = C;
		}
	}
}
