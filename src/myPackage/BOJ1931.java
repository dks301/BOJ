package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 회의실 배정
 * 회의의 수 N(1<=N<=100,000)
 * 시작과 끝나는 시간 2^31-1보다 작거나 같은 자연수 또는 0
 * 회의가 겹치지 않고 최대로 사용할 수 있는 수 출력
 */
public class BOJ1931 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int ans = 0;
		int[][] meeting = new int[N][2]; //[N][0]: N-1번 째 회의의 시작시간, [1]: 끝나는 시간
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			meeting[i][0] = Integer.parseInt(st.nextToken());
			meeting[i][1] = Integer.parseInt(st.nextToken());
		}
	}
}
