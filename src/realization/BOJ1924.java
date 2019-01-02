package realization;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1924 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		//index: 0 = 1월, 1 = 2월, ... 11 = 12월
		int numOfDays[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		int days = 0;
		for (int i = 0; i < x - 1; i++) {
			days += numOfDays[i];
		}
		
		days = days + y;
		switch(days % 7) {
		case 0://일
			System.out.println("SUN");
			break;
		case 1://월
			System.out.println("MON");
			break;
		case 2://화
			System.out.println("TUE");
			break;
		case 3://수
			System.out.println("WED");
			break;
		case 4://목
			System.out.println("THU");
			break;
		case 5://금
			System.out.println("FRI");
			break;
		case 6://토
			System.out.println("SAT");
			break;
		}
	}
}
