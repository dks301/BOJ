package divideNconquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 하노이 탑 이동 순서
 * 세 개의 장대가 있고 첫 번째 장대에는 반경이 서로 다른 n개의 원판이 쌓여있다.
 * 각 원판은 반경이 큰 순서대로 쌓여있다.
 * 1. 한 번에 한 개의 원판만을 다른 탑으로 옮길 수 있다.
 * 2. 쌓아 놓은 원판은 항상 위의 것이 아래의 것보다 작아야 한다.
 * 
 * 입력
 * 첫째줄: 원판의 개수N(1<=N<=20)
 * 
 * 출력
 * 첫째줄: 최소로 옮긴 횟수 K
 * 두번째~K개줄: 수행과정을 A B 형태로(A번째탑의 가장 위 원판 -> B번째 탑의 가장 위로 옮기기)
 */
public class BOJ11729 {
	private static final String SPACE = " ";
	private static final String NEW_LINE = "\n";
	
	private static int K = 0;
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		move(1, 3, N);
		System.out.println(K);
		System.out.println(sb);
	}

	public static void move(int x, int y, int N) {
		if (N == 0) {
			return;
		}
		
		move(x, 6 - x - y, N - 1);
		sb.append(x).append(SPACE).append(y).append(NEW_LINE);
		K++;
		move(6 - x - y, y, N - 1);
	}
}
