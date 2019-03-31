package bruteForce;

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
			sb.append(bruteForce(N)).append(NEW_LINE);
		}
		
		System.out.print(sb);
	}
	
	public static int bruteForce(int n) {
		int min = Integer.MAX_VALUE;
		
		switch (n) {
		case 1:
			for (int i = 0; i < W; i++) {
				int[][] tempMap = deepCopy(map, H, W);
				explosion(tempMap, shoot(tempMap, i), i);
				int cnt = countBlock(tempMap);
				if (cnt < min) {
					min = cnt;
				}
			}
			break;
			
		case 2:
			for (int i = 0; i < W; i++) {
				for (int j = 0; j < W; j++) {
					int[][] tempMap = deepCopy(map, H, W);
					explosion(tempMap, shoot(tempMap, i), i);
					dropBlock(tempMap);
					
					explosion(tempMap, shoot(tempMap, j), j);
					dropBlock(tempMap);
					int cnt = countBlock(tempMap);
					if (cnt < min) {
						min = cnt;
					}
				}
			}
			break;
			
		case 3:
			for (int i = 0; i < W; i++) {
				for (int j = 0; j < W; j++) {
					for (int k = 0; k < W; k++) {
						int[][] tempMap = deepCopy(map, H, W);
						explosion(tempMap, shoot(tempMap, i), i);
						dropBlock(tempMap);
						
						explosion(tempMap, shoot(tempMap, j), j);
						dropBlock(tempMap);
						
						explosion(tempMap, shoot(tempMap, k), k);
						dropBlock(tempMap);
						
						int cnt = countBlock(tempMap);
						if (cnt < min) {
							min = cnt;
						}
					}
				}
			}
			break;
			
		case 4:
			for (int i = 0; i < W; i++) {
				for (int j = 0; j < W; j++) {
					for (int k = 0; k < W; k++) {
						for (int l = 0; l < W; l++) {
							int[][] tempMap = deepCopy(map, H, W);
							explosion(tempMap, shoot(tempMap, i), i);
							dropBlock(tempMap);
							
							explosion(tempMap, shoot(tempMap, j), j);
							dropBlock(tempMap);
							
							explosion(tempMap, shoot(tempMap, k), k);
							dropBlock(tempMap);
							
							explosion(tempMap, shoot(tempMap, l), l);
							dropBlock(tempMap);
							int cnt = countBlock(tempMap);
							if (cnt < min) {
								min = cnt;
							}
						}
					}
				}
			}
			break;
		}
		return min;
	}
	
	public static int countBlock(int[][] map) {
		int cnt = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (map[i][j] != 0) {
					cnt++;
				}
			}
		}
		return cnt;
	}
	
	public static int[][] deepCopy(int[][] origin, int H, int W) {
		int[][] result = new int[H][W];
		for (int i = 0; i < origin.length; i++) {
			System.arraycopy(origin[i], 0, result[i], 0, origin[i].length);
		}
		return result;
	}
	
	public static void dropBlock(int[][] map) {
		for (int j = 0; j < W; j++) {
			int top = 0;
			for (int i = H - 1; i >= 0; i--) {
				if (map[i][j] != 0) {
					int temp = map[i][j];
					map[i][j] = 0;
					map[H - (++top)][j] = temp;
				}
			}
			
		}
	}
	
	public static int shoot(int[][] map, int y) {
		for (int i = 0; i < H; i++) {
			if (map[i][y] != 0) {
				return i;
			}
		}
		return -1;
	}
	
	public static void explosion(int[][] map, int x, int y) {
		if (x < 0 || x > H - 1 || y < 0 || y > W - 1) {
			return;
		}
		if (map[x][y] == 0) {
			return;
		}
		
		int info = map[x][y];
		map[x][y] = 0;
		
		for (int t = 1; t < info; t++) {
			explosion(map, x + t, y);
			explosion(map, x - t, y);
			explosion(map, x, y + t);
			explosion(map, x, y - t);
		}
		
	}
}
