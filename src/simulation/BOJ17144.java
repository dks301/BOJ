package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 미세먼지 안녕!
 * 공기청정기는 항상 왼쪽 열에 설치, 크기는 두 행을 차지
 * 1초동안 아래에 적힌 일이 순서대로 일어난다.
 * 1. 미세먼지가 확산된다. 확산은 미세먼지가 있는 모든 칸에서 동시에 일어난다.
 *     (r,c)에 있는 미세먼지는 인접한 네 방향으로 확산.
 *     인접한 방향에 공기청정기가 있거나, 칸이 없으면 확산x
 *     확산되는 양은 Ar,c/5이고 소수점은 버린다.
 *     (r,c)에 남은 미세먼지의 양은 Ar,c - (Ar,c/5) * (확산된 방향의 개수)
 * 2. 공기청정기가 작동한다.
 *     공기청정기에서는 바람이 나온다.
 *     위쪽 공기청정기의 바람은 반시계방향으로, 아래쪽 바람은 시계방향으로 순환
 *     바람이 불면 미세먼지가 바람의 방향대로 모두 한 칸씩 이동
 *     공기청정기에서 부는 바람은 미세먼지가 없는 바람이고, 공기청정기로 들어간 미세먼지는 모두 정화
 * T초가 지난 후 방에 남아있는 미세먼지의 양을 출력.
 * 
 * 첫쨰줄: R,C,T(6<=R,C<=50, 1<=T<=1,000)
 * 둘째줄~R개줄): Ar,c(-1<=Ar,c<=1,000) 공기청정기가 설치된 곳은 -1
 * 공기청정기는 위아래로 2칸, 마진 두 칸 이상
 */
public class BOJ17144 {
	private static int R, C, T;
	private static int airTop, airBottom;
	private static int[][] prev_map;
	private static int[][] next_map;
	
	private static final int DIRECTIONS[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	private static final int ROW = 0;
	private static final int COL = 1;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		prev_map = new int[R][C];
		next_map = new int[R][C];
		
		airTop = 0;
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				prev_map[i][j] = Integer.parseInt(st.nextToken());
				next_map[i][j] = prev_map[i][j];
				if (prev_map[i][j] == -1) {
					if (airTop == 0) {
						airTop = i;
					} else {
						airBottom = i;
					}
				}
			}
		}
		
		while(T-- > 0) {
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (prev_map[i][j] != 0 || prev_map[i][j] != -1) {
						spread(new Node(i, j));
					}
				}
			}
			
			blow();
			
			prev_map = deepCopy();
		}
		
		int ans = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				ans += prev_map[i][j];
			}
		}
		System.out.println(ans + 2);
	}
	
	public static void blow() {
		//top wind
		for (int i = airTop - 1; i >= 1; i--) {
			next_map[i][0] = next_map[i - 1][0];
		}
		for (int j = 0; j <= C - 2; j++) {
			next_map[0][j] = next_map[0][j + 1];
		}
		for (int i = 0; i <= airTop - 1; i++) {
			next_map[i][C - 1] = next_map[i + 1][C - 1];
		}
		for (int j = C - 1; j >= 2; j--) {
			next_map[airTop][j] = next_map[airTop][j - 1];
		}
		next_map[airTop][1] = 0;
		
		//bottom wind
		for (int i = airBottom + 1; i <= R - 2; i++) {
			next_map[i][0] = next_map[i + 1][0];
		}
		for (int j = 0; j <= C - 2; j++) {
			next_map[R - 1][j] = next_map[R - 1][j + 1];
		}
		for (int i = R - 1; i >= airBottom + 1; i--) {
			next_map[i][C - 1] = next_map[i - 1][C - 1];
		}
		for (int j = C - 1; j >= 2; j--) {
			next_map[airBottom][j] = next_map[airBottom][j - 1];
		}
		next_map[airBottom][1] = 0;
	}
	
	public static int[][] deepCopy() {
		int[][] result = new int[R][C];
		for (int i = 0; i < R; i++) {
			System.arraycopy(next_map[i], 0, result[i], 0, C);
		}
		return result;
	}
	
	public static void spread(Node x) {
		int amount = prev_map[x.x][x.y] / 5;
		
		for (final int[] DIRECTION : DIRECTIONS) {
			int nextRow = x.x + DIRECTION[ROW];
			int nextCol = x.y + DIRECTION[COL];
			if (nextRow < 0 || nextRow > R - 1 || nextCol < 0 || nextCol > C - 1) {
				continue;
			}
			if (prev_map[nextRow][nextCol] == -1) {
				continue;
			}
			
			next_map[x.x][x.y] -= amount;
			next_map[nextRow][nextCol] += amount;
		}
	}
	
	public static class Node {
		int x, y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
