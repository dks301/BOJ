package binarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 사다리
 * 빌딩 사이에 두 개의 사다리가 있다
 * 길이가 x인 사다리는 오른쪽 빌딩의 아래를 빋침대로 왼쪽빌딩에 기대져있다
 * 길이가 y인 사다리는 왼쪽 빌딩의 아래를 받침대로 오른쪽빌딩에 기대져있다.
 * 두사다리는 땅에서부터 높이가 c인 지점에서 서로 교차
 * 
 * 입력
 * 첫째줄: x,y,c(양의 실수 세 개, 소수점 여섯째자리까지 주어질 수 있다)
 * 
 * 출력
 * 두 빌딩 사이에 너비가 되는 수치를 출력(절대/상대 오차는 10^-3까지 허용)
 */
public class BOJ2022 {
	private static double x, y, c;
	private static final double ERROR = 0.0001;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		x = Double.parseDouble(st.nextToken());
		y = Double.parseDouble(st.nextToken());
		c = Double.parseDouble(st.nextToken());

		double left = 0, right = Math.min(x, y);
		while (Math.abs(right - left) > ERROR)  {
			double mid = (left + right) / 2.0;
			double d = mid;
			double h1 = Math.sqrt(x * x - d * d);
			double h2 = Math.sqrt(y * y - d * d);
			double h = (h1 * h2) / (h1 + h2);
			
			if (h > c) {
				left = mid;
			} else {
				right = mid;
			}
		}
		System.out.println(left);
	}
}
