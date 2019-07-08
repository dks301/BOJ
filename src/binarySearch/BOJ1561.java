package binarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 놀이 공원
 * N명의 아이들이 한줄로 줄을 서서 1인승 놀이기구를 기다린다.
 * M종류의 1인승 놀이기구가 1번부터 M번까지 번호가 매겨져 있다.
 * 모든 놀이기구는 각각 운행시간이 정해져 있다.
 * 놀이기구가 비어 있으면 가장 앞에아이가 빈 놀이기구에 탑승
 * 여러개가 비어있으면 더 작은 번호의 놀이기구를 탑승
 * 
 * 입력
 * 첫째줄: N(1<=N<=2,000,000,000)과 M(1<=M<=10,000)
 * 둘째줄: 각 놀이기구의 운행시간을 나타내는 M개의 자연수가 순서대로(1이상 30이하의 자연수 분단위)
 * 
 * 출력
 * 마지막 아이가 타게되는 놀이기구의 번호 출력
 */
public class BOJ1561 {
	private static int N, M;
	private static int[] rides;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		rides = new int[M + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= M; i++) {
			rides[i] = Integer.parseInt(st.nextToken());
		}
		
		long left = 0, right = (30 * 2_000_000_000L);
		long child = 0;
		while (left <= right) {
			long mid = left + ((right - left) / 2);
			child = solve(mid);
			if (child >= N) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		
		child = solve(left);
		int ans = 0;
		for (int i = M; i >= 1; i--) {
			if ((left) % rides[i] == 0) {
				if (child == N) {
					ans = i;
					break;
				} else if (child > N) {
					child--;
				}
			}
		}
		System.out.println(ans);
	}
	
	public static long solve(long val) {
		long num = 0;
		for (int i = 1; i <= M; i++) {
			num += (val / rides[i] + 1);
		}
		return num;
	}
}
