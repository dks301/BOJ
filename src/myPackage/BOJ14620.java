package myPackage;

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
 * N(6<=N<=10), 한 칸 가격G(0<=G<=200)
 * 꽃이 다 피기 위한 화단 구입 최소 비용 출력
 */
public class BOJ14620 {
	private static int[][] map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
	}
}
