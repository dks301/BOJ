package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 지능형 기차
 * 기차는 역 번호 순서대로 운행한다.
 * 출발역에서 내린 사람 수와 종착역에서 탄 사람 수는 0이다.
 * 각 역에서 현재 기차에 있는 사람보다 더 많은 사람이 내리는 경우는 없다.
 * 기차의 정원은 최대 10,000명이고, 정원을 초과하여 타는 경우는 없다.
 * 기차에 사람이 가장 많을 때의 수 출력
 */
public class BOJ2455 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int total = 0;
		int max = 0;
		
		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			total -= Integer.parseInt(st.nextToken());
			if (max < total) {
				max = total;
			}
			
			total += Integer.parseInt(st.nextToken());
			if (max < total) {
				max = total;
			}
		}
		System.out.println(max);
	}
}
