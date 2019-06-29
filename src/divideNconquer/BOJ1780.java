package divideNconquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 종이의 개수
 * NxN크기의 행렬 종이, 각 칸에는 -1, 0, 1 세값중 하나가 저장
 * 1. 만약 종이가 모두 같은 수로 되어 있다면 이 종이를 그대로 사용
 * 2. 1이 아닌 경우에는 종이를 같은 크기의 9개의 종이로 자르고, 각각의 잘린 종이에 대해서 1을 반복
 * 
 * 입력
 * 첫째줄: N(1<=N<=3^7, N은 3^k꼴)
 * 다음 N개줄: N개의 정수로 행렬이 주어진다
 * 
 * 출력
 * 첫째줄: -1로만 채워진 종이의 개수
 * 둘째줄: 0으로만 채워진 종이의 개수
 * 셋째줄: 1로만 채워진 종이의 개수
 */
public class BOJ1780 {
	private static int[][] paper;
	private static int M_ONE = 0;
	private static int ZERO = 0;
	private static int P_ONE = 0;
	
	private static final String NEW_LINE = "\n";
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		paper = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		cutting(0, 0, N);
		StringBuilder sb = new StringBuilder();
		sb.append(M_ONE).append(NEW_LINE);
		sb.append(ZERO).append(NEW_LINE);
		sb.append(P_ONE).append(NEW_LINE);
		System.out.println(sb);
	}
	
	public static void cutting(int startRow, int startCol, int size) {
		int checkVal = check(startRow, startCol, size);
		switch (checkVal) {
		case -2:
			int cuttingSize = size / 3;
			for (int i = startRow; i < startRow + size; i += cuttingSize) {
				for (int j = startCol; j < startCol + size; j += cuttingSize) {
					cutting(i, j, cuttingSize);
				}
			}
			break;
		case -1:
			M_ONE++;
			return;
			
		case 0:
			ZERO++;
			return;
			
		case 1:
			P_ONE++;
			return;
		}
	}
	
	public static int check(int startRow, int startCol, int size) {
		int val = paper[startRow][startCol];
		for (int i = startRow; i < startRow + size; i++) {
			for (int j = startCol; j < startCol + size; j++) {
				if (paper[i][j] != val) {
					return -2;
				}
			}
		}
		return val;
	}
}
