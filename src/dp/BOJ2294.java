package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 동전 2
 * n가지 종류의 동전을 적당히 사용해서, 그 가치의 합이 k원이 되도록만들기
 * 1<=n<=100, 1<=k<=10,000)
 * 각 동전의 가치는 100,000이하의 자연수
 * 가치가 같은 동전이 여러 번 주어질 수 있다
 * 동전의 구성이 같은데, 순서만 다른 것은 같은 경우이다
 * 사용한 동전의 최소 개수 출력, 불가능한 경우 -1 출력
 */
public class BOJ2294 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] coins = new int[n];
		for (int i = 0; i < n; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}

		int[] d = new int[10001];
		Arrays.fill(d, -1);

		for (int i = 1; i <= k; i++) {
			int min = Integer.MAX_VALUE;
			
			for (int next : coins) {
				if (next > 10000) {
					continue;
				}

				if (i - next == 0) {
					d[i] = 1;
					min = 1;
				} else if (i - next > 0 && d[i - next] != -1) {
						int temp = d[i - next] + 1;
						if (temp < min) {
							min = temp;
						}
				}
			}
			if (min != Integer.MAX_VALUE) {
				d[i] = min;
			}
		}
		System.out.println(d[k]);
	}
}
