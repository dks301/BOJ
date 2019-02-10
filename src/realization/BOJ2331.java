package realization;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
/*
 * 반복수열
 * D[1] = A(1<=A<=9,999)
 * D[n] = D[n-1]의 각 자리의 숫자를 P(1<=P<=5)번 곱한 수들의 합
 * 반복되는 부분을 제외한 수열의 길이 출력
 */
public class BOJ2331 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		HashMap<Integer, Integer> hm = new HashMap<>();
		int idx = 1;
		while (!hm.containsValue(A)) {
			hm.put(idx, A);
			idx++;
			int temp = A;
			A = 0;
			while (temp > 0) {
				A += Math.pow(temp % 10, P);
				temp /= 10;
			}
			
		}
		int ans = 0;
		for (int i = 1; i <= idx; i++) {
			if (hm.get(i) == A) {
				break;
			}
			ans++;
		}
		System.out.println(ans);
	}
}
