package binarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 공유기 설치
 * 집 N개가 수직선 위에 있고 각각의 집의 좌표는 x1, ..., xN이다.
 * xi은 모두 다른 좌표를 가진다.
 * 공유기 C개를 설치, 한집에는 최대 하나만 설치해서 가장 인접한 두 공유기 사이의 거리를 최대로
 * 
 * 입력
 * 첫째줄: 집의 개수 N, 공유기의 개수 C(2<=N<=200_000, 2<=C<=N)
 * 둘째줄~N개의줄: xi(1<=xi<=1_000_000_000)
 */
public class BOJ2110 {
	private static int N, C;
	private static int[] home;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		home = new int[N];
		for (int i = 0; i < N; i++) {
			home[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(home);
		
		int left = 1, right = 1_000_000_000;
		while (left <= right) {
			int mid = (left + right) / 2;
			
			if (possible(mid)) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		System.out.println(left - 1);
	}
	
	public static boolean possible(int dis) {
		int cnt = 1;
		int pivot = home[0];
		for (int i = 1; i < N; i++) {
			int distance = home[i] - pivot;
			if (distance >= dis) {
				cnt++;
				pivot = home[i];
			}
		}
		
		if (cnt >= C) {
			return true;
		} else {
			return false;
		}
	}
}
