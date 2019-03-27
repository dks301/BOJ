package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

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
	private static Gear[] g = new Gear[4];
	private static boolean[] isRotate; // (1,2), (2,3), (3,4)
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 4; i++) {
			g[i] = new Gear(br.readLine().toCharArray());
		}
		
		int K = Integer.parseInt(br.readLine());
		while (K-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken()) - 1;
			int d = Integer.parseInt(st.nextToken());
			
			isRotate = new boolean[3];
			for (int i = 0; i < 3; i++) {
				if (g[i].pole.get(2) != g[i + 1].pole.get(6)) {
					isRotate[i] = true;
				}
			}
			
			g[idx].rotate(d);
			rotateTheOthers(idx, d);
		}

		System.out.println(getScore());
	}
	
	public static int getScore() {
		int total = 0;
		for (int i = 0; i < 4; i++) {
			total += (g[i].pole.getFirst() == 1 ? Math.pow(2, i) : 0);
		}
		return total;
	}
	
	public static void rotateTheOthers(int idx, int d) {
		int opp = (d == 1 ? -1 : 1);
		
		switch (idx) {
		case 0:
			if (isRotate[0]) {
				g[1].rotate(opp);
				if (isRotate[1]) {
					g[2].rotate(d);
					if (isRotate[2]) {
						g[3].rotate(opp);
					}
				}
			}
			break;
			
		case 1:
			if (isRotate[0]) {
				g[0].rotate(opp);
			}
			if (isRotate[1]) {
				g[2].rotate(opp);
				if (isRotate[2]) {
					g[3].rotate(d);
				}
			}
			break;
			
		case 2:
			if (isRotate[2]) {
				g[3].rotate(opp);
			}
			if (isRotate[1]) {
				g[1].rotate(opp);
				if (isRotate[0]) {
					g[0].rotate(d);
				}
			}
			break;
			
		case 3:
			if (isRotate[2]) {
				g[2].rotate(opp);
				if (isRotate[1]) {
					g[1].rotate(d);
					if (isRotate[0]) {
						g[0].rotate(opp);
					}
				}
			}
			break;
		}
	}
	
	public static class Gear {
		LinkedList<Integer> pole = new LinkedList<>(); //idx0: 12시,...,2: 3시,...,6: 9시
		
		public Gear(char[] info) {
			for (int i = 0; i < 8; i++) {
				pole.add(Character.getNumericValue(info[i]));
			}
		}
		
		public void rotate(int d) {
			if (d == 1) { // 시계 방향
				pole.addFirst(pole.removeLast());
			} else { // d == -1: 반시계 방향
				pole.addLast(pole.removeFirst());
			}
		}
	}
}
