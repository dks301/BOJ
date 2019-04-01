package realization;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 날짜 계산
 * 지구 E(1<=E<=15), 태양 S(1<=S<=28), 달 M(1<=M<=19)
 * 1 1 1은 1년
 * E S M으로 표시되는 가장 빠른 연도 출력.
 */
public class BOJ1476 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int E = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int year = 1;
		
		while (!(E == 1 && S == 1 && M == 1)) {
			E = E == 1 ? 15 : E - 1;
			S = S == 1 ? 28 : S - 1;
			M = M == 1 ? 19 : M - 1;

			year++;
		}
		System.out.println(year);
	}
}
