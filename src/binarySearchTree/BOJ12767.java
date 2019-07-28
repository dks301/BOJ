package binarySearchTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/*
 * Ceiling Function
 */
public class BOJ12767 {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		HashSet<String> hs = new HashSet<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int[] arr = new int[k];
			for (int j = 0; j < k; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			Node root = new Node(arr[0]);
			for (int j = 1; j < k; j++) {
				Node cur = root;
				while (true) {
					if (cur.val > arr[j]) {
						if (cur.left == null) {
							cur.left = new Node(arr[j]);
							break;
						} else {
							cur = cur.left;
						}
						
					} else if (cur.val < arr[j]) {
						if (cur.right == null) {
							cur.right = new Node(arr[j]);
							break;
						} else {
							cur = cur.right;
						}
						
					} else {
						break;
					}
				}
			}
			String temp = preorder(root);
			hs.add(temp);
		}
		
		System.out.println(hs.size());
	}
	
	public static String preorder(Node n) {
		String ans = "";
		ans += "V";
		if (n.left != null) {
			ans += "L";
			ans += preorder(n.left);
			ans += "l";
		}
		if (n.right != null) {
			ans += "R";
			ans += preorder(n.right);
			ans += "r";
		}
		ans += "v";
		return ans;
	}
	
	public static class Node {
		int val;
		Node left, right;
		
		public Node(int val) {
			this.val = val;
			left = right = null;
		}
	}
}
