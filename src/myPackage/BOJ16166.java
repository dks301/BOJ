package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 서울의 지하철
 * 호선의 갯수 N(1<=N<=10), 각 호선의 역 갯수K(1<=K<=10)
 * 각 역의 번호는 모두 다르며 int범위내이다.
 * 시작역인 서울역의 번호는 0이다.
 * 입력의 마지막 줄에는 도착역의 번호가 주어진다.
 * 서울역부터 도착역까지 최소환승 수를 출력. 도착이 불가능 한 경우 -1 출력.
 */
public class BOJ16166 {
	private static ArrayList<Integer>[] transfer;
	private static ArrayList<Integer> check;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] subway = new int[N + 1][10];
		transfer = new ArrayList[N + 1]; // transfer[1] = 1호선에서 환승할 수 있는 호선들
		check = new ArrayList<>();
		HashMap<Integer, Integer> hm = new HashMap<>();
		
		ArrayList<Integer> startLine = new ArrayList<>(); // 서울역이 있는 호선들
		for (int i = 1; i <= N; i++) {
			transfer[i] = new ArrayList<>();
			Arrays.fill(subway[i], -1);
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			for (int j = 0; j < K; j++) {
				subway[i][j] = Integer.parseInt(st.nextToken());
				if (hm.containsKey(subway[i][j])) {
					hm.put(subway[i][j], hm.get(subway[i][j]) + 1);
				} else {
					hm.put(subway[i][j], i);
				}
				if (subway[i][j] == 0) {
					startLine.add(i);
				}
			}
		}
		int dest = Integer.parseInt(br.readLine());
		ArrayList<Integer> destLine = new ArrayList<>(); //목적지 역이 있는 호선들
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < 10; j++) {
				if (subway[i][j] == dest) {
					destLine.add(i);
				}
			}
		}
	}
	
	public static void bfs(int[][] subway, int x) {
		Queue<Integer> q = new LinkedList<>();
		q.add(x);
		check.add(x);
//		ArrayList<Integer> currentLine = new ArrayList<>();
//		for (int i = 1; i < subway.length; i++) {
//			for (int j = 0; j < 10; j++) {
//				if (subway[i][j] == x) {
//					currentLine.add(i);
//				}
//			}
//		}
		
		while(!q.isEmpty()) {
			int y = q.remove();
			for (int i = 0; i < 10; i++) {
				
			}
		}
	}
	
	public static class Station {
		int idx, line;
		int[] transfer = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
		
		public Station(int idx, int line) {
			this.idx = idx;
			this.line = line;
		}
	}
}
