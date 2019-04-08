package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 스타트와 링크
 * 총 N명, N은 짝수, 2팀으로 나누어야 함
 * 번호를 1 ~ N까지 배정
 * Sij는 i번 사람과 j번 사람이 같은팀에 속했을 때, 더해지는 능력치
 * 팀의 능력치는 모든 쌍의 Sij의 합, Sij와 Sji는 다를 수도 있다
 * i번 사람과 j번 사람이 같은 팀에 속했을 때, 팀에 더해지는 능력치는 Sij + Sji
 * 두 팀의 능력치 차이의 최솟값을 출력
 * 
 * 첫째줄: N(4<=N<=20, N은짝수)
 * 둘째줄부터 N개의 줄: S, 각 줄은 N개의 수로 이루어짐, i번줄의 j번째 수는 Sij
 * Sii는 항상 0, Sij는 1보다 크거나 같고, 100보다 작거나 같은 정수
 */
public class BOJ14889 {
	private static int N;
	private static int[][] S;
	private static int total = 0;
	private static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		S = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				S[i][j] = Integer.parseInt(st.nextToken());
				total += S[i][j];
			}
		}

		combination(new int[N / 2], 0, N, N / 2, 0);
		System.out.println(min);
	}
	
	public static void combination(int[] arr, int index, int n, int r, int target) {
		if (r == 0) {
			calculation(arr);
			
		} else if (target == n) {
			return;
			
		} else {
			arr[index] = target;
			combination(arr, index + 1, n, r - 1, target + 1);
			combination(arr, index, n, r, target + 1);
		}
	}
	
	public static void calculation(int[] arr) {
		int team1 = 0;
		int team2 = 0;
		boolean[] arr2 = new boolean[N];
		
		for (int i = 0; i < arr.length; i++) {
			arr2[arr[i]] = true;
			for (int j = 0; j < arr.length; j++) {
				team1 += S[arr[i]][arr[j]];
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!arr2[i] && !arr2[j]) {
					team2 += S[i][j];
				}
			}
		}
		
		int differ = Math.abs(team1 - team2);
		if (differ < min) {
			min = differ;
		}
	}
}
