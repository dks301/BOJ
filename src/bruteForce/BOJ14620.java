package bruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 꽃길
 * 씨앗을 심고난 후 1년 뒤에 꽃이 핀다.
 * 꽃 밭은 N*N, (1,1)~(N,N)
 * 1년 후 꽃이 피면, 상하좌우중 범위를 가진다.
 * 꽃이 겹치면 겹친 꽃들이 죽게된다. 화단 밖으로 나가도 죽게된다.
 * 화단의 점마다 가격이 다르다.
 * 꽃하나 당 5칸을 구매해야 한다.
 * N(6<=N<=10), 한 칸 가격G(0<=G<=200)
 * 꽃이 다 피기 위한 화단 구입 최소 비용 출력
 */
public class BOJ14620 {
	private static int[][] map;
	private static boolean[][] check;
	private static int N;
	
	private static int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {2, 0}, {-2, 0}, {0, 2}, {0, -2}, {1, 1}, {-1, 1}, {1, -1}, {-1, -1}};
	private static final int ROW = 0;
	private static final int COL = 1;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int min = Integer.MAX_VALUE;
		for (int i = 1; i < N - 1; i++) {
			for (int j = 1; j < N - 1; j++) {
				for (int k = 1; k < N - 1; k++) {
					for (int l = 1; l < N - 1; l++) {
						for (int m = 1; m < N - 1; m++) {
							for (int n = 1; n < N - 1; n++) {
								check = new boolean[N][N];
								int val = seed(i, j);
								if (check[k][l] == false) {
									val += seed(k, l);
									
									if (check[m][n] == false) {
										val += seed(m, n);
										
										if (val < min) {
											min = val;
										}
									}
								}
							}
						}
					}
				}
			}
		}
		
		System.out.println(min);
	}
	
	public static int seed(int x, int y) {
		int cost = map[x][y];
		check[x][y] = true;
		
		int idx = 0;
		for(final int[] DIRECTION : DIRECTIONS) {
			int nextRow = x + DIRECTION[ROW];
			int nextCol = y + DIRECTION[COL];
			
			if (nextRow < 0 || nextRow > N - 1 || nextCol < 0 || nextCol > N - 1) {
				continue;
			}
			if (idx++ < 4) {
				cost += map[nextRow][nextCol];
			}
			check[nextRow][nextCol] = true;
		}
		
		return cost;
	}
}
