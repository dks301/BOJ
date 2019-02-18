package realization;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 텔레포트
 * 도시 수: 2 ≤ N ≤ 1,000
 * 텔레포트에 걸리는 시간: 1 ≤ T ≤ 2,000
 * 두 도시의 쌍: 1 ≤ M ≤ 1,000
 * 좌표: 0 ≤ x, y ≤ 1,000
 * A ≠ B
 * 두 도시의 좌표가 같은 경우는 없다.
 * (r1, c1)에 있는 도시에서 (r2, c2)에 있는 도시로 가는 이동 시간은 |r1 - r2| + |c1 - c2|
 * 두 도시 사이에 최소 이동시간을 출력
 */
public class BOJ16958 {
	private static final String NEW_LINE = "\n";

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		City[] c = new City[N + 1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			c[i] = new City(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
		}

		int M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int walking = walkingTime(c[u], c[v]);
			
			if (c[u].s == 1 && c[v].s == 1) {
				sb.append(walking < T ? walking : T).append(NEW_LINE);
			} else if (c[u].s == 1) {
				int closest = findClosestS(c, c[v]) + T;
				sb.append(closest < walking ? closest : walking).append(NEW_LINE);
			} else if (c[v].s == 1) {
				int closest = findClosestS(c, c[u]) + T;
				sb.append(closest < walking ? closest : walking).append(NEW_LINE);
			} else {
				int closest = findClosestS(c, c[u]) + findClosestS(c, c[v]) + T;
				sb.append(closest < walking ? closest : walking).append(NEW_LINE);
			}
		}
		System.out.print(sb);
	}
	
	public static int findClosestS(City[] c, City a) {
		int min = Integer.MAX_VALUE;
		for (int i = 1; i < c.length; i++) {
			int walking = walkingTime(a, c[i]);
			if (!c[i].equals(a) && c[i].s == 1 && min > walking) {
				min = walking;
			}
		}
		return min;
	}

	public static int walkingTime(City a, City b) {
		return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
	}

	public static class City {
		int s, x, y; // Special 1: 텔레포트 가능, 0: 불가능

		public City(int s, int x, int y) {
			this.s = s;
			this.x = x;
			this.y = y;
		}
	}
}
