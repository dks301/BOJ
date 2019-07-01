package divideNconquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 쿼드트리
 * 0과 1로만 이루어진 영상(2차원 배열)에서 이를 압축
 * 주어진 영상이 모두 0이면 압축 결과는0, 모두 1이면 압축 결과는 1
 * 섞여있으면 왼쪽 위, 오른쪽 위, 왼쪽 아래, 오른쪽 아래 4개의 영상으로 나누어서 압축
 * 압축하면 괄호로 묶어서 표현
 * 
 * 입력
 * 첫째줄: 영상의 크기N(1<=N<=64, 2의제곱수)
 * 둘째줄~N개줄: 길이 N의 문자열(0 또는 1)
 * 
 * 출력
 * 압축 결과 출력
 */
public class BOJ1992 {
	private static final char B_START = '(';
	private static final char B_END = ')';
	private static char[][] map;
	
	private static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		
		for (int i = 0; i < N; i++) {
			char[] t = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				map[i][j] = t[j];
			}
		}
		solve(0, 0, N);
		System.out.println(sb);
	}
	
	public static boolean isSame(int startRow, int startCol, int size) {
		for (int i = startRow; i < startRow + size; i++) {
			for (int j = startCol; j < startCol + size; j++) {
				if (map[startRow][startCol] != map[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static void solve(int startRow, int startCol, int size) {
		if (isSame(startRow, startCol, size)) {
			sb.append(map[startRow][startCol]);
		} else {
			sb.append(B_START);
			
			int nextSize = size / 2;
			solve(startRow, startCol, nextSize);
			solve(startRow, startCol + nextSize, nextSize);
			solve(startRow + nextSize, startCol, nextSize);
			solve(startRow + nextSize, startCol + nextSize, nextSize);
			
			sb.append(B_END);
		}
	}
}
