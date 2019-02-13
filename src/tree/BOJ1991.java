package tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * 트리 순회
 * 노드의 개수(1<=N<=26)
 * 이진 트리를 입력받아서 프리,인,포스트 오더 결과 출력
 */
public class BOJ1991 {
	private static Node[] node;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		node = new Node[N + 1];
		
		while (N-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char name = st.nextToken().charAt(0);
			node[name - 'A'] = new Node(name, st.nextToken().charAt(0), st.nextToken().charAt(0));
		}
		ArrayList<Character> al = preorder(0);
		StringBuilder sb = new StringBuilder();
		for (char next : al) {
			sb.append(next);
		}
		sb.append("\n");
		
		al = inorder(0);
		for (char next : al) {
			sb.append(next);
		}
		sb.append("\n");
		
		al = postorder(0);
		for (char next : al) {
			sb.append(next);
		}
		System.out.println(sb);
	}
	
	public static ArrayList<Character> preorder(int i) { // 노드 -> 왼쪽 -> 오른쪽
		ArrayList<Character> al = new ArrayList<>();
		int left = node[i].left - 'A';
		int right = node[i].right - 'A';
		
		if (node[i].name != '.') {
			al.add(node[i].name);
			if (node[i].left != '.') {
				al.addAll(preorder(left));
			}
			if (node[i].right != '.') {
				al.addAll(preorder(right));
			}
		}
		return al;
	}
	
	public static ArrayList<Character> inorder(int i) { // 왼쪽 -> 노드 -> 오른쪽
		ArrayList<Character> al = new ArrayList<>();
		int left = node[i].left - 'A';
		int right = node[i].right - 'A';
		
		if (node[i].left != '.') {
			al.addAll(inorder(left));
		}
		if (node[i].name != '.') {
			al.add(node[i].name);
			if (node[i].right != '.') {
				al.addAll(inorder(right));
			}
		}
		return al;
	}
	
	public static ArrayList<Character> postorder(int i) { // 왼쪽 -> 오른쪽 -> 노드
		ArrayList<Character> al = new ArrayList<>();
		int left = node[i].left - 'A';
		int right = node[i].right - 'A';
		
		if (node[i].left != '.') {
			al.addAll(postorder(left));
		}
		if (node[i].right != '.') {
			al.addAll(postorder(right));
		}
		if (node[i].name != '.') {
			al.add(node[i].name);
		}
		return al;
	}
	
	public static class Node {
		char name = '.';
		char left = '.';
		char right = '.';
		
		public Node(char name, char left, char right) {
			this.name = name;
			this.left = left;
			this.right = right;
		}
	}
}
