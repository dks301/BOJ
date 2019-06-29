package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
 * 종이의 개수
 * NxN크기의 행렬 종이, 각 칸에는 -1, 0, 1 세값중 하나가 저장
 * 1. 만약 종이가 모두 같은 수로 되어 있다면 이 종이를 그대로 사용
 * 2. 1이 아닌 경우에는 종이를 같은 크기의 9개의 종이로 자르고, 각각의 잘린 종이에 대해서 1을 반복
 * 
 * 입력
 * 첫째줄: N(1<=N<=3^7, N은 3^k꼴)
 * 다음 N개줄: N개의 정수로 행렬이 주어진다
 * 
 * 출력
 * 첫째줄: -1로만 채워진 종이의 개수
 * 둘째줄: 0으로만 채워진 종이의 개수
 * 셋째줄: 1로만 채워진 종이의 개수
 */
public class BOJ1780 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
	}
}
