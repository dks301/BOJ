package binarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 랜선 자르기
 * 오영식은 길이가 제각각인 K개의 랜선을 가지고 있다.
 * N개의 같은 길이의 랜선으로 만들어야 한다
 * K개의 랜선으로 N개의 랜선을 만들 수 없는 경우는 없다고 가정
 * 자를때는 항상 센티미터 단위의 정수길이만큼 자른다
 * 
 * 입력
 * 첫째줄: 랜선의 개수 K, 필요한 랜선의 개수 N (1<=K<=10,000, 1<=N<=1,000,000, K<=N)
 * 이후 K개줄: 각 랜선의 길이 (길이<=2^31 - 1)
 * 
 * 출력
 * N개를 만들 수 있는 랜선의 최대 길이를 센티미터 단위의 정수로 출력
 */
public class BOJ1654 {
	private static int K, N;
	private static int[] line;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		int max = 0;
		line = new int[K];
		for (int i = 0; i < K; i++) {
			line[i] = Integer.parseInt(br.readLine());
			if (max < line[i]) {
				max = line[i];
			}
		}

		long left = 1, right = max;
		long mid;

		while (left <= right) {
			mid = (left + right) / 2;
			long cnt = solve(mid);
			
			if (cnt >= N) {
				left = mid + 1;
			}else {
				right = mid - 1;
			}
		}
		System.out.println(left - 1);
	}

	public static long solve(long unit) {
		long cnt = 0;
		for (int i = 0; i < K; i++) {
			cnt += (line[i] / unit);
		}
		return cnt;
	}
}
