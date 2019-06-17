package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * 대회 or 인턴
 * 1팀은 여학생 2명 + 남학생 1명
 * N명의 여학생, M명의 남학생, K명의 인턴
 * 
 * 입력
 * 첫째 줄: 여학생N, 남학생M, 인턴쉽참여자K가 순서대로 (0<=M<=100, 0<=N<=100, 0<=K<=M+N)
 * 
 * 출력
 * 만들 수 있는 팀 수의 최댓값 출력.
 */
public class BOJ2875 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int teamCount = 0;
		while (N > 0 && M > 0) {
			N -= 2;
			if (N < 0) {
				N++;
				break;
			}
			M -= 1;
			teamCount++;
		}
		
		K = K - N - M;
		while (K > 0) {
			K -= 3;
			teamCount--;
		}
		System.out.println(teamCount < 0 ? 0 : teamCount);
	}
}
