package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Stack;
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

			DragonCurve dc = new DragonCurve(x, y, d);
			for (int i = 0; i < g; i++) {
				dc.nextGeneration();
			}
			dc.setMap();
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
	
	public static class Node {
		int x, y, d;
		
		public Node(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
	public static class DragonCurve {
		Stack<Node> cur = new Stack<>();
		Stack<Node> next = new Stack<>();
		int endRow, endCol, endD;
		
		public DragonCurve(int col, int row, int d) {
			map[row][col] = true;
			endRow = row;
			endCol = col;
			endD = d;
			cur.push(new Node(row, col, d));
			next.push(new Node(row, col, d));
		}
		
		public void nextGeneration() {
			while(!cur.isEmpty()) {
				Node n = cur.pop();
				int nextRow = endRow + DIRECTIONS[endD][ROW];
				int nextCol = endCol + DIRECTIONS[endD][COL];
				next.push(new Node(nextRow, nextCol, (n.d + 1) % 4));
				
				endRow = nextRow;
				endCol = nextCol;
				endD = (n.d + 1) % 4;
			}
			
			cur = (Stack<Node>)next.clone();
		}

		public void setMap() {
			Iterator<Node> it = cur.iterator();
			while (it.hasNext()) {
				Node n = it.next();
				int nextRow = n.x + DIRECTIONS[n.d][ROW];
				int nextCol = n.y + DIRECTIONS[n.d][COL];
				if (nextRow < 0 || nextRow > 100 || nextCol < 0 || nextCol > 100) {
					continue;
				}
				
				map[nextRow][nextCol] = true;
			}
			
		}
	}
}
