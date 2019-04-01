package realization;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * A+B-5
 * 두 정수 A와 B를 입력받은 다음, A+B 출력
 */
public class BOJ10952 {
	private static final String NEW_LINE = "\n";
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		int sum = -1;
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			sum = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
			
			if (sum != 0) {
				sb.append(sum).append(NEW_LINE);
			} else {
				break;
			}
		}
		System.out.print(sb);
	}
}
