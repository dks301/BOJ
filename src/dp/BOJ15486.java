package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 퇴사2
 * N+1일째 되는 날 퇴사, N일 동안 최대한 많은 상담 하기
 * 상담 기간 Ti, 금액 Pi
 * 퇴사 전 얻을 수 있는 최대 수익 출력
 * 
 * 첫째줄: 1<=N<=1,500,000
 * 둘째줄부터 N개줄: Ti(1<=Ti<=50) Pi(1<=Pi<=1,000), 1일부터 N일까지 순서대로
 */
public class BOJ15486 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] T = new int[N + 1];
		int[] P = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] d = new int[N + 1];
		if (T[N] == 1) {
			d[N] = P[N];
		} else {
			d[N] = 0;
		}

		for (int i = N - 1; i > 0; i--) {
			if (i + T[i] - 1 > N) {
				d[i] = d[i + 1];
			} else if (i + T[i] - 1 == N){
				d[i] = Math.max(P[i], d[i + 1]);
			} else {
				d[i] = Math.max(d[i + T[i]] + P[i], d[i + 1]);
			}
		}
		System.out.println(d[1]);
	}
}
