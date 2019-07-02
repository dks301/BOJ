package divideNconquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * Z
 * 2차원 배열(2^N * 2^N크기)를 Z모양으로 탐색
 * 2*2배열은 왼쪽 위, 오른쪽위, 왼쪽아래, 오른쪽아래 순으로 탐색
 * 보다 크면 배열을 4등분한 후에 같은 순서로 탐색
 * 
 * 입력
 * 첫째줄: N r c(N<=15, 0<=r&c<=2^N-1)
 * 
 * 출력
 * (r,c)를 몇번째로 방문하는지 출력
 */
public class BOJ1074 {
	private static int r, c, ans, cnt = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = (int)Math.pow(2, Integer.parseInt(st.nextToken()));
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		solve(0, 0, N);
		
		System.out.println(ans);
	}
	
	public static void solve(int x, int y, int n) {
		if (n == 2) {
			for (int i = x; i < x + n; i++) {
				for (int j = y; j < y + n; j++) {
					if (i == r && j == c) {
						ans = cnt;
					}
					cnt++;
				}
			}
			return;
		}
		
		int val = n / 2;
		for (int i = x; i < x + n; i += val) {
			for (int j = y; j < y + n; j += val) {
				solve(i, j, val);
			}
		}
	}
	
}
