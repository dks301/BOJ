package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 1, 2, 3 더하기2
 * 정수n을 1,2,3의 합으로 나타내는 방법을 사전순으로 정렬
 * 
 * 입력
 * 첫째줄: 정수 n과 k (n<11, k<=2^31-1)
 * 
 * 출력
 * n을 1,2,3의 합으로 나타내는 방법 중에서 사전순으로 k번째에 오는 것을 출력
 * k번째가 없으면 -1출력
 */
public class BOJ12101 {
	private static final char PLUS = '+';
	private static final char ONE = '1';
	private static final char TWO = '2';
	private static final char THREE = '3';
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] d = new int[11];
		d[0] = 1;
		d[1] = 1;
		d[2] = 2;
		for (int i = 3; i < 11; i++) {
			d[i] = d[i - 3] + d[i - 2] + d[i - 1];
		}
		
		if (k > d[n]) {
			System.out.println(-1);
		} else {
			d = new int[d[n]];
			Arrays.fill(d, 1);
			
			StringBuilder sb = new StringBuilder();
			for (int i = 1; i <= k; i++) {
				
			}
		}
		
	}
	
	public static void solve(int[] arr, int cnt, int last) {
		if (cnt == last) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			
		}
	}
	
	public static void next(int n) {
		for (int i = 1; i <= n; i++) {
			
		}
	}
}
