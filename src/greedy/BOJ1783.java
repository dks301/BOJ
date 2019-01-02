package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ1783 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] NM = br.readLine().split(" ");
		int sero = Integer.parseInt(NM[0]);
		int garo = Integer.parseInt(NM[1]);
		int total = 1;
		
		if (sero >= 3 && garo >= 7) {
			total = 5;
			for (int i = 7; i < garo; i++)
				total ++;
		}
		else { // 세로 < 3 || 가로 < 7
			if (sero == 2) {
				if (garo < 3) {}
				else if (garo < 5) {total = 2;}
				else if (garo < 7) {total = 3;}
				else {total = 4;}
			}
			else if (sero == 1) {}
			else { // 세로 >= 3 && 가로 < 7
				if (garo < 2) {}
				else if (garo < 3) {total = 2;}
				else if (garo < 4) {total = 3;}
				else {total = 4;}
			}
		}
		System.out.println(total);
	}
}
