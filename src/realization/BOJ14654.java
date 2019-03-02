package realization;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 스테판 쿼리
 * 총 N라운드(1<=N<=300), 가위는 1, 바위는 2, 보는 3
 * 진 사람은 탈락, 이긴 사람이 계속 게임을 진행하는 서바이벌
 * 단, 비긴 경우에는 새로 출전한 사람이 승리한 것으로 간주
 * 첫판에는 비기는 사람이 없다
 * 두 팀이 가위바위보 대회를 할 때, 최대 연승의 수 출력
 */
public class BOJ14654 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] B = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(game(N, A, B));
	}
	
	public static int game(int N, int[] A, int[] B) {
		boolean flag = false; // true: A, false: B
		
		switch (A[0]) {
			case 1:
				if (B[0] == 2) {
					flag = false;
				} else {
					flag = true;
				}
				break;
			
			case 2:
				if (B[0] == 3) {
					flag = false;
				} else {
					flag = true;
				}
				break;
				
			case 3:
				if (B[0] == 1) {
					flag = false;
				} else {
					flag = true;
				}
				break;
		}
		
		int max = 1;
		int cnt = 1;
		
		for (int i = 1; i < N; i++) {
			switch (A[i]) {
			case 1:
				if (B[i] == 1) {
					if (flag == true) {
						cnt = 1;
						flag = false;
						
					} else {
						cnt = 1;
						flag = true;
					}
				} else if (B[i] == 2) {
					if (flag == true) {
						cnt = 1;
						flag = false;
						
					} else {
						cnt++;
						if (max < cnt) {
							max = cnt;
						}
					}
				} else { // B[i] == 3
					if (flag == true) {
						cnt++;
						if (max < cnt) {
							max = cnt;
						}
						
					} else {
						cnt = 1;
						flag = true;
					}
				}
				break;
				
			case 2:
				if (B[i] == 1) {
					if (flag == true) {
						cnt++;
						if (max < cnt) {
							max = cnt;
						}
						
					} else {
						cnt = 1;
						flag = true;
					}
				} else if (B[i] == 2) {
					if (flag == true) {
						cnt = 1;
						flag = false;
						
					} else {
						cnt = 1;
						flag = true;
					}					
				} else { // B[i] == 3
					if (flag == true) {
						cnt = 1;
						flag = false;
						
					} else {
						cnt++;
						if (max < cnt) {
							max = cnt;
						}
					}
				}
				break;
				
			case 3:
				if (B[i] == 1) {
					if (flag == true) {
						cnt = 1;
						flag = false;
						
					} else {
						cnt++;
						if (max < cnt) {
							max = cnt;
						}
					}
				} else if (B[i] == 2) {
					if (flag == true) {
						cnt++;
						if (max < cnt) {
							max = cnt;
						}
						
					} else {
						cnt = 1;
						flag = true;
					}
				} else { // B[i] == 3
					if (flag == true) {
						cnt = 1;
						flag = false;
						
					} else {
						cnt = 1;
						flag = true;
					}
				}
				break;
			}
		}
		
		return max;
	}
}