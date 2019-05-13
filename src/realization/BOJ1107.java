package realization;

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
 */
public class BOJ1107 {
	private static boolean[] brokenButton = new boolean[10];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		if (M != 0 && M != 10) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				brokenButton[Integer.parseInt(st.nextToken())] = true;
			}
			
			if (M == 9 && !brokenButton[0]) {
				System.out.println(Math.min(N + 1, Math.abs(N - 100)));
				
			} else {
				int up = findNearestUp(N);
				int down = findNearestDown(N);
				int upValue = up - N + findDigit(up);
				int downValue = Math.abs(N - down) + findDigit(down);
				
				System.out.println(min(upValue, downValue, Math.abs(N - 100)));
			}
			
		} else if (M == 10) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				brokenButton[Integer.parseInt(st.nextToken())] = true;
			}
			
			System.out.println(Math.abs(N - 100));
			
		} else {
			int digit = findDigit(N);
			System.out.println(Math.abs(N - 100) < digit ? Math.abs(N - 100) : digit);
		}
	}
	
	public static int min(int a, int b, int c) {
		return a < b ? (a < c ? a : c) : (b < c ? b : c);
	}
	
	public static int findDigit(int value) {
		if (value == 0) {
			return 1;
		}
		int cnt = 0;
		while (value != 0) {
			value /= 10;
			cnt++;
		}
		return cnt;
	}
	
	public static int findNearestUp(int value) {
		if (value == 0) {
			value++;
		}
		while (!check(value)) {
			value++;
		}
		return value;
	}
	
	public static int findNearestDown(int value) {
		while (!check(value)) {
			value--;
		}
		if (value == 0 && brokenButton[0]) {
			return Integer.MAX_VALUE - 10;
		}
		return value;
	}
	
	public static boolean check(int value) {
		while (value != 0) {
			int temp = value % 10;

			if (brokenButton[temp]) {
				return false;
			}
			value /= 10;
		}
		return true;
	}
}
