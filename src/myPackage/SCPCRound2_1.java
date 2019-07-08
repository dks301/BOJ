package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SCPCRound2_1 {
	private static final String CASE = "Case #";
	private static final char NEW_LINE = '\n';
	private static final char SPACE = ' ';
	
	private static int A, B;
	private static boolean[] isNotPrime;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		isNotPrime = new boolean[30000];
		isNotPrime[0] = true;
		isNotPrime[1] = true;
		for (int i = 2; i < 30000; i++) {
			if (isNotPrime[i] == false) {
				for (int j = i * i; j < 30000; j += i) {
					isNotPrime[j] = true;
				}
			}
		}
		
		for (int t = 1; t <= T; t++) {
			StringBuilder sb = new StringBuilder();
			sb.append(CASE).append(t).append(NEW_LINE);
			StringTokenizer st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			if (!isNotPrime[A] && !isNotPrime[B]) {
				int Ascore = delete(A, 1);
				int Bscore = delete(B, 1);
				if (Ascore > Bscore) {
					sb.append(1);
				} else if (Ascore < Bscore) {
					sb.append(2);
				} else {
					sb.append(3);
				}
			} else if (!isNotPrime[A] && isNotPrime[B]) {
				sb.append(1);
			} else if (isNotPrime[A] && !isNotPrime[B]) {
				sb.append(2);
			} else {
				sb.append(3);
			}
			System.out.println(sb);
		}
	}
	
	public static int delete(int num, int score) {
		int[] digit = new int[5];
		int unit = 10000;
		for (int i = 0; i < 5; i++) {
			digit[i] = num / unit;
			num %= unit;
			unit /= 10;
		}
		
		int max = score;
		for (int i = 4; i >= 0; i--) {
			if (digit[i] != 0) {
				int val = 0;
				unit = 1;
				for (int j = 4; j >= 0; j--) {
					if (i == j) {
						continue;
					}
					if (digit[j] != 0) {
						val += (digit[j] * unit);
						unit *= 10;
					}
				}
				if (!isNotPrime[val]) {
					int temp = delete(val, score + 1);
					if (temp > max) {
						max = temp;
					}
				}
			}
		}
		return max;
	}
}
