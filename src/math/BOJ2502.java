package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2502 {
	private static int cntA, cntB;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int D = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		cntA = cntB = 0;
		
		go(D);
		
		for (int A = 1; A <= 100_000; A++) {
			int val = K - cntA * A;
			if (val % cntB == 0 && val / cntB >= A) {
				System.out.println(A);
				System.out.println((val / cntB));
				break;
			}
		}
	}
	
	
	public static void go(int idx) {
		if (idx == 1) {
			cntA++;
			return;
			
		} else if (idx == 2) {
			cntB++;
			return;
		}
		
		go(idx - 1);
		go(idx - 2);
		
	}
}
