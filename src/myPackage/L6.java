package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class L6 {
	private static char[][] map;
	private static ArrayList<Number> al = new ArrayList<>();
	private static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		String what = st.nextToken();
		int max = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int size = Integer.parseInt(st.nextToken());
			if (size > max) {
				max = size;
			}
			int num = Integer.parseInt(st.nextToken());
			al.add(new Number(size, num));
		}
		
		int sum = 0;
		for (Number next : al) {
			int size = next.size;
			int len = next.digit.length;
			sum += (size * len + (len - 1));
		}
		int row = max * 2 - 1;
		int col = sum;
		map = new char[row][col];
		for (int i = 0; i < row; i++) {
			Arrays.fill(map[i], '.');
		}
		zero(0, 0, 5);
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		
		switch (what) {
		case "TOP":
			
			break;

		case "BOTTOM":

			break;

		case "MIDDLE":

			break;
		}
	}
	
	public static void zero(int row, int col, int size) {
		for (int i = row; i < row + (size * 2) - 1; i++) {
			map[i][col] = '#';
			map[i][col + size - 1] = '#';
		}
		for (int j = col; j < col + size; j++) {
			map[row][j] = '#';
			map[row + (size * 2) - 2][j] = '#';
		}
		
		for (int i = 0; i < size * 2 - 1; i++) {
			map[i][col + size] = ' ';
		}
	}
	
	public static void one(int row, int col, int size) {
		int i = row + size - 1;
		for (int j = col; j < col + (size * 2) - 1; j++) {
			
		}
	}

	public static class Number {
		int size;
		int[] digit;

		public Number(int size, int num) {
			this.size = size;
			if (num == 0) {
				this.digit = new int[1];
				digit[0] = 0;
			} else {
				int len = (int) (Math.log10(num) + 1);
				this.digit = new int[len];

				for (int i = len - 1; i >= 0; i--) {
					this.digit[i] = num % 10;
					num /= 10;
				}
			}
		}
	}
}
