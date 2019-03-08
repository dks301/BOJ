package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
 * 최소비용 구하기
 * 도시의 개수 N(1<=N<=1,000), 버스의 개수M(1<=M<=100,000)
 * 0 <= 버스의 비용 < 100,000
 * 출발 도시에서 도착 도시까지 가는데 드는 최소 비용 출력
 */
public class BOJ1916 {
	private static final int INF = 100_000;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
	}
	
	public static class Bus {
		int x, y, w;
		
		public Bus(int x, int y, int w) {
			this.x = x;
			this.y = y;
			this.w = w;
		}
	}
}
