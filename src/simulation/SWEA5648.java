package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA5648 {
	private static int N, ans;
	private static int[][] check;
	private static ArrayList<Atom> atoms;

	private static final int[][] DIRECTIONS = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
	private static final int ROW = 0;
	private static final int COL = 1;

	private static final char NUM = '#';
	private static final char SPACE = ' ';
	private static final char NEW_LINE = '\n';

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		check = new int[4001][4001];
		atoms = new ArrayList<>();
		
		for (int t = 1; t <= T; t++) {
			sb.append(NUM).append(t).append(SPACE);
			N = Integer.parseInt(br.readLine());
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int r = (Integer.parseInt(st.nextToken()) + 1000) * 2;
				int c = (Integer.parseInt(st.nextToken()) + 1000) * 2;
				int d = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				atoms.add(new Atom(r, c, d, e));
				check[r][c] = e;
			}

			ans = 0;
			go();

			sb.append(ans).append(NEW_LINE);
		}

		System.out.print(sb);
	}

	public static void go() {
		Atom a;
		
		while (atoms.size() > 1) {
			for (int i = atoms.size() - 1; i >= 0; i--) {
				a = atoms.get(i);

				int nextRow = a.row + DIRECTIONS[a.d][ROW];
				int nextCol = a.col + DIRECTIONS[a.d][COL];
				if (nextRow < 0 || nextRow > 4000 || nextCol < 0 | nextCol > 4000) {
					check[a.row][a.col] -= a.energy;
					atoms.remove(i);
					continue;
				}

				check[nextRow][nextCol] += a.energy;
				check[a.row][a.col] -= a.energy;
				a.row = nextRow;
				a.col = nextCol;
			}

			for (int i = atoms.size() - 1; i >= 0; i--) {
				a = atoms.get(i);
				if (a.energy != check[a.row][a.col]) {
					ans += check[a.row][a.col];
					check[a.row][a.col] = 0;
					atoms.remove(i);
				}
			}
		}
		
		if (atoms.size() == 1) {
			a = atoms.get(0);
			check[a.row][a.col] = 0;
			atoms.remove(0);
		}
	}

	public static class Atom {
		int row, col;
		int d, energy;

		public Atom(int row, int col) {
			this.row = row;
			this.col = col;
		}

		public Atom(int row, int col, int d, int energy) {
			this.row = row;
			this.col = col;
			this.d = d;
			this.energy = energy;
		}
	}
}
