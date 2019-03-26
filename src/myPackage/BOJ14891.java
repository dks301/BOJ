package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

/*
 * 톱니바퀴
 * 4개의 톱니바퀴가 있고, 톱니바퀴의 정보가 주어진다(N극:0, S극:1)
 * 톱니바퀴는 시계방향(1), 반시계방향(-1) 두방향으로 한 칸씩 회전이 가능하다
 * 회전하는 톱니바퀴와 맞닿은 톱니바퀴의 극이 같은 톱니바퀴는 반대방향으로 회전한다
 * 1번 톱니바퀴의 12시 방향이 N극이면 0점, S극이면 1점
 * 2: 0, 2
 * 3: 0, 4
 * 4: 0, 8점
 * K번(1<=K<=100) 회전시킨 이후에 네 톱니바퀴의 점수의 합을 출력
 */
public class BOJ14891 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
	}
	
	public static class Gear {
		LinkedList<Integer> pole = new LinkedList<>(); //idx0: 12시,...,2: 3시,...,6: 9시
		
		public Gear(char[] info) {
			for (int i = 0; i < 8; i++) {
				pole.add(Character.getNumericValue(info[i]));
			}
		}
		
		public void rightTurn() {
			
		}
		
		public void leftTurn() {
			
		}
	}
}
