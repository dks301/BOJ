package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 팩토리얼 0의 갯수
 * N!의 뒤에서부터 처음 0이 아닌 숫자가 나올 때까지 0의 갯수 출력
 */
public class BOJ1676 {
	private static final int TWO = 2;
	private static final int FIVE = 5;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int cntTwo = 0;
		int cntFive = 0;
		for (int i = 1; i <= N; i++) {
			int temp = i;
			while (temp % TWO == 0) {
				temp /= TWO;
				cntTwo++;
			}
			while (temp % FIVE == 0) {
				temp /= FIVE;
				cntFive++;
			}
		}
		System.out.println(Math.min(cntTwo, cntFive));
	}
}
