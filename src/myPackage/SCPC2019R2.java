package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SCPC2019R2 {
	private static final String CASE = "Case #";
	private static final String NEW_LINE = "\n";
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
	
		
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			sb.append(CASE).append(t).append(NEW_LINE);
			StringTokenizer st = new StringTokenizer(br.readLine());
			double R = Double.parseDouble(st.nextToken());
			double S = Double.parseDouble(st.nextToken());
			double E = Double.parseDouble(st.nextToken());
			int N = Integer.parseInt(br.readLine());
			
			double ans = E - S;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				double l = Double.parseDouble(st.nextToken());
				double r = Double.parseDouble(st.nextToken());
				double h = Double.parseDouble(st.nextToken());
				
				double temp = 0;
				if (h < R) {
					 temp = 2 * (R * Math.acos((R - h) / R) - Math.sqrt(Math.pow(R,  2) - Math.pow(R - h, 2)));
				} else {
					temp = Math.PI * R + 2 * (h - (2 * R));
				}
				
				ans += temp;
			}
			sb.append(ans).append(NEW_LINE);
		}
		System.out.println(sb);
	}
}
