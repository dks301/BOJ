package success;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10250 {
	private static final String NEW_LINE = "\n";
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			double H = Double.parseDouble(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			double N = Double.parseDouble(st.nextToken());
			
			int floor = (int)(N % H);
			if (floor == 0)
				floor = (int)H;
			int roomNum = (int)Math.ceil(N / H);
			sb.append(floor).append(toTwoDigit(roomNum)).append(NEW_LINE);
		}
		System.out.println(sb.toString());
	}
	
	private static String toTwoDigit(int roomNum) {
		return roomNum < 10 ? "0" + roomNum : String.valueOf(roomNum);
	}
}
