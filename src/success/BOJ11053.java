package success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11053 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] d = new int[N + 1];
		int maxIdx = 0;
		for (int i = 1; i <= N; i++) {
			if (A[i] > d[maxIdx]) {
				d[++maxIdx] = A[i];
			} else {
				for (int j = 1; j <= maxIdx; j++) {
					if (d[j] >= A[i]) {
						d[j] = A[i];
						break;
					}
				}
			}
		}
		System.out.println(maxIdx);
	}
}
