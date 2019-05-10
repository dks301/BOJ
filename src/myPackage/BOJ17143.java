package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;
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
	private static int R, C, M;
	private static int manIdx = -1;
	private static int total = 0;
	private static boolean[][] map;
	private static LinkedList<Shark> ll;
	private static LinkedList<Shark> ll2;
	
	private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
	private static final int ROW = 0;
	private static final int COL = 1;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new boolean[R + 1][C + 1];
		ll = new LinkedList<>();
		ll2 = new LinkedList<>();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r][c] = true;
			ll.add(new Shark(r, c, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		for (int i = 0; i < C + 1; i++) {
			fishing();
			map = new boolean[R + 1][C + 1];
			Iterator<Shark> it = ll.iterator();
			while (it.hasNext()) {
				Shark s = it.next();
				s.move();
				if (map[s.r][s.c]) {
					
				}
				map[s.r][s.c] = true;
				
			}
		}
		
		System.out.println(total);
	}
	
	public static void fishing() {
		manIdx++;
		for (int i = 0; i < R; i++) {
			if (map[i][manIdx]) {
				Iterator<Shark> it = ll.iterator();
				while (it.hasNext()) {
					Shark s = it.next();
					if (s.r == i && s.c == manIdx) {
						ll.remove(s);
						total += s.z;
						break;
					}
				}
				break;
			}
		}
	}
	
	public static class Shark {
		int r, c, s, d, z;
		boolean isDie = false;
		// 위치(r,c), 속력(s), 이동방향(d), 크기(z)
		// 1<=r<=R, 1<=c<=C, 0<=s<=1,000, 1<=d<=4, 1<=z<=10,000
		
		public Shark(int r, int c, int s, int d, int z) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
		
		public void move() {
			for (int i = 0; i < s; i++) {
				int nextRow = r + DIRECTIONS[d - 1][ROW];
				int nextCol = c + DIRECTIONS[d - 1][COL];
				if (nextRow < 0) {
					d = 2;
					nextRow = 1;
				} else if (nextRow > R - 1) {
					d = 1;
					nextRow = R - 2;
				} else if (nextCol < 0) {
					d = 3;
					nextCol = 1;
				} else if (nextCol > C - 1) {
					d = 4;
					nextCol = C - 2;
				}
				
				r = nextRow;
				c = nextCol;
			}
		}
	}
}