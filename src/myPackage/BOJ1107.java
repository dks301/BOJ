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
 */
public class BOJ1107 {
	private static boolean[] brokenButton = {false, false, false, false, false, false, false, false, false, false};
	private static int[] N = {-1, -1, -1, -1, -1, -1, -1};
	private static int ans = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tempN = Integer.parseInt(br.readLine());
		for (int i = 6; i >= 1; i--) {
			N[i] = tempN % 10;
			tempN = tempN / 10;
			if (tempN == 0) {
				break;
			}
		}
		int M = Integer.parseInt(br.readLine());
		
		if (M != 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				brokenButton[Integer.parseInt(st.nextToken())] = true;
			}
		}
		
		for (int i = 0; i <= 9; i++) {
			if (brokenButton[i]) {
				int val = findClosest(i);
			}
		}
		
		
	}
	
	public static int findBottomUp(int n) {
		int bottom = 0, up = 0;
		for (int i = n - 1; i >= 0; i--) {
			bottom++;
			if (!brokenButton[i]) {
				break;
			}
		}
		for (int i = n + 1; i <= 9; i++) {
			up++;
			if (!brokenButton[i]) {
				break;
			}
		}
		return bottom > up ? n + up : n - bottom;
	}
	
	public static int findClosest(int n) {
		int[] closest = {-1, -1, -1, -1, -1, -1, -1};
		for (int i = 1; i <= 6; i++) {
			if (N[i] != -1) {
				if (brokenButton[N[i]]) {
					closest[i] = findBottomUp(N[i]);
				} else {
					ans++;
					closest[i] = N[i];
				}
			}
		}
	}
}
