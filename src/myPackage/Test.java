package myPackage;

import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Test {
	public static void main(String[] args) {
		String[] abs = {".com", "ass"};
		StringTokenizer st = new StringTokenizer(abs[0], ".");
		System.out.println(st.nextToken());
		System.out.println(st.nextToken());
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.remove();
	}
	
	public static class Node implements Comparable<Node> {
		int a, b;
		
		public Node (int a, int b) {
			this.a = a;
			this.b = b;
		}
		
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return 0;
		}
	}
	
	public static void combination(int[] arr, int index, int n, int r, int target) {
		if (r == 0) {
			for(int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			
		} else if (target == n) {
			return;
		} else {
			arr[index] = target;
			combination(arr, index + 1, n, r - 1, target + 1);
			combination(arr, index, n, r, target + 1);
		}
	}
}
