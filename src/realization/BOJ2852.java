package realization;

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
	private static final String COLON = ":";

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[][] time = new int[3][2]; // i: 팀, j [0]:분, [1]:초

		int balance = 0;

		int min = 0;
		int sec = 0;
		int goal = 0;
		int lastMin = 0;
		int lastSec = 0;
		
		boolean isFirst = true;
		while (N-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			goal = Integer.parseInt(st.nextToken());
			if (goal == 1) {
				balance++;

			} else {
				balance--;
			}

			st = new StringTokenizer(st.nextToken(), COLON);
			min = Integer.parseInt(st.nextToken());
			sec = Integer.parseInt(st.nextToken());

			if (balance > 0) {
				if (isFirst == true) {
					isFirst = false;
					lastMin = min;
					lastSec = sec;
					continue;
				}
				time[1][0] += (min - lastMin);
				time[1][1] += (sec - lastSec);

				if (time[1][1] >= 60) {
					time[1][0]++;
					time[1][1] -= 60;

				} else if (time[1][1] < 0) {
					time[1][0]--;
					time[1][1] += 60;
				}
			} else if (balance == 0) {
				isFirst = true;
				
				if (goal == 1) {
					time[2][0] += (min - lastMin);
					time[2][1] += (sec - lastSec);

					if (time[2][1] >= 60) {
						time[2][0]++;
						time[2][1] -= 60;

					} else if (time[2][1] < 0) {
						time[2][0]--;
						time[2][1] += 60;
					}
				} else {
					time[1][0] += (min - lastMin);
					time[1][1] += (sec - lastSec);

					if (time[1][1] >= 60) {
						time[1][0]++;
						time[1][1] -= 60;

					} else if (time[1][1] < 0) {
						time[1][0]--;
						time[1][1] += 60;
					}
				}
				
			} else {
				if (isFirst == true) {
					isFirst = false;
					lastMin = min;
					lastSec = sec;
					continue;
				}
				
				time[2][0] += (min - lastMin);
				time[2][1] += (sec - lastSec);

				if (time[2][1] >= 60) {
					time[2][0]++;
					time[2][1] -= 60;

				} else if (time[2][1] < 0) {
					time[2][0]--;
					time[2][1] += 60;
				}
			}
			lastMin = min;
			lastSec = sec;
		}

		if (balance > 0) {
			time[1][0] += 48 - min;
			time[1][1] += 0 - sec;

			if (time[1][1] >= 60) {
				time[1][0]++;
				time[1][1] -= 60;

			} else if (time[1][1] < 0) {
				time[1][0]--;
				time[1][1] += 60;
			}

		} else if (balance < 0) {
			time[2][0] += 48 - min;
			time[2][1] += 0 - sec;

			if (time[2][1] >= 60) {
				time[2][0]++;
				time[2][1] -= 60;

			} else if (time[2][1] < 0) {
				time[2][0]--;
				time[2][1] += 60;
			}
		}
		
		System.out.println((time[1][0] < 10 ? "0" + time[1][0] : time[1][0]) + COLON + (time[1][1] < 10 ? "0" + time[1][1] : time[1][1]));
		System.out.println((time[2][0] < 10 ? "0" + time[2][0] : time[2][0]) + COLON + (time[2][1] < 10 ? "0" + time[2][1] : time[2][1]));
	}
}
