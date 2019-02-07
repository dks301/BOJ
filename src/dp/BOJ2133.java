package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
 * 타일 채우기
 * 3xN 크기의 벽을 2x1, 1x2 크기의 타일로 채우는 경우의 수 출력
 */
public class BOJ2133 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] d = new int[31];
		d[0] = 1;
		for (int i = 2; i <= N; i = i + 2) {
			d[i] = 3 * d[i - 2];
			for (int j = i - 4; j >= 0; j = j - 2) {
				d[i] = d[i] + 2 * d[j];
			}
		}
		System.out.println(d[N]);
	}
}
