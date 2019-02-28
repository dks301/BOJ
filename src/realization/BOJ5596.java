package realization;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 시험 점수
 * 민국이의 4과목, 만세의 4과목 점수 중 큰 것 출력
 */
public class BOJ5596 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int S = 0;
		for (int i = 0; i < 4; i++) {
			S += Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		int T = 0;
		for (int i = 0; i < 4; i++) {
			T += Integer.parseInt(st.nextToken());
		}
		
		System.out.println(S < T ? T : S);
	}
}
