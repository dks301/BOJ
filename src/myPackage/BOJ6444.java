package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ6444 {
	private static LinkedList<Node>[][] adjList;
	private static final char SPACE = ' ';
	private static final char NEW_LINE = '\n';
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		SpreadSheet ss = new SpreadSheet();
		
		adjList = new LinkedList[999][18278];
		for (int i = 0; i < 999; i++) {
			for (int j = 0; j < 18278; j++) {
				adjList[i][j] = new LinkedList<>();	
			}
		}
		
		Queue<Node> p = new LinkedList<>();
		
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken()); // col
			int N = Integer.parseInt(st.nextToken()); // row
			
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					String temp = st.nextToken();
					if (isNumeric(temp)) {
						ss.sheets[i][j] = Integer.parseInt(temp);
						p.add(new Node(i, j, ss.sheets[i][j], 0));
					} else {
						StringTokenizer st2 = new StringTokenizer(temp, "+");
						int size = st2.countTokens();
						Node n = new Node(i, j, 0, size);
						while (st2.hasMoreTokens()) {
							int[] rc = findRowCol(st2.nextToken());
							adjList[rc[0]][rc[1]].add(n);
						}
					}
				}
			}
			
			while (!p.isEmpty()) {
				Node n = p.remove();
				
				for (int i = 0; i < adjList[n.row][n.col].size(); i++) {
					Node next = adjList[n.row][n.col].get(i);
					next.indegree -= 1;
					next.val += n.val;
					if (next.indegree == 0) {
						ss.sheets[next.row][next.col] = next.val;
						p.add(new Node(next.row, next.col, next.val, 0));
						adjList[n.row][n.col].remove(i);
					}
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					sb.append(ss.sheets[i][j]).append(SPACE);
					ss.sheets[i][j] = 0;
				}
				sb.append(NEW_LINE);
			}
		}
		System.out.print(sb);
	}
	
	public static int[] findRowCol(String s) {
		char[] temp = s.toCharArray();
		int[] rc = new int[2]; // rc[0] = row , rc[1] = col;
		Stack<Integer> row = new Stack<>();
		Stack<Integer> col = new Stack<>();
		for (int i = 0; i < temp.length; i++) {
			if (temp[i] == '=') {
				continue;
			} else if (temp[i] >= 'A' && temp[i] <= 'Z'){
				col.add(temp[i] - 'A' + 1);
			} else if (temp[i] >= '0' && temp[i] <= '9') {
				row.add(temp[i] - '0');
			}
		}
		
		int i = 1;
		while (!col.isEmpty()) {
			rc[1] += (i * col.pop() - 1);
			i *= 26;
		}
		
		i = 1;
		while (!row.isEmpty()) {
			rc[0] += (i * row.pop() - 1);
			i *= 10;
		}
		
		return rc;
	}
	
	public static boolean isNumeric(String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	public static class SpreadSheet {
		int[][] sheets;
		
		public SpreadSheet() {
			sheets = new int[999][18278];
		}
	}
	
	public static class Node {
		int row, col;
		int val, indegree;
		
		public Node(int row, int col, int val, int indegree) {
			this.row = row;
			this.col = col;
			this.val = val;
			this.indegree = indegree;
		}
	}
}
