package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 활주로 건설
 * N*N크기의 절벽지대, 셀의 숫자는 그 지형의 높이
 * 가로 또는 세로 방향으로 건설할 수 있는 가능성 확인
 * 경사로는 길이가 X, 높이 1
 * 경사로의 길이X와 절벽지대의 정보가 주어질 때, 활주로를 건설할 수 있는 경우의 수 출력.
 * 
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
			
			for (int i = 0; i < N; i++) {
				System.out.println(right(i));
			}
			sb.append(NEW_LINE);
		}
	}
	
	public static boolean right(int i) {
		int cnt = 0;

		for (int j = 0; j < N - 1; j++) {
			if (map[i][j] == map[i][j + 1]) {
				cnt++;
			} else if ((map[i][j] - map[i][j + 1]) == -1) {
				if (j - X <= 0 || cnt < X) {
					return false;
				} else {
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
	
	public static void bottom() {
		
	}
}
