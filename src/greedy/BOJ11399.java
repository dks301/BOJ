package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11399 {	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int P[] = new int[N];
		int i = 0;
		while(st.hasMoreTokens()) {
			P[i++] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(P);
		
		int total = 0;
		for (i = 0; i < N; i++) {
			int sum = 0;
			for (int j = 0; j <= i; j++) {
				sum += P[j];
			}
			total += sum;
		}
		System.out.println(total);
	}
}
