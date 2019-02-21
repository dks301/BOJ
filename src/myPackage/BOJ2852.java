package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * NBA 농구
 * 골이 들어간 횟수 N(1<=N<=100)
 * 1,2팀이 있고 농구경기는 48분간 진행
 * 첫째줄에 1팀이 이기고 있던 시간, 둘째줄에 2팀이 이기고 있던 시간 출력
 */
public class BOJ2852 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] time = new int[3][3]; // i: 팀, j 0: 
		
		while (N-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int goal = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(st.nextToken(), ":");
			
			time[goal][1] = Integer.parseInt(st.nextToken());
			time[goal][2] = Integer.parseInt(st.nextToken());
			
		}
	}
}
