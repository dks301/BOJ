package success;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ10886 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int isCute = 0;
		for (int i = 0; i < N; i++) {
			int temp = (Integer.parseInt(br.readLine()) == 1) ? isCute++ : isCute--;
		}
		String result = isCute > 0 ? "Junhee is cute!" : "Junhee is not cute!";
		System.out.println(result);
	}
}
