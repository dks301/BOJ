package realization;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2490 {
	private static String SPACE = " ";
	private static String ENTER = "\n";
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < 3; i++) {
			int check = 0;
			StringTokenizer st = new StringTokenizer(br.readLine(), SPACE);
			 
			for (int j = 0; j < 4; j++) {
				if (Integer.parseInt(st.nextToken()) == 0)
					check++;
			}
			
			switch (check) {
			case 0:
				sb.append("E").append(ENTER);
				break;
			case 1:
				sb.append("A").append(ENTER);
				break;
			case 2:
				sb.append("B").append(ENTER);
				break;
			case 3:
				sb.append("C").append(ENTER);
				break;
			case 4:
				sb.append("D").append(ENTER);
				break;
			}
		}
		System.out.print(sb.toString());
	}
}
