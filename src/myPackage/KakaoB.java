package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class KakaoB {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] prefer = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			prefer[i] = Integer.parseInt(st.nextToken());
		}

		double var_min = Double.MAX_VALUE;
		for (int l = K; l <= N; l++) {
			for (int i = 0; i < N - (l - 1); i++) {
				double total = 0;
				double average = 0;
				for (int j = i; j < i + l; j++) {
					total += prefer[j];
				}
				average = total / l;
				
				double var = 0;
				for (int j = i; j < i + l; j++) {
					var += Math.pow(average - prefer[j], 2);
					System.out.println(var);
				}
				var = var / l;
				if (var_min > var) {
					var_min = var;
				}
			}
		}
		double std_dev = Math.sqrt(var_min);
		System.out.println(std_dev);
	}
}
