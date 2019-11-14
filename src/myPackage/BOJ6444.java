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

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken()); // col
			int N = Integer.parseInt(st.nextToken()); // row

			Queue<Integer> q = new LinkedList<>();
			int[][] ss = new int[N][M];
			HashMap<Integer, ArrayList<Integer>> adjMap = new HashMap<>();
			HashMap<Integer, Short> indegree = new HashMap<>();

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					String temp = st.nextToken();
					if (isNumeric(temp)) {
						ss[i][j] = Integer.parseInt(temp);
						q.add(i * RR + j);
						
					} else {
						StringTokenizer st2 = new StringTokenizer(temp, "+");
						int cnt = st2.countTokens();
						int n = i * RR + j;
						
						indegree.put(n, (short) cnt);
						for (int k = 0; k < cnt; k++) {
							int[] rc = findRowCol(st2.nextToken());
							int from = rc[0] * RR + rc[1];
							if (!adjMap.containsKey(from)) {
								ArrayList<Integer> al = new ArrayList<>();
								al.add(n);
								adjMap.put(from, al);
							} else {
								adjMap.get(from).add(n);
							}
						}
					}
				}
			}

			while (!q.isEmpty()) {
				int n = q.remove();
				int row = n / RR;
				int col = n % RR;

				if (adjMap.containsKey(n)) {
					ArrayList<Integer> al = adjMap.get(n);
					for (int next : al) {
						int nextRow = next / RR;
						int nextCol = next % RR;
						short idg = (short) (indegree.get(next) - 1);
						
						ss[nextRow][nextCol] += ss[row][col];
						if (idg == 0) {
							indegree.remove(next);
							q.add(next);
						} else {
							indegree.put(next, idg);
						}
					}
					
					al.clear();
					adjMap.remove(n);
				}
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
