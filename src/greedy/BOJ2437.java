package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2437 {
	private static final String SPACE = " ";
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), SPACE);
		
		int[] weight = new int[N];
		for (int i = 0; i < N; i++) {
			weight[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(weight);
		
		if (weight[0] != 1) {
			System.out.println("1");
		}
		else {
			int total = 1;
			for (int i = 1; i < N; i++) {
				if (total + 1 >= weight[i])
					total += weight[i];
			}
			System.out.println(total + 1);
		}
	}
}
