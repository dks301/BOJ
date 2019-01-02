package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ1138 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] numOfShort = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			numOfShort[i] = Integer.parseInt(st.nextToken());
		}

		String temp = "" + N;
		LinkedList<String> ll = new LinkedList<>();
		ll.add(temp);
		for (int i = N - 1; i >= 1; i--) {
			temp = "" + i;
			ll.add(numOfShort[i], temp);
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N - 1; i++) {
			sb.append(ll.get(i) + " ");
		}
		sb.append(ll.get(N - 1));
		System.out.println(sb.toString());
	}
}
