package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class L4 {
	private static int N;
	private static boolean[] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			int check = Integer.parseInt(st.nextToken());
			if (check == 1) {
				arr[i] = true;
			}
		}
		
		int[] d = new int[N + 1];
		int ans = 0;
		int idx = 0;
		for (int i = 1; i <= N; i++) {
			if (!arr[i]) {
				d[i] = d[i - 1] + 1;
				if (d[i] > ans) {
					ans = d[i];
					idx = i;
				}
			}
		}
		if (check(idx)) {
			System.out.println(ans);
		} else {
			System.out.println(ans % 2 == 0 ? ans / 2 : ans / 2 + 1);
		}
	}
	
	public static boolean check(int idx) {
		boolean left = true;
		boolean right = true;
		for (int i = 0; i < idx; i++) {
			if (arr[i]) {
				left = false;
				break;
			}
		}
		
		for (int i = idx; i <= N; i++) {
			if (arr[i]) {
				right = false;
				break;
			}
		}
		
		return left || right;
	}
}
