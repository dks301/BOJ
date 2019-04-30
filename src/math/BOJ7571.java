package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 점 모으기
 * NxN인 격자공간에 M개의 점
 * 격자공간에 있는 모든 점들을 하나의 사각형으로 모을 때 드는 이동거리의 합의 최솟값 출력
 * 1<=N<=10,000 , 1<=M<=100,000 
 */
public class BOJ7571 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] x = new int[M];
		int[] y = new int[M];
		
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(x);
		Arrays.sort(y);
		
		int ans = calDistance(x, Math.round(M / 2));
		ans += calDistance(y, Math.round(M / 2));
		System.out.println(ans);
	}
	
	public static int calDistance(int[] d, int mIdx) {
		int total = 0;
		int m = d[mIdx];
		for (int i = 0; i < d.length; i++) {
			total += Math.abs(m - d[i]);
		}
		return total;
	}
}
