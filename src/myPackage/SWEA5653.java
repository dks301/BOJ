package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA5653 {
	private static PriorityQueue<Cell> cellList;
	private static Queue<Cell> tempCell;
	
	private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	private static final int ROW = 0;
	private static final int COL = 1;
	
	private static final char NUM = '#';
	private static final char SPACE = ' ';
	private static final char NEW_LINE = '\n';
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			System.out.print(NUM + "" + t + " ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			cellList = new PriorityQueue<>();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					int temp = Integer.parseInt(st.nextToken());
					if (temp != 0) {
						cellList.add(new Cell(i, j, temp));
					}
				}
			}
			
			int ans = 0;
			for (int i = 0; i <= K; i++) {
				ans = 0;
				Iterator<Cell> it = cellList.iterator();
				tempCell = new LinkedList<>();
				while (it.hasNext()) {
					Cell next = it.next();
					next.go();
					
					if (!next.isDie) {
						ans++;
					}
				}
				
				cellList.addAll(tempCell);
			}
			
			
			System.out.println(ans);
		}
	}
	
	public static class Cell implements Comparable<Cell>{
		int row, col;
		int life, count;
		boolean isActive, isDie;
		
		public Cell(int row, int col, int life) {
			this.row = row;
			this.col = col;
			this.life = life;
			this.count = life;
			isActive = isDie = false;
		}
		
		public void go() {
			if (isDie) {
				return;
			}
			
			if (count != 0) {
				count--;
			} else {
				if (!isActive) {
					count = life - 1;
					isActive = true;
					breed();
					
				} else if (isActive) {
					isDie = true;
					count = life;
				}
			}
		}
		
		public void breed() {
			for (final int[] D : DIRECTIONS) {
				int nextRow = this.row + D[ROW];
				int nextCol = this.col + D[COL];
				
				boolean isPossible = true;
				for (Cell next : cellList) {
					if (next.row == nextRow && next.col == nextCol) {
						isPossible = false;
					}
				}
				for (Cell next : tempCell) {
					if (next.row == nextRow && next.col == nextCol) {
						isPossible = false;
					}
				}
				
				if (isPossible) {
					tempCell.add(new Cell(nextRow, nextCol, this.life));
				}
			}
		}
		
		@Override
		public int compareTo(Cell that) {
			// TODO Auto-generated method stub
			if (this.life < that.life) {
				return 1;
			} else if (this.life == that.life) {
				return 0;
			} else {
				return -1;
			}
		}
	}
}
