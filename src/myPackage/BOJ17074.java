package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 정렬
 * 배열이 주어지고 하나를 버렸을 때, 정렬이 되어있는 경우의 수 출력
 * 어떻게...?
 * 첫째줄: 배열의크기N(2<=N<=10^5)
 * 둘째줄: 배열의원소 ai N개(-10^9<=ai<=10^9)
 */
public class BOJ17074 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] a = new int[N + 2];
		a[0] = Integer.MIN_VALUE;
		a[N + 1] = Integer.MAX_VALUE;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		int isFirst = 0;
		int isSecond = 0;
		for (int i = 0; i <= N; i++) {
			int cur = a[i];
			int next = a[i + 1];
			
			if (cur > next && isFirst == 0) {
				isFirst = i;
				if (a[i - 1] > a[i + 1]) {
					isSecond = i + 1;
					break;
				}
			} else if (cur > next && isFirst != 0) {
				isSecond = i;
				break;
			}
		}
		
		if (isFirst == 0 && isSecond == 0) {
			System.out.println(N);
		} else if (isFirst != 0 && isSecond == 0) {
			if (isFirst == N - 1 && a[N - 2] <= a[N]) {
				System.out.println(2);
			} else {
				System.out.println(1);
			}
		} else {
			System.out.println(0);
		}
	}
}
