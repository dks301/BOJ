package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 롤러코스터
 * 부지는 R행 C열로 이루어짐
 * 롤러코스터는 가장 왼쪽 위칸에서 시작, 가장 오른쪽 아래칸에서 도착
 * 위, 아래, 왼쪽, 오른쪽으로 인접한 칸으로 한 칸씩 이동
 * 각 칸에는 그 칸을 지나갈때의 기쁨을 나타내는 수가 적혀있음
 * 
 * 입력
 * 첫째 줄: R과 C(2<=R,C<=1000)
 * 둘째 줄~R개 줄: 각 칸의 기쁨 (1000보다 작은 양의 정수)
 * 
 * 출력
 * 가장 큰 기쁨을 주는 롤러 코스터는 어떻게 이동하는지 U,R,L,D로 출력
 */
public class BOJ2873 {
	private static final String UP = "U";
	private static final String DOWN = "D";
	private static final String LEFT = "L";
	private static final String RIGHT = "R";
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		int up = -1, left = -1;
		for (int i = 1; i <= R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= C; j++) {
				int temp = Integer.parseInt(st.nextToken());
				if (i == R - 1 && j == C) {
					up = temp;
				}
				if (i == R && j == C - 1) {
					left = temp;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		if (R % 2 == 1) {
			for (int i = 1; i <= R; i++) {
				for (int j = 1; j <= C; j++) {
					if (i == R && j == C) {
						continue;
					}
					
					if (i % 2 == 1) {
						sb.append(j == C ? DOWN : RIGHT);
					} else {
						sb.append(j == C ? DOWN : LEFT);
					}
				}
			}
		} else if (C % 2 == 1) {
			for (int j = 1; j <= C; j++) {
				for (int i = 1; i <= R; i++) {
					if (i == R && j == C) {
						continue;
					}
					
					if (j % 2 == 1) {
						sb.append(i == R ? RIGHT : DOWN);
					} else {
						sb.append(i == R ? RIGHT : UP);
					}
				}
			}
		} else {
			for (int j = 1; j <= C - 2; j++) {
				for (int i = 1; i <= R; i++) {					
					if (j % 2 == 1) {
						sb.append(i == R ? RIGHT : DOWN);
					} else {
						sb.append(i == R ? RIGHT : UP);
					}
				}
			}
			
			boolean flag = false;
			for (int i = 1; i <= R - 2; i++) {
				for (int j = C - 1; j <= C; j++) {
					if (i == R - 1 && j == C - 1) {
						flag = true;
						break;
					}
					
					if (i % 2 == 1 && j % 2 == 1) {
						sb.append(j % 2 == 1 ? RIGHT : DOWN);
					} else {
						sb.append(j % 2 == 1 ? LEFT : DOWN);
					}
					
				}
				if (flag) {
					break;
				}
			}
			sb.append(up > left ? RIGHT + DOWN : DOWN + RIGHT);
		}
		System.out.println(sb);
	}
}
