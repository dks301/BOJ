package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 순열의 순서
 * 1부터 N까지의 수를 임의로 배열한 순열
 * 1. k가 주어지면 k번째 순열을 구한다
 * 2. 순열이 주어지면 몇번째 순열인지 구한다
 * 
 * 입력
 * 첫째줄: N(1<=N<=20)
 * 둘째줄: 첫번째 수는 소문제 번호 + k or 임의순열
 * 
 * 출력
 * 정답 출력
 */
public class BOJ1722 {
	private static int N;
	private static int[] A;
	
	private static final char SPACE = ' ';
	private static final char NEW_LINE = '\n';
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		A = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			A[i] = i;
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		if (Integer.parseInt(st.nextToken()) == 1) {
			int k = Integer.parseInt(st.nextToken());
			StringBuilder sb = new StringBuilder();
			do {
				k--;
				if (k == 0) {
					for (int i = 1; i <= N; i++) {
						sb.append(A[i]).append(SPACE);
					}
					break;
				}
			} while(nextPermutation());
			
			System.out.println(sb);
			
		} else {
			int[] B = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				B[i] = Integer.parseInt(st.nextToken());
			}
			boolean isNotSame = true;
			int cnt = 0;
			do {
				cnt++;
				for (int i = 1; i <= N; i++) {
					if (A[i] != B[i]) {
						isNotSame = true;
						break;
					} else {
						isNotSame = false;	
					}
					
				}
			} while(nextPermutation() && isNotSame);
			
			System.out.println(cnt);
		}
	}
	
	public static boolean nextPermutation() {
		int i = N;
		while (i > 1 && A[i - 1] >= A[i]) {
			i--;
		}
		if (i <= 1) return false;
		
		int j = N;
		while (A[j] <= A[i - 1]) {
			j--;
		}
		
		swap(i - 1, j);
		
		j = N;
		while (i < j) {
			swap(i, j);
			i++;
			j--;
		}
		
		return true;
	}
	
	public static void swap(int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
}
