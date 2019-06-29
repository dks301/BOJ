package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SCPC2019R4 {
	private static final String CASE = "Case #";
	private static final String NEW_LINE = "\n";
	
	private static final int INF = 1_000_001;
	private static int[] d = new int[INF];
	private static int[] d2 = new int[INF];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 2; i < INF; i++) {
			if (i % 2 == 0) {
				d[i] = d[i / 2] + 1;
			} else {
				d[i] = d[(i + 1) / 2] + 2;
			}
		}
		
		for(int i = 2; i < INF; i++){
			d2[i] = d2[i - 1] + d[i];
		}
		
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			sb.append(CASE).append(t).append(NEW_LINE);
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N1 = Integer.parseInt(st.nextToken());
			int N2 = Integer.parseInt(st.nextToken());
			
			int sum = d2[N2] - d2[N1 - 1];
			sb.append(sum).append(NEW_LINE);
		}
		System.out.println(sb);
	}
}
