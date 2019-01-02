package realization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ10815 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		HashSet<Integer> hs = new HashSet<Integer>(N);
		for (int i = 0; i < N; i++) {
			hs.add(Integer.parseInt(st.nextToken()));
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			int temp = Integer.parseInt(st.nextToken());
			if (hs.contains(temp)) {
				sb.append("1").append(" ");
			} 
			else {
				sb.append("0").append(" ");
			}
		}
		System.out.println(sb.toString());
	}
}
