package findRules;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ1193 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine());
		// a0 = 1, a1= a0 + 1, a2 = a0 + 1 + 4
		// a3 = a0 + 1 * 2 + 4, a4 = a0 + 1 * 2 + 4 * 2
		int row = 1, col = 1;
		int n = 1, k = 1;
		int an = 1;
		
		while (X > an) {
			if (n % 2 == 1)
				an += 1;
			else {
				an += 4 * k;
				k++;
			}
			n++;
		}
		col = n;
		if (col % 2 == 1) {
			while (an != X) {
				row++;
				col--;
				an--;
				if (col == 0) {
					row -= 2;
					col++;
					break;
				}
			}
			while (an != X) {
				row--;
				col++;
				an--;
			}
		}
		else {
			while (an != X) {
				row++;
				col--;
				an--;
			}
		}
		System.out.println(row + "/" + col);
	}
}
