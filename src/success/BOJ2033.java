package success;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ2033 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int temp = N;
		int i = 10;
		
		while (N > i) {
			temp = temp % i / (i / 10);
			if (temp >= 5)
				N = ((N / i) + 1) * i;
			else
				N = (N / i) * i;
			i *= 10;
			temp = N;
		}
		System.out.println(N);
	}
}
