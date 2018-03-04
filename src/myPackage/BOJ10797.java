package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10797 {
	private static final String SPACE = " ";
	private static final String ENTER = " ";
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int day = Integer.parseInt(br.readLine());
		int carNum;
		StringTokenizer st = new StringTokenizer(br.readLine(), SPACE);
		int count = 0;
		for (int i = 0; i < 5; i++) {
			carNum = Integer.parseInt(st.nextToken());
			if (carNum == day)
				count++;
		}
		System.out.println(count);
	}
}
