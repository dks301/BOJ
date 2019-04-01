package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
 * !밀비 급일
 * END가 들어오면 입력 끝
 * 나머지는 뒤집어서 출력
 */
public class BOJ11365 {
	private static final String NEW_LINE = "\n";
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		ArrayList<StringBuilder> al = new ArrayList<>();
		while (true) {
			String input = br.readLine();
			if (input.equals("END")) {
				break;
			}
			
			StringBuilder sb = new StringBuilder();
			al.add(sb.append(input).reverse().append(NEW_LINE));
		}
		
		StringBuilder output = new StringBuilder();
		for (StringBuilder next : al) {
			output.append(next);
		}
		System.out.print(output);
	}
}
