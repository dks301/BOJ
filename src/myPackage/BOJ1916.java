package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 최소비용 구하기
 * 도시의 개수 N(1<=N<=1,000), 버스의 개수M(1<=M<=100,000)
 * 0 <= 버스의 비용 < 100,000
 * 출발 도시에서 도착 도시까지 가는데 드는 최소 비용 출력
 */
public class BOJ1916 {
	private static final int INF = 100_000;
	private static ArrayList<Bus>[] a;
	private static int[] check;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		a = new ArrayList[M + 1];
		for (int i = 1; i <= M; i++) {
			a[i] = new ArrayList<>();
		}
		
		check = new int[N + 1];
		Arrays.fill(check, INF);
		
		StringTokenizer st;
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			a[u].add(new Bus(u, v, w));
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> al = bfs(a[start].get(0));
		int ans = 0;
		for (int next : al) {
			ans += check[next];
			System.out.println(check[next]);
		}
		System.out.println();
		for (int i = 1; i <= N; i++) {
			System.out.println("check[" + i + "]: " + check[i]);
		}
		System.out.println(ans);
	}
	
	public static ArrayList<Integer> bfs(Bus b) {
		Queue<Bus> q = new LinkedList<>();
		q.add(b);
		ArrayList<Integer> al = new ArrayList<>();
		
		while (!q.isEmpty()) {
			b = q.remove();
			al.add(b.y);
			Bus temp = b;
			int min = INF;
			
			for (Bus next : a[b.x]) {
				if (next.w < check[next.y]) {
					check[next.y] = next.w;
				}
				
				if (next.w < min) {
					min = next.w;
					temp = next;
				}
			}
			
			if (!temp.equals(b)) {
				q.add(temp);
			}
		}
		return al;
	}
	
	public static class Bus {
		int x, y, w;
		
		public Bus(int x, int y, int w) {
			this.x = x;
			this.y = y;
			this.w = w;
		}
	}
}
