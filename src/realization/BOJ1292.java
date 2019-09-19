package realization;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1292 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int val = 1;
		int cnt = 1;
		int sum = 0;
		for (int j = 1; j <= 1000; j++) {
			int temp = val;
			if (j >= A) {
				sum += temp;
			}
			if (j == B) {
				break;
			}
			
			if (cnt++ == val) {
				cnt = 1;
				val++;
			}
		}

		
		System.out.println(sum);
	}
}
