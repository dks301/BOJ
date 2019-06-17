package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/*
 * NMK
 * 1부터 N까지의 수를 한 번씩 이용
 * 최대 부분 증가 수열의 길이가 M, 최대 부분 감소 수열의 길이가 K인 수열 출력
 * 
 * 입력
 * 첫째 줄: N M K는 자연수(N<=500, M,K<=N)
 * 
 * 출력
 * 문제의 정답 출력, 없다면 -1 출력
 */
public class BOJ1201 {
	private static final String SPACE = " ";

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		if (M + K - 1 <= N && N <= M * K) {
			int[] arr = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				arr[i] = i;
			}
			ArrayList<Integer>[] group = new ArrayList[M + 1];
			for (int i = 1; i <= M; i++) {
				group[i] = new ArrayList<Integer>();
			}
			
			for (int i = 1; i <= K; i++) {
				group[1].add(arr[i]);
			}
			
			int jump = (M == 1) ? 1 : ((N - K) / (M - 1));
			int groupIdx = 2;
			int lastVal = K;
			for (int i = K + 1; i <= N; i += jump) {
				for (int j = i; j < i + jump; j++) {
					group[groupIdx].add(arr[j]);
					lastVal = j;
				}
				groupIdx++;
				if (groupIdx > M) {
					break;
				}
			}
			
			groupIdx--;
			while (lastVal != N) {
				if (group[groupIdx].size() > K) {
					groupIdx--;
					continue;
				}
				group[groupIdx].add(++lastVal);
			}
			
			for (int i = 1; i <= M; i++) {
				Collections.reverse(group[i]);
			}
			
			StringBuilder sb = new StringBuilder();
			for (int i = 1; i <= M; i++) {
				for (int j = 0; j < group[i].size(); j++) {
					sb.append(group[i].get(j)).append(SPACE);	
				}
			}
			System.out.println(sb);
			
		} else {
			System.out.println(-1);
		}

	}
}
