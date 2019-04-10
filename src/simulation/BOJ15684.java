package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * 사다리 조작
 * N개의 세로선과 M개의 가로선, 가로선을 놓을 수 있는 위치의 H개
 * i번 세로선의 결과가 i번이 나올 수 있도록 추가해야하는 가로선 개수의 최솟값 출력
 * 
 * 첫째줄: 2<=N<=10, 0<=M<=(N-1)*H, 1<=H<=30
 * 둘째줄~M개의줄: 가로선의 정보 a, b(1<=a<=H, 1<=b<=N-1): b번 세로선과 b+1번세로선을 a번 점선 위치에 연결
 * 가장 위에 있는 점선의 번호는 1번, 세로선은 가장 왼쪽이 1번
 * 정답이 3보다 큰 값이거나 불가능하면 -1출력
 */
public class BOJ15684 {
	private static int N, H, M;
	private static boolean result = false;
	private static boolean[][] ladder;
	private static ArrayList<Line> al = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		ladder = new boolean[H + 1][N + 1];

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			ladder[a][b] = true;
		}

		if (M == 0 || start(ladder)) {
			System.out.println(0);
			
		} else {
			for (int i = 1; i <= H; i++) {
				for (int j = 1; j <= N - 1; j++) {
					if (!ladder[i][j]) {
						al.add(new Line(i, j));
					}
				}
			}
			
			for (int i = 1; i <= 3; i++) {
				combination(new int[i], 0, al.size(), i, 0);	
				if (result) {
					System.out.println(i);
					break;
				}
			}
			
			if(!result) {
				System.out.println(-1);
			}
		}
	}

	public static boolean addLine(int[] arr) {
		boolean[][] newLadder = deepCopy();
		
		for (int i = 0; i < arr.length; i++) {
			Line l = al.get(arr[i]);
			newLadder[l.x][l.y] = true;
		}
		
		return start(newLadder);
	}
	
	public static boolean[][] deepCopy() {
		boolean[][] temp = new boolean[H + 1][N + 1];
		for (int i = 0; i < H + 1; i++) {
			System.arraycopy(ladder[i], 0, temp[i], 0, N + 1);
		}
		
		return temp;
	}
	
	public static void combination(int[] arr, int index, int n, int r, int target) {
		if (r == 0) {
			if (addLine(arr)) {
				result = true;
			}
			
		} else if (target == n) {
			return;
			
		} else {
			arr[index] = target;
			combination(arr, index + 1, n, r - 1, target + 1);
			combination(arr, index, n, r, target + 1);
		}
	}
	
	public static boolean start(boolean[][] ladder) {
		int p = 0;
		for (int j = 1; j <= N; j++) {
			p = j;
			for (int i = 1; i <= H; i++) {
				if (ladder[i][p]) {
					p++;
				} else if (ladder[i][p - 1]) {
					p--;
				}
			}
			if (j != p) {
				return false;
			}
		}
		return true;
	}
	
	public static class Line {
		int x, y;
		
		public Line(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
