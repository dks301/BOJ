package success;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10871 {
	public static void main(String[]args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int temp;
		for (int i = 0; i < N; i++) {
			temp = Integer.parseInt(st.nextToken());
			if (temp < X)
				sb.append(temp + " ");
		}
		System.out.println(sb.toString().trim());
	}

}
