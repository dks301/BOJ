package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 활주로 건설
 * N*N크기의 절벽지대, 셀의 숫자는 그 지형의 높이
 * 가로 또는 세로 방향으로 건설할 수 있는 가능성 확인
 * 경사로는 길이가 X, 높이 1
 * 경사로의 길이X와 절벽지대의 정보가 주어질 때, 활주로를 건설할 수 있는 경우의 수 출력.
 */
public class SWEA4014 {
	private static final String SPACE = " ";
	private static final String NEW_LINE = "\n";
	private static final String NUMBER = "#";
	
	private static int[][] map;
	private static int N;
	private static int X;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			sb.append(NUMBER).append(t).append(SPACE);
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				cnt = right(i) ? cnt + 1 : cnt;
				cnt = down(i) ? cnt + 1 : cnt;
			}
			
			sb.append(cnt).append(NEW_LINE);
		}
		System.out.print(sb);
	}
	
	public static boolean right(int i) {
		int cnt = 0;
		boolean[] isIncline = new boolean[N];

		for (int j = 0; j < N - 1; j++) {
			if (map[i][j] == map[i][j + 1]) {
				cnt++;
			} else if ((map[i][j] - map[i][j + 1]) == -1) {
				if (j + 1 < X || cnt + 1 < X) {
					return false;
				} else {
					for (int k = j; k > j - X; k--) {
						if (isIncline[k] == true) {
							return false;
						}
					}
					cnt = 0;
				}
			} else if ((map[i][j] - map[i][j + 1]) == 1) {
				if (j + X >= N) {
					return false;
				}
				for (int k = 0; k < X - 1; k++) {
					if (map[i][j + 1] != map[i][j + 2]) {
						return false;
					} else {
						isIncline[j + 1] = true;
						isIncline[j + 2] = true;
						cnt++;
						j++;
					}
				}
			} else {
				return false;
			}
		}
		return true;
	}
	
	public static boolean down(int j) {
		int cnt = 0;
		boolean[] isIncline = new boolean[N];
		
		for (int i = 0; i < N - 1; i++) {
			if (map[i][j] == map[i + 1][j]) {
				cnt++;
				
			} else if ((map[i][j] - map[i + 1][j]) == -1) {
				if (i + 1 < X || cnt + 1 < X) {
					return false;
				} else {
					for (int k = i; k > i - X; k--) {
						if (isIncline[k] == true) {
							return false;
						}
					}
					cnt = 0;
				}
			} else if ((map[i][j] - map[i + 1][j]) == 1) {
				if (i + X >= N) {
					return false;
				}
				for (int k = 0; k < X - 1; k++) {
					if (map[i + 1][j] != map[i + 2][j]) {
						return false;
					} else {
						isIncline[i + 1] = true;
						isIncline[i + 2] = true;
						cnt++;
						i++;
					}
				}
			} else {
				return false;
			}
		}
		return true;
	}
}
