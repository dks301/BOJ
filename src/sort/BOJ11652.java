package sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
/*
 * 카드
 * 숫자 카드 N장 중 가장 많이 가지고 있는 카드에 적혀있는  정수 출력
 * 여러가지라면 정수가 작은것을 출력
 */
public class BOJ11652 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] num = new long[N];
		for (int i = 0; i < N; i++) {
			num[i] = Long.parseLong(br.readLine());
		}
		
		Arrays.sort(num);
		int cnt = 1;
		int maxCnt = 1;
		long maxNum = num[N - 1];
		for (int i = N - 2; i >= 0; i--) {
			if (num[i] == num[i + 1]) {
				cnt++;
				if (maxCnt <= cnt) {
					maxCnt = cnt;
					maxNum = num[i];
				}
			} else {
				cnt = 1;
				if (maxCnt <= cnt) {
					maxCnt = cnt;
					maxNum = num[i];
				}
			}
		}
		System.out.println(maxNum);
	}
}
