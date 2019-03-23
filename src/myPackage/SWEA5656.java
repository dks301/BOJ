package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 벽돌 깨기
 * 구슬로 맨위에 있는 벽돌만 깨뜨릴 수 있다.
 * 벽돌은 숫자 1~9로 표현, 구슬이 명중한 벽돌은 상하좌우 (숫자-1)칸 만큼 같이 제거
 * 연쇄작용 있음
 * 구슬 :1<=N<=4, col:2<=W<=12, row:2<=H<=15일때 남은 벽돌의 갯수 출력 
 */
public class SWEA5656 {
	private static final String NUMBER = "#";
	private static final String SPACE = " ";
	private static final String NEW_LINE = "\n";
	
	private static int[][] map;
	private static int W, H;
	private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; // 남 북 동 서
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			sb.append(NUMBER).append(t).append(SPACE);
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			map = new int[H][W];
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < W; i++) {
				for (int j = 0; j < W; j++) {
					for (int k = 0; k < W; k++) {
						for (int l = 0; l < W; l++) {
							int[][] tempMap = deepCopy(map, H, W);
							
						}
					}
				}
			}
			sb.append(NEW_LINE);
		}
		
		System.out.print(sb);
	}
	
	public static int[][] deepCopy(int[][] origin, int H, int W) {
		int[][] result = new int[H][W];
		for (int i = 0; i < origin.length; i++) {
			System.arraycopy(origin[i], 0, result[i], 0, origin[i].length);
		}
		return result;
	}
	
	public static void dfs(int[][] map, int n, int d, int x, int y) {
		if (n == 0) {
			return;
		}
		map[x][y]--;
		
		int nextRow = x + DIRECTIONS[d][0];
		int nextCol = y + DIRECTIONS[d][1];
		
		if (nextRow < 0 || nextRow > H || nextCol < 0 || nextCol > W) {
			return;
		}
		
		dfs(map, --n, d, nextRow, nextCol);
	}
}
