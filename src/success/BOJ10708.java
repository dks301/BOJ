package success;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10708 {
	private static final String SPACE = " ";
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // N is the number of friends. 3<=N<=100
		int M = Integer.parseInt(br.readLine()); // M is the number of games. 3<=M<=100
		int Score[] = new int[N + 1];
		
		int A[] = new int[M + 1]; // The targets.
		int B[][] = new int[M + 1][N + 1]; // they picked.
		
		StringTokenizer st = new StringTokenizer(br.readLine(), SPACE);
		for (int i = 1; i < M + 1; i++) { // Fill the array A[i]
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i < M + 1; i++) { // Fill the array B[i][j]
			st = new StringTokenizer(br.readLine(), SPACE);
			for (int j = 1; j < N + 1; j++) {
				B[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 1; i < M + 1; i++) {
			for (int j = 1; j < N + 1; j++) {
				if(A[i] == B[i][j]) {
					Score[j]++;
				}
				else {
					Score[A[i]]++;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < N + 1; i++) {
			sb.append(Score[i]).append("\n");
		}
		System.out.println(sb.toString());
	}
}
