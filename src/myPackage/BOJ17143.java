package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
 * 낚시왕
 * 낚시왕은 가장 처음에 1번 열의 한 칸 왼쪽에 있다.
 * 다음은 1초동안 순서대로 일어나는 일이다.
 * 1. 낚시왕이 오른쪽으로 한 칸 이동한다.
 * 2. 낚시왕이 있는 열에 있는 상어 중에서 가장 땅과 가까운 상어를 잡는다.
 *    상어를 잡으면 격차판에서 잡은 상어가 사라진다.
 * 3. 상어가 이동한다.
 * 낚시왕은 가장 오른쪽 열의 오른쪽 칸에 이동하면 이동을 멈춘다.
 * 상어는 입력으로 주어진 속도로 이동하고, 속도의 단위는 칸/초 이다.
 * 상어가 이동하려고 하는 칸이 경계인 경우에는 방향을 반대로 바궈서 속력을 유지한체로 이동.
 * 상어가 한 칸에 두 마리 이상 있을 수 있다. 이때는 가장 큰 상어가 나머지 상어를 모두 잡아먹는다.
 * 낚시왕이 잡은 상어 크기의 합을 출력.
 * 
 * 첫째줄: R,C,M(2<=R,C<=100, 0<=M<=R*C)
 * 둘쨰줄~M개의줄: r,c,s,d,z (상어의 위치(r,c), s 속력, d 이동방향, z크기
 * d: 북-1, 남-2, 동-3, 서-4
 */
public class BOJ17143 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
	}
}
