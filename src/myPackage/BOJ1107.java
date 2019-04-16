package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * 리모컨
 * 버튼: 0~9, +, -
 * 채널 0에서 -를 누른 경우 채널 변경안됨, 채널은 무한대만큼 존재
 * 현재 채널은 100번
 * N(0<=N<=500,000), 고장난 버튼의 수M(0<=M<=10)
 * 채널 N으로 이동하기 위해 버튼을 최소 몇 번 눌러야하는지 출력 
 * dp?
 */
public class BOJ1107 {
	private static boolean[] numButton = 
		{true, true, true, true, true, true, true, true, true, true};
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		if (M != 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				numButton[Integer.parseInt(st.nextToken())] = false;
			}
		}
		
		int ans = Math.abs(N - 100);
		int div = (int)Math.pow(10, findDigit(N) - 1);
		
		
	}
	
	public static void closest(int N, int div) {
		int val = N / div;
		if (N / div != 0) {
			
		} else {
			
		}
	}
	
	public static int findDigit(int N) {
		if (N == 0) {
			return 1;
		}
		
		int cnt = 0;
		while (N != 0) {
			N /= 10;
			cnt++;
		}
		return cnt;
	}
}
