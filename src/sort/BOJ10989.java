package sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
/*
 * 수 정렬하기3
 * N개의 수가 주어질 때, 오름차순으로 정렬 후 출력
 */
public class BOJ10989 {
	private static final String NEW_LINE = "\n";
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] num = new int[N];
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(num);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(num[i]).append(NEW_LINE);
		}
		System.out.println(sb.toString());
	}
}
