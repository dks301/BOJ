package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 조합 0의 갯수
 * nCm의 끝자리 0의 갯수 구하기 
 * https://ksj14.tistory.com/entry/BackJoon1676-%ED%8C%A9%ED%86%A0%EB%A6%AC%EC%96%BC-0%EC%9D%98-%EA%B0%9C%EC%88%98
 */
public class BOJ2004 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		long cntFive = 0, cntTwo = 0;
		for (long i = 2; i <= n; i *= 2) {
			cntTwo = cntTwo + n / i;
		}
		for (long i = 5; i <= n; i *= 5) {
			cntFive = cntFive + n / i;
		}
		for (long i = 2; i <= m; i *= 2) {
			cntTwo = cntTwo - m / i;
		}
		for (long i = 5; i <= m; i *= 5) {
			cntFive = cntFive - m / i;
		}
		for (long i = 2; i <= n - m; i *= 2) {
			cntTwo = cntTwo - (n - m) / i;
		}
		for (long i = 5; i <= n - m; i *= 5) {
			cntFive = cntFive - (n - m) / i;
		}
		System.out.println(Math.min(cntTwo, cntFive));
	}
}
