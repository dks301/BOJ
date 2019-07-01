package divideNconquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * 트리의 순회
 * n개의 정점을 갖는 이진 트리의 정점에 1부터 n까지 번호가 중복없이 매겨져있다.
 * 인오더와 포스트오더가 주어졌을대 프리오더를 구하기
 * 
 * 입력
 * 첫째줄: n(1<=n<=100,000)
 * 다음줄: 인오더를 나타내는 n개의 자연수
 * 그 다음줄: 포스트를 나타내는 n개의 자연수
 * 
 * 출력
 * 프리오더를 한 줄에 출력
 */
public class BOJ2263 {
	private static int n;
	private static int[] inorder;
	private static int[] postorder;
	private static int[] position;
	
	private static final String SPACE = " ";
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		inorder = new int[n + 1];
		postorder = new int[n + 1];
		position = new int[n + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			inorder[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			postorder[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= n; i++) {
			position[inorder[i]] = i;
		}
		
		Solve(1, n, 1, n);
		System.out.println(sb);
	}
	
	public static void Solve(int is, int ie, int ps, int pe) {
		if (is > ie || ps > pe) {
			return;
		}
		
		int root = postorder[pe];
		sb.append(root).append(SPACE);
		int p = position[root];
		
		int left = p - is;
		
		Solve(is, p - 1, ps, ps + left - 1);
		Solve(p + 1, ie, ps + left, pe - 1);
	}
}
