package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * RGB거리
 * 모든 집을 RGB중 하나로 칠해야함, 모든 이웃은 같은색으로 칠할 수 없다
 * 각 집을 R, G, B로 칠할 때 드는 비용이 주어질 때, 모든 집을 칠할 때 드는 비용의 최솟값 출력
 */
public class BOJ1149 {
	public static void main(String[] args) throws Exception {
		BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] d = new int[N + 1][3]; // j=0:R, 1:G, 2:B
		StringTokenizer st = new StringTokenizer(br.readLine());
		d[1][0] = Integer.parseInt(st.nextToken());
		d[1][1] = Integer.parseInt(st.nextToken());
		d[1][2] = Integer.parseInt(st.nextToken());
		for (int i = 2; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			d[i][0] = Math.min(d[i - 1][1], d[i - 1][2]) + Integer.parseInt(st.nextToken());
			d[i][1] = Math.min(d[i - 1][0], d[i - 1][2]) + Integer.parseInt(st.nextToken());
			d[i][2] = Math.min(d[i - 1][0], d[i - 1][1]) + Integer.parseInt(st.nextToken());
		}
		System.out.println(min(d[N][0], d[N][1], d[N][2]));
	}
	
	public static int min(int a, int b, int c) {
		return a < b ? (a < c ? a : c) : (b < c ? b : c);
	}
}
