package realization;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BSIS_D {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		
		int count = 1;
		int i = 1;
		int j;
		while (true) {
			i += 2;
			for (j = 3; (j * j < i) && (i % j != 0); j += 2) {
			}
			if (j * j > i)
				count++;
			if (count == K)
				break;
		}
		System.out.println(i);
	}
}
