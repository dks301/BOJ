package bfs_dfs;

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
	private static Line[] line;
	private static boolean[] check;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		line = new Line[11];
		check = new boolean[11];
		for (int i = 1; i <= N; i++) {
			line[i] = new Line(i);

			StringTokenizer st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			for (int j = 0; j < K; j++) {
				line[i].setStation(Integer.parseInt(st.nextToken()));
			}
		}
		int dest = Integer.parseInt(br.readLine());
		
		bfs(N, dest);
	}

	public static void bfs(int N, int dest) {
		Queue<Line> q = new LinkedList<>();
		int[] d = new int[11];
		boolean isTrue = false;
		
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < line[i].cnt; j++) {
				if (line[i].station[j] == 0) {
					q.add(line[i]);
					check[i] = true;
					d[i] = 0;
				}
			}
		}

		while (!q.isEmpty()) {
			Line y = q.remove();

			for (int i = 0; i < y.cnt; i++) {
				if (y.station[i] == dest) {
					System.out.println(d[y.idx]);
					isTrue = true;
					break;
				}
			}
			for (int i = 0; i < y.cnt; i++) {
				for (int j = 1; j <= N; j++) {
					if (!line[j].equals(y)) {
						for (int k = 0; k < line[j].cnt; k++) {
							if (y.station[i] == line[j].station[k] && check[j] == false) {
								q.add(line[j]);
								check[j] = true;
								d[j] = d[y.idx] + 1;
								
							}
						}
					}
				}
			}
			if (isTrue == true) {
				break;
			}
		}
		if (isTrue == false) {
			System.out.println(-1);
		}
	}

	public static class Line {
		int idx;
		int[] station = new int[10];
		int cnt = 0;

		public Line(int idx) {
			this.idx = idx;
			Arrays.fill(station, -1);
		}

		public void setStation(int idx) {
			station[cnt++] = idx;
		}
	}
}
