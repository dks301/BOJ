package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 연속합
 * n개의 정수로 이루어진 임의의 수열을 중 연속된 몇개의 수를 선택해서 구할수 있는 합의 최대값
 */
public class BOJ1912 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] a = new int[n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] d = new int[n + 1];
		int max = -1000;
		for (int i = 1; i <= n; i++) {
			d[i] = d[i - 1] > 0 ? d[i - 1] + a[i] : a[i];
			if (max < d[i]) {
				max = d[i];
			}
		}
		System.out.println(max);
	}
}
