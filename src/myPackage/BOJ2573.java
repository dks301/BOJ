package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 빙산
 * 빙산: 빙산의 높이로 저장(1~10), 바닷물: 0
 * 빙산의 높이는 동서남북으로 인접한 바닷물의 칸만큼 1년에 1씩 줄어듬(최소 0)
 * 행N과 열M은 3 이상 300 이하
 * 한 덩어리의 빙산이 주어질 때, 이 빙산이 두 덩어리 이상으로 분리되는데 걸리는 년수 출력.
 * 다 녹아도 두 덩어리 이상으로 분리되지 않으면 0 출력. 
 */
public class BOJ2573 {
	private static int[][] map;
	private static int[][] check;
	
	private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	private static final int ROW = 0;
	private static final int COL = 1;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		check = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				
			}
		}
	}
}
