package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
 * 주사위 굴리기
 * 이동한 칸이 0 -> 주사위 바닥면에 쓰여있는 수가 칸에 복사
 * 이동한 칸이 0x -> 칸에 쓰여 있는 수가 주사위 바닥면에 복사, 칸 0
 * 주사위를 이동시키려고 하는 경우 명령,출력무시
 * 주사위가 이동할 때마다 상단에 쓰여 있는 값 출력 
 */
public class BOJ14499 {
	public static final String NEW_LINE = "\n";
	
	public static int[][] map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
	}
	
	public static class Dice {
		int[] side = {0, 0, 0, 0, 0, 0};
	}
}
