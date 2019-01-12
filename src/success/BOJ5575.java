package success;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ5575 {
	private static final String SPACE = " ";
	private static final String ENTER = "\n";
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] time = new int[6];
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < 3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), SPACE);
			for (int j = 0; j < 6; j++) {
				time[j] = Integer.parseInt(st.nextToken());
			}
			
			int h = 0, m = 0, s = 0;
			
			s = time[5] - time[2];
			m = time[4] - time[1];
			h = time[3] - time[0];
			
			if (s < 0) {
				s += 60;
				m -= 1;
			}
			if (m < 0) {
				m += 60;
				h -= 1;
			}
			sb.append(h).append(SPACE).append(m).append(SPACE).append(s).append(ENTER);
		}
		br.close();
		
		System.out.print(sb.toString());
	}
}
