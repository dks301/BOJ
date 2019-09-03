package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SWEA2382 {
	private static int N, M, K, ans;
	private static int[][] map;
	
	private static final int[][] DIRECTIONS = {
			{0, 0},
			{-1, 0}, // 상
			{1, 0}, // 하
			{0, -1}, // 좌
			{0, 1} // 우
	};
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
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			
			LinkedList<Group> ll = new LinkedList<>();
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				map[r][c] = 1;
				ll.add(new Group(r, c, s, d));
			}
			
			while (M-- > 0) {
				Iterator<Group> it = ll.iterator();
				while (it.hasNext()) {
					Group g = it.next();
					map[g.row][g.col]--;
					g.go();
					if (g.isDie) {
						it.remove();
					} else {
						map[g.row][g.col]++;
					}
				}
				
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (map[i][j] > 1) {
							for (int n = 0; n < map[i][j]; n++) {
								it = ll.iterator();
								int big = 0;
								int total = 0;
								while (it.hasNext()) {
									Group g = it.next();
									if (g.row == i && g.col == j) {
										total += g.size;
										if (big < g.size) {
											big = g.size;
										}
									}
								}
								
								it = ll.iterator();
								while (it.hasNext()) {
									Group g = it.next();
									if (g.row == i && g.col == j) {
										if (big != g.size) {
											it.remove();
										} else {
											g.size = total;
										}
									}
								}
							}
							map[i][j] = 1;
						}
					}
				}
			}
			
			ans = 0;
			for (Group next : ll) {
				ans += next.size;
			}
			sb.append(ans).append(NEW_LINE);
		}
		System.out.print(sb);
	}
	
	public static class Group {
		int row, col, size, d;
		boolean isDie = false;
		
		public Group(int row, int col, int size, int d) {
			this.row = row;
			this.col = col;
			this.size = size;
			this.d = d;
		}
		
		public void back() {
			this.size /= 2;
			switch (this.d) {
			case 1:
				this.d = 2;
				break;
				
			case 2:
				this.d = 1;
				break;
				
			case 3:
				this.d = 4;
				break;
				
			case 4:
				this.d = 3;
				break;
			}
		}
		
		public void go() {
			this.row += DIRECTIONS[d][ROW];
			this.col += DIRECTIONS[d][COL];
			if (this.row == 0 || this.col == 0 || this.row == N - 1 || this.col == N - 1) {
				this.back();
				if (this.size == 0) {
					isDie = true;
				}
			}
		}
	}
}
