package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
 * 암호코드
 * A=1, B=2, ..., Z=26이라고 한다.
 * 5000자리 이하의 숫자암호가 주어질 때, 암호를 해석할 수 있는 경우의 수 출력 
 */
public class BOJ2011 {
	private static final int MOD = 1_000_000;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] cypher = br.readLine().toCharArray();
		if (cypher[0] <= '0' || cypher[0] > '9') {
			System.out.println(0);
			System.exit(0);
		}
		int N = cypher.length;
		for (int i = 1; i < N; i++) {
			if (cypher[i - 1] < '0' || cypher[i - 1] > '9') {
				System.out.println(0);
				System.exit(0);
			}
		}
		int[] d = new int[N + 1];
		d[0] = 1;
		d[1] = 1;
		for (int i = 2; i <= N; i++) {
			int temp = Character.getNumericValue(cypher[i - 2]) * 10 + Character.getNumericValue(cypher[i - 1]);
			if (temp > 10 && temp <= 26 && temp != 20) {
				d[i] = d[i - 1] + d[i - 2];
			} else if (temp == 0 || temp == 30 || temp == 40 || temp == 50 || temp == 60 || temp == 70 || temp == 80 || temp == 90){
				System.out.println(0);
				System.exit(0);
			} else if (temp == 10 || temp == 20) {
				d[i] = d[i - 2];
			} else {
				d[i] = d[i - 1];
			}
			d[i] = d[i] % MOD;
		}
		System.out.println(d[N]);
	}
}
