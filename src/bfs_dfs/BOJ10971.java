package bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 외판원 순회2
 * 1번부터 N번까지 번호가 매겨져 있는 도시들이 있고, 도시들 사이에는 길이 있다.
 * 길어 없을 수도 있다.
 * 외판원이 한 도시에서 출발해 N개의 도시를 모두 거쳐,
 * 다시 원래의 도시로 돌아오는 순회 여행 경로를 계획
 * 한 번 갔던 도시로는 다시 갈 수 없다.(출발도시로 돌아오는 것 제외)
 * 이런 여행 경로중 가장 적은 비용을 들이는 계획찾기
 * 각 도시간 이동에 드는 비용은 W[i][j](W[i][j] != W[j][i], 양의정수)
 * 항상 W[i][i] = 0, 도시 i에서 j로 갈 수 없으면 W[i][j] = 0
 * 
 * 입력
 * 첫째줄: 도시의 수 N(2<=N<=10)
 * 다음N개줄: 비용 행렬(1,000,000이하의 양의 정수)
 * 항상 순회할 수 있는 경우만 입력으로 주어진다.
 * 
 * 출력
 * 순회에 필요한 최소 비용 출력
 */
public class BOJ10971 {
	private static int N, ans;
	private static int[][] W;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		W = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				W[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ans = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			dfs(i, i, 0, new boolean[N], 1);
		}
		System.out.println(ans);
	}
	
	public static void dfs(int starting, int cur, int weight, boolean[] isVisit, int depth) {
		if (depth == N) {
			int w = weight;
			for (int j = 0; j < N; j++) {
				if (W[cur][j] != 0 && j == starting) {
					w += W[cur][j];
				} else if (W[cur][j] == 0 && j == starting) {
					return;
				}
			}

			if (w < ans) {
				ans = w;
			}
			return;
		}
		
		isVisit[cur] = true;
		for (int j = 0; j < N; j++) {
			if (W[cur][j] != 0 && !isVisit[j]) {
				dfs(starting, j, weight + W[cur][j], isVisit.clone(), depth + 1);
			}
		}
	}
}
