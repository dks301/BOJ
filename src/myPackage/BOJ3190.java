package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
 * 뱀
 * N*N 보드위에서 게임 진행, 보드의 상하좌우의 끝에 벽이 있다.
 * 게임이 시작할 때 뱀은 맨위 맨좌측 길이 1로 시작, 뱀은 처음에 오른쪽으로 향한다.
 * 먼저 뱀은 몸길이를 늘려 머리를 다음칸에 위치시킨다.
 * 만약 이동한 칸에 사과가 있다면, 그 칸에 있던 사과가 없어지고 꼬리는 움직이지 않는다.
 * 만약 이동한 칸에 사과가 없다면, 몸길이를 줄여서 꼬리가 위치한 칸을 비워준다. 즉, 몸길이는 변화x
 * 사과의 위치와 뱀의 이동경로가 주어질때 이 게임이 몇 초에 끝나는지 출력
 *
 * 보드의 크기(2<=N<=100), 사과의 개수(0<=K<=100), 뱀의 방향 변환 횟수(1<=L<=100)
 * (1,1)에는 사과가 없다. X초가 끝난 뒤에 왼쪽('L') 오른쪽('D') 90도 회전
 * X는 10,000 이하의 양의 정수, 방향 전환 정보는 X가 증가하는 순으로 주어진다.
 */
public class BOJ3190 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
	}
}
