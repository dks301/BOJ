package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ6444 {
	private static final char SPACE = ' ';
	private static final char NEW_LINE = '\n';
	private static final int RR = 19000;
	private static int[][] ss;
	private static HashMap<Integer, Integer> indegree;
	private static ArrayList<Integer>[][] adjList;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken()); // col
			int N = Integer.parseInt(st.nextToken()); // row
			ss = new int[N][M];
			indegree = new HashMap<>();
			adjList = new ArrayList[N][M];
			
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					String temp = st.nextToken();
					if (isNumeric(temp)) {
						ss[i][j] = Integer.parseInt(temp);
						indegree.put(i * RR + j, 0);

					} else {
						StringTokenizer st2 = new StringTokenizer(temp, "+");
						int cnt = st2.countTokens();
						int n = i * RR + j;
						indegree.put(i * RR + j, cnt);

						for (int k = 0; k < cnt; k++) {
							int[] rc = findRowCol(st2.nextToken());
							if (adjList[rc[0]][rc[1]] == null) {
								adjList[rc[0]][rc[1]] = new ArrayList<>();
							}
							
							adjList[rc[0]][rc[1]].add(n);
						}
					}
				}
			}
			
			Queue<Integer> q = new LinkedList<>();
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (adjList[i][j] != null && indegree.get(i * RR + j) == 0) {
						q.add(i * RR + j);
						indegree.remove(i * RR + j);
					}
				}
			}
			
			while (!q.isEmpty()) {
				int n = q.remove();
				int fromRow = n / RR;
				int fromCol = n % RR;
				
				for (int to : adjList[fromRow][fromCol]) {
					int toRow = to / RR;
					int toCol = to % RR;
					ss[toRow][toCol] += ss[fromRow][fromCol];
					indegree.put(to, indegree.get(to) - 1);
					if (adjList[toRow][toCol] != null && indegree.get(to) == 0) {
						q.add(to);
						indegree.remove(to);
					}
				}
				
				adjList[fromRow][fromCol] = null;
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					sb.append(ss[i][j]).append(SPACE);
				}
				sb.append(NEW_LINE);
			}
			sb.append(NEW_LINE);
		}
		System.out.print(sb);
	}

	public static int[] findRowCol(String s) {
		char[] temp = s.toCharArray();
		int[] rc = new int[2]; // rc[0] = row , rc[1] = col;
		String ss = "";
		Stack<Integer> col = new Stack<>();
		for (int i = 0; i < temp.length; i++) {
			if (temp[i] == '=') {
				continue;
			} else if (temp[i] >= 'A' && temp[i] <= 'Z') {
				col.add(temp[i] - 'A');
			} else if (temp[i] >= '0' && temp[i] <= '9') {
				ss += temp[i];
			}
		}

		int i = 1;
		while (!col.isEmpty()) {
			int pop = col.pop();
			if (i != 1) {
				pop++;
			}

			rc[1] += (i * pop);

			i *= 26;
		}

		rc[0] = Integer.parseInt(ss) - 1;

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
}
