package bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 퍼즐
 * 3x3표에서 인접한 네 칸중 하나가 비어있으면 수를 그 칸으로 이동 가능
 * 초기 상태가 주어졌을때 최소 이동으로 정리된 상태로 만들기
 * 
 * 입력
 * 세 줄에 걸쳐서 표 정보 입력, 빈 칸은 0
 * 
 * 출력
 * 최소 이동 횟수 출력, 불가능한 경우 -1 출력
 */
public class BOJ1525 {
	private static HashMap<Integer, Integer> table;
	
	private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	private static final int ROW = 0;
	private static final int COL = 1;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		table = new HashMap<>();
		int initial = 0;
		for (int i = 0; i < 3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				int val = Integer.parseInt(st.nextToken());
				if (val == 0) {
					val = 9;
				}
				initial = (initial * 10) + val;
			}
		}
		int ans = 123456789;
		bfs(initial);
		if (table.containsKey(ans)) {
			System.out.println(table.get(ans));
		} else {
			System.out.println(-1);
		}
	}
	
	public static void bfs(int n) {
		Queue<Integer> q = new LinkedList<>();
		q.add(n);
		table.put(n, 0);
		
		while (!q.isEmpty()) {
			n = q.remove();
			char[] val = String.valueOf(n).toCharArray();
			for (int i = 0; i < 9; i++) {
				if (val[i] == '9') {
					for (final int[] DIRECTION : DIRECTIONS) {
						int nextRow = i / 3 + DIRECTION[ROW];
						int nextCol = i % 3 + DIRECTION[COL]; 
						if (nextRow < 0 || nextRow > 2 || nextCol < 0 || nextCol > 2) {
							continue;
						}
						int next = 3 * nextRow + nextCol;
						char[] tempArr = val.clone();
						char temp;
						temp = tempArr[i];
						tempArr[i] = tempArr[next];
						tempArr[next] = temp;
						
						next = Integer.parseInt(String.valueOf(tempArr));
						if (!table.containsKey(next)) {
							q.add(next);
							table.put(next, table.get(n) + 1);
						}
					}
				}
			}
		}
	}
}
