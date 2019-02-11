package floodFill;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
/*
 * 단지번호붙이기
 * 정가각성 지도의 크기(5<=N<=25)
 * 위아래or좌우로 연결이 되어있으면 같은 단지
 * 단지수를 출력하고, 각단지의 집의 수를 오름차순 정렬하여 출력
 */
public class BOJ2667 {
	private static final String NEW_LINE = "\n";
	private static boolean[][] map;
	private static boolean[][] check;
	private static int cnt;
	
	private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
	private static final int ROW = 0;
	private static final int COL = 1;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new boolean[N + 2][N + 2];
		check = new boolean[N + 2][N + 2];
		for (int i = 1; i <= N; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j = 1; j <= N; j++) {
				map[i][j] = (temp[j - 1] == '0') ? false : true;
			}
		}
		
		ArrayList<Integer> group = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				cnt = 0;
				if (check[i][j] == false && map[i][j] == true) {
					dfs(i, j);
					if (cnt != 0) {
						group.add(cnt);
					}
				}
			}
		}
		Collections.sort(group);

		StringBuilder sb = new StringBuilder();
		sb.append(group.size()).append(NEW_LINE);
		for (int next : group) {
			sb.append(next).append(NEW_LINE);
		}
		System.out.print(sb);
	}
	
	public static void dfs(int x, int y) {
		check[x][y] = true;
		cnt++;
		
		for(final int[] DIRECTION : DIRECTIONS){
			int nextRow = x + DIRECTION[ROW];
			int nextCol = y + DIRECTION[COL];
			
			if(check[nextRow][nextCol] == false && map[nextRow][nextCol] == true) {
				dfs(nextRow, nextCol);
			}
		}
	}
}
