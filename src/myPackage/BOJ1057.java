package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * 토너먼트
 * 라운드의 참가자가 홀수명이라면, 마지막 번호를 가진 사람은 부전승
 * 다음 라운드에서는 stable하게 다시 1번부터 번호를 매긴다
 * 한 명만 남을 때까지 라운드를 계속한다
 * 김지민과 임한수가 몇라운드에서 만나는지 출력
 * 김지민과 임한수는 서로 대결하기 전까지 항상 이긴다
 * 참가자의 수 N(1<=N<=100,000)
 */
public class BOJ1057 {
	private static int N;
	private static int K;
	private static int L;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		int round = 1;
		while (N != 1) {
			
		}
	}
	
	public static boolean vs(Player[] p) {
		LinkedList<Integer> al = new LinkedList<>();
		for (int i = 1; i <= p.length - 1; i += 2) {
			al.addLast(arg0);
		}
	}
}
