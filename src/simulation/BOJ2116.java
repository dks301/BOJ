package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/*
 * 주사위 쌓기
 * 서로 붙어있는 두 개의 주사위의 붙어있는 면의 숫자가 같아야 한다.
 * 주사위 숫자는 1~6, 마주 보는 면의 합이 7x
 * 첫번째 주사위는 마음대로 놓을 수 있다.
 * 쌓고 난 후에 위아래를 고정한 사각 기둥을 회전시킬 수 있다.
 * 한 옆면의 숫자의 합의 최댓값 출력. 
 */
public class BOJ2116 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Dice[] d = new Dice[N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());			
			d[i] = new Dice(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		int max = 0;
		for (int i = 1; i <= 6; i++) {
			int total = 0;
			int bottom = d[0].getTop(i);
			total += d[0].getMax();
			
			for (int j = 1; j < N; j++) {
				bottom = d[j].getTop(bottom);
				total += d[j].getMax();
			}
			
			if (max < total) {
				max = total;
			}
		}
		
		System.out.println(max);
	}
	
	public static class Dice {
		int[] val = new int[6]; // 순서대로 a, b, c, d, e, f
		int bottomIdx, topIdx;
		
		public Dice(int a, int b, int c, int d, int e, int f) {
			val[0] = a;
			val[1] = b;
			val[2] = c;
			val[3] = d;
			val[4] = e;
			val[5] = f;
		}
		
		public int getMax() {
			int max = 0;
			for (int i = 0; i < 6; i++) {
				if (i == bottomIdx || i == topIdx) {
					continue;
				}
				if (max < val[i]) {
					max = val[i];
				}
			}
			return max;
		}
		
		public int getTop(int bottom) {
			for (int i = 0; i < 6; i++) {
				if (val[i] == bottom) {
					bottomIdx = i;
				}
			}
			
			int top = -1;
			switch (bottomIdx) {
			case 0:
				top = val[5];
				topIdx = 5;
				break;
				
			case 1:
				top = val[3];
				topIdx = 3;
				break;
				
			case 2:
				top = val[4];
				topIdx = 4;
				break;
				
			case 3:
				top = val[1];
				topIdx = 1;
				break;
				
			case 4:
				top = val[2];
				topIdx = 2;
				break;
				
			case 5:
				top = val[0];
				topIdx = 0;
				break;
			}
			
			return top;
		}
	}
}
