package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 드래곤 커브                             ㅣ
 * 좌표 평면의 x축은 ->, y축은  v 방향
 * 드래곤 커브의 세가지 속성: 1. 시작 점, 2. 시작 방향, 3. 세대
 * 0세대 드래곤 커브: 길이가 1인 선분 (0,0)시작ㅡ(1,0)끝, 시작 방향은 오른쪽
 * 1세대 드래곤 커브: 0세대 드래곤 커브를  끝점을 축으로 시계방향 90도 회전후 0세대 끝 점에 붙인 것
 * 끝 점이란? 시작점에서 선분을 타고 이동했을 때, 가장 먼 거리에 있는 점 
 * 즉, K(K>1)세대 드래곤 커브는 K-1세대 드래곤 커브를 끝 점을 기준으로 90도 시계방향 회전시킨 다음, 그것을 끝점에 붙인 것.
 * 크기가 100x100인 격자 위에 드래곤 커브가 N개 있다.
 * 이 때, 크기가 1x1인 정사각형의 네 꼭짓점이 모두 드래곤 커브의 일부인 정사각형의 갯수 출력.
 * 격자의 좌표(x,y): 0<=x<=100, 0<=y<=100만 유효한 좌표이다.
 * 
 * 첫째줄: 드래곤 커브의 개수 N(1<=N<=20)
 * 둘째줄~N개줄: 드래곤 커브의 정보: 네 정수 x, y, d, g
 * 시작점(x,y), d는 시작 방향, g는 세대(0<=x,y<=100, 0<=d<=3, 0<=g<=10)
 * 입력으로 주어지는 드래곤 커브는 격자 밖으로 벗어나지 않는다.
 * 드래곤 커브는 서로 겹칠 수 있다.
 * 방향은 0,1,2,3중 하나, 0:x좌표가 증가, 1:y좌표가 감소, 2:x좌표가 감소, 3:y좌표가 증가 
 */
public class BOJ15685 {
	private static boolean[][] map = new boolean[101][101];

	private static final int[][] DIRECTIONS = { { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 0 } };
	private static final int ROW = 0;
	private static final int COL = 1;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		while (N-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());

			DragonCurve dc = new DragonCurve(x, y, d, g);
			System.out.println();
			for (int i = 0; i <= 100; i++) {
				for (int j = 0; j <= 100; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println();
			System.out.println();
		}
		
		System.out.println(getAnswer());
	}

	public static int getAnswer() {
		int ans = 0;
		for (int i = 0; i <= 99; i++) {
			for (int j = 0; j <= 99; j++) {
				if (map[i][j] && map[i + 1][j] && map[i][j + 1] && map[i + 1][j + 1]) {
					ans++;
				}
			}
		}

		return ans;
	}

	public static class DragonCurve {
		boolean[][] pos;
		int startRow, startCol;
		int endRow, endCol;

		public DragonCurve(int col, int row, int d, int g) {
			pos = new boolean[101][101];
			pos[row][col] = true;
			startRow = row;
			startCol = col;
			endRow = row + DIRECTIONS[d][ROW];
			endCol = col + DIRECTIONS[d][COL];
			pos[endRow][endCol] = true;

			for (int i = 0; i < g; i++) {
				nextGeneration();
			}
			
			setMap();
		}

		public void nextGeneration() {
			int baseRow = endRow, baseCol = endCol;
			int newEndRow = -1, newEndCol = -1;

			for (int i = 0; i <= 100; i++) {
				for (int j = 0; j <= 100; j++) {
					if (pos[i][j]) {
						int nextRow = baseRow + baseCol - i;
						int nextCol = baseRow + baseCol - j;
						if (nextRow < 0 || nextRow > 100 || nextCol < 0 || nextCol > 100) {
							continue;
						}

						pos[nextRow][nextCol] = true;
						if (i == startRow && j == startCol) {
							newEndRow = nextRow;
							newEndCol = nextCol;
						}
					}
				}
			}
			endRow = newEndRow;
			endCol = newEndCol;
		}

		public void setMap() {
			for (int i = 0; i <= 100; i++) {
				for (int j = 0; j <= 100; j++) {
					if (pos[i][j]) {
						map[i][j] = true;
					}
				}
			}
		}
	}
}
