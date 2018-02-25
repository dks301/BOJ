package realization;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ2839 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		switch(N % 10) {
		case 0:
		case 5:
			System.out.println(N / 5);
			break;
		case 1:
			System.out.println(((N - 6) / 5) + 2);
			break;
		case 2:
			if (N > 12)
				System.out.println(((N - 12) / 5) + 4);
			else if (N == 12)
				System.out.println(4);
			else
				System.out.println(-1);
			break;
		case 3:
			if (N == 3)
				System.out.println(1);
			else
				System.out.println(((N - 3) / 5) + 1);
			break;
		case 4:
			if (N == 4)
				System.out.println(-1);
			else
				System.out.println(((N - 9) / 5) + 3);
			break;
		case 6:
			if (N == 6)
				System.out.println(2);
			else
				System.out.println(((N - 6) / 5) + 2);
			break;
		case 7:
			if (N == 7)
				System.out.println(-1);
			else
				System.out.println(((N - 12) / 5) + 4);
			break;
		case 8:
			System.out.println(((N - 3) / 5) + 1);
			break;
		case 9:
			if (N == 9)
				System.out.println(3);
			else
				System.out.println(((N - 9) / 5) + 3);
			break;
		}
	}
}
