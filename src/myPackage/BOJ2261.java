package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeSet;

/*
 * 2차원 평면상에 n개의 점이 주어진다
 * 
 * 입력
 * 첫째줄: 자연수n(2<=n<=100,000)
 * 다음 n개줄: 각 점의 x, y좌표(|x&y|<10000, 같은 점이 여러개 가능)
 * 
 * 출력
 * 가장 가까운 두 점의 거리의 제곱을 출력
 */
public class BOJ2261 {
	private static TreeSet<Node> p;
	private static int ans = 20000;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		p = new TreeSet<>();
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			p.add(new Node(x, y));
		}
		
		int x = p.first().x;
		Iterator<Node> it = p.iterator();
		while (it.hasNext()) {
			Node next = it.next();
			if (x != next.x) {
				int temp = next.x - x;
				x = next.x;
				if (temp * temp < ans) {
					ans = temp * temp;
				}
			}
		}
		
		Node n = p.first();
		boolean isFirst = true;
		for (Node next : p) {
			if (isFirst) {
				isFirst = false;
				continue;
			}
			int dis = getDistance(n, next);
			if (dis < ans) {
				ans = dis;
			}
		}
		
		
		System.out.println(ans);
	}
	
	public static int getDistance(Node a, Node b) {
		return ((a.y - b.y) * (a.y - b.y)) + ((a.x - b.x) * (a.x - b.x)); 
	}
	
	public static class Node implements Comparable<Node>{
		int x, y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public int compareTo(Node that) {
			if (this.x < that.x) {
				return -1;
			} else if (this.x == that.x) {
				if (this.y < that.y) {
					return -1;
				} else if (this.y == that.y) {
					return 0;
				} else {
					return 1;
				}
			} else {
				return 1;
			}
		}
	}
	
}
