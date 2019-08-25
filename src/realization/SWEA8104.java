package realization;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA8104 {
	private static final char NUMBER = '#';
	private static final char SPACE = ' ';
	private static final char NEW_LINE = '\n';
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			sb.append(NUMBER).append(t).append(SPACE);
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int[] rank = new int[(N * K) + 1];
			for (int i = 1; i <= N * K; i++) {
				rank[i] = i;
			}
			
			int[] group = new int[K + 1];
			int cnt = 1;
			boolean isOdd = false;
			for (int i = 1; i <= N * K; i++) {
				if (isOdd) {
					group[cnt--] += rank[i];
					if (cnt < 1) {
						isOdd = false;
						cnt = 1;
					}
					
				} else {
					group[cnt++] += rank[i];
					if (cnt > K) {
						isOdd = true;
						cnt = K;
					}
					
				}
			}
			
			for (int i = 1; i <= K; i++) {
				sb.append(group[i]).append(SPACE);
			}
			
			sb.append(NEW_LINE);
		}
		System.out.println(sb);
	}
}
