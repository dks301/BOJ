package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA2383 {
	private static int N, mCnt;
	private static boolean[] isDown;
	private static int[][] map;
	private static Stairs s1, s2;
	
	private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	private static final int ROW = 0;
	private static final int COL = 1;
	
	private static final char NUMBER = '#';
	private static final char SPACE = ' ';
	private static final char NEW_LINE = '\n';
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			sb.append(NUMBER).append(t).append(SPACE);
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			s1 = s2 = null;
				
			ArrayList<Man> al = new ArrayList<>();
			int sCnt = 0;
			mCnt = 0;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1) {
						al.add(new Man(i, j, mCnt++));
						
					} else if (map[i][j] != 0) {
						if (sCnt++ == 0) {
							s1 = new Stairs(i, j, map[i][j]);
						} else {
							s2 = new Stairs(i, j, map[i][j]);
						}
					}
				}
			}
			
			isDown = new boolean[al.size()];
			bfs(al);
			int ans = 0;
			while (!allDown()) {
				int c = 0;
				ArrayList<Integer> v1, v2;
				v1 = new ArrayList<>();
				v2 = new ArrayList<>();
				while (v1.size() == 0 && v2.size() == 0) {
					v1 = s1.countDown();
					v2 = s2.countDown();
					c++;
				}
				
				ans += c;
				
				if (v1.size() != 0) {
					for (int i = 0; i < mCnt; i++) {
						s2.cnt[i] += ans;
					}
					
					int temp = ans;
					while (temp-- > 0) {
						
					}
					
				} else if (v2.size() != 0) {
					
				}
				s1.countDown();
				s2.countDown();
				ans++;
				//System.out.println(ans);
			}
			sb.append(ans).append(NEW_LINE);
		}
		
		System.out.print(sb);
	}
	
	public static void bfs(ArrayList<Man> al) {
		Queue<Man> q = new LinkedList<>();
		int[][][] d = new int[al.size()][N][N];
		for (int i = 0; i < al.size(); i++) {
			d[i][al.get(i).row][al.get(i).col] = 1;
			q.add(al.get(i));
		}

		while (!q.isEmpty()) {
			Man m = q.remove();
			
			for (final int[] DIRECTION : DIRECTIONS) {
				int nextRow = m.row + DIRECTION[ROW];
				int nextCol = m.col + DIRECTION[COL];
				if (nextRow < 0 || nextRow > N - 1 || nextCol < 0 || nextCol > N - 1) {
					continue;
				}
				
				if (d[m.idx][nextRow][nextCol] == 0) {
					q.add(new Man(nextRow, nextCol, m.idx));
					d[m.idx][nextRow][nextCol] = d[m.idx][m.row][m.col] + 1;
					
					if (nextRow == s1.row && nextCol == s1.col) {
						s1.add(m.idx, d[m.idx][nextRow][nextCol]);
						
					} else if (nextRow == s2.row && nextCol == s2.col) {
						s2.add(m.idx, d[m.idx][nextRow][nextCol]);
					}
				}
			}
		}
		
		
	}
	
	public static boolean allDown() {
		for (int i = 0; i < mCnt; i++) {
			if (!isDown[i]) {
				return false;
			}
		}
		return true;
	}
	
	public static class Stairs {
		int row, col, size;
		Queue<Integer> q = new LinkedList<>(); // 먼저 온 순서대로 q에 저장
		int[] cnt = new int[10];
		
		public Stairs(int row, int col, int size) {
			this.row = row;
			this.col = col;
			this.size = size;
			
			for (int i = 0; i < 10; i++) {
				cnt[i] = size;
			}
		}
		
		public void add(int i, int d) {
			cnt[i] += d;
			q.add(i);
		}
		
		public ArrayList<Integer> countDown() {
			ArrayList<Integer> al = new ArrayList<>();
			Iterator<Integer> it = q.iterator();
			int count = 0;
			while (it.hasNext()) {
				int next = it.next();
				if (isDown[next]) {
					continue;
				}
				count++;
				if (count > 3) {
					break;
				}
				
				cnt[next]--;
				if (cnt[next] == 0) {
					al.add(next);
				}
			}
			return al;
		}
	}
	
	public static class Man {
		int row, col, idx;
		
		public Man(int row, int col, int idx) {
			this.row = row;
			this.col = col;
			this.idx = idx;
		}
	}
}
