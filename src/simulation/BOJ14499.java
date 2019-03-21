package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
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
	public static int N, M;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		Dice d = new Dice(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		int K = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (K-- > 0) {
			int cmd = Integer.parseInt(st.nextToken());
			
			if (d.move(cmd)) {
				if (map[d.x][d.y] == 0) {
					map[d.x][d.y] = d.side[0];
				} else {
					d.side[0] = map[d.x][d.y];
					map[d.x][d.y] = 0;
				}

				sb.append(d.side[5]).append(NEW_LINE);
			}
		}
		System.out.print(sb);
	}
	
	public static class Dice {
		int[] side = {0, 0, 0, 0, 0, 0}; // 밑, 북, 동, 서, 남, 윗
		int x, y;
		
		public Dice(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public boolean move(int cmd) {
			int temp;

			switch (cmd) { // 1:동, 2:서, 3:북, 4:남
			case 1:
				if (y == M - 1) {
					return false;
				}
				y++;
				
				temp = side[0];
				side[0] = side[2];
				side[2] = side[5];
				side[5] = side[3];
				side[3] = temp;
				break;
				
			case 2:
				if (y == 0) {
					return false;
				}
				y--;
				
				temp = side[0];
				side[0] = side[3];
				side[3] = side[5];
				side[5] = side[2];
				side[2] = temp;
				break;
				
			case 3:
				if (x == 0) {
					return false;
				}
				x--;
				
				temp = side[0];
				side[0] = side[1];
				side[1] = side[5];
				side[5] = side[4];
				side[4] = temp;
				break;
				
			case 4:
				if (x == N - 1) {
					return false;
				}
				x++;
				
				temp = side[0];
				side[0] = side[4];
				side[4] = side[5];
				side[5] = side[1];
				side[1] = temp;
				break;
			}
			
			return true;
		}
	}
}
