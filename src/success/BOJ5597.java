package success;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ5597 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[] isSubmit = new boolean[31];
		isSubmit[0] = true;
		
		for (int i = 0; i < 28; i++) {
			int temp = Integer.parseInt(br.readLine());
			isSubmit[temp] = true;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= 30; i++) {
			if (!isSubmit[i])
				sb.append(i).append("\n");
		}
		System.out.println(sb.toString());
	}
}
