package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 시험 감독
 * 총 N개 시험장, i번 시험장에 있는 응시자 수는 Ai명
 * 총감독관은  각 시험장에 1명이지만 한 방에서 감시할 수 있는 응시자의 수가 B명
 * 부감독관은 각 시험장에 0~여러명일수도 있지만 감시할 수있는 응시자의 수가 C명
 * 응시생들을 모두 감시해야 할 때, 필요한 감독관의 수의 최솟값 출력.
 * 
 * 첫줄: 시험장의 개수 N(1<=N<=1,000,000)
 * 둘째줄: 응시자의 수 Ai(1<=Ai<=1,000,000)
 * 셋째줄: B와 C(1<=B,C<=1,000,000)
 */
public class BOJ13458 {
	private static final int MAX = 1_000_001;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		long[] d = new long[MAX];
		for (int i = 0; i <= B; i++) {
			d[i] = 1;
		}
		
		boolean isEnd = false;
		for (int i = B + 1; i < MAX; i++) {
			int j = 0;
			for (j = 0; j < C; j++) {
				if (i + j > MAX - 1) {
					isEnd = true;
					break;
				}
				d[i + j] = d[i - 1] + 1;
			}
			if (isEnd) {
				break;
			}
			i += j - 1;
		}

		long total = 0;
		for (int i = 0; i < N; i++) {
			total += d[A[i]];
		}
		System.out.println(total);
	}
}
