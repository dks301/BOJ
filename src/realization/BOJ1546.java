package success;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1546 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		double[] newScore = new double[N];
		for (int i = 0; i < N; i++) {
			newScore[i] = Double.parseDouble(st.nextToken());
			if (M < newScore[i])
				M = (int)newScore[i];
		}
		double total = 0;
		for (int i = 0; i < N; i++) {
			newScore[i] = newScore[i] / M * 100;
			total += newScore[i];
		}
		double average = total / N;
		System.out.println(average);
	}
}
