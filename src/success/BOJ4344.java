package success;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

public class BOJ4344 {
	private static final String NEW_LINE = "\n";
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int C = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < C; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[] students = new int[N];
			double total = 0;
			for (int j = 0; j < N; j++) {
				students[j] = Integer.parseInt(st.nextToken());
				total += students[j];
			}
			
			double average = total / N;
			total = 0;
			for (int j = 0; j < N; j++) {
				if (students[j] > average)
					total++;
			}
			double percentage = total / N * 100;
			DecimalFormat df = new DecimalFormat("0.000");
			sb.append(df.format(percentage) + "%").append(NEW_LINE);
		}
		System.out.println(sb.toString());
	}
}
