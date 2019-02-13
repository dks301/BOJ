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
		node = new Node[N];

		while (N-- > 0) {
			String temp = br.readLine();
			char name = temp.charAt(0);
			node[name - 'A'] = new Node(name, temp.charAt(2), temp.charAt(4));
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
		if (i == -19) { // '.' - 'A' = -19
			return al;
		}
		int left = node[i].left - 'A';
		int right = node[i].right - 'A';

		al.add(node[i].name);
		al.addAll(preorder(left));
		al.addAll(preorder(right));
		return al;
	}

	public static ArrayList<Character> inorder(int i) { // 왼쪽 -> 노드 -> 오른쪽
		ArrayList<Character> al = new ArrayList<>();
		if (i == -19) {
			return al;
		}
		int left = node[i].left - 'A';
		int right = node[i].right - 'A';

		al.addAll(inorder(left));
		al.add(node[i].name);
		al.addAll(inorder(right));
		return al;
	}

	public static ArrayList<Character> postorder(int i) { // 왼쪽 -> 오른쪽 -> 노드
		ArrayList<Character> al = new ArrayList<>();
		if (i == -19) {
			return al;
		}
		int left = node[i].left - 'A';
		int right = node[i].right - 'A';

		al.addAll(postorder(left));
		al.addAll(postorder(right));
		al.add(node[i].name);
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
