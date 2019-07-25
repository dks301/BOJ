package stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * 히스토그램에서 가장 큰 직사각형
 * 히스토그램에서 가장 넓이가 큰 직사각형 찾기
 * 
 * 입력
 * 첫째줄: 히스토그램 갯수 n(1<=n<=100,000) 그 다음 n개의 정수 h1,...,hn(0<=hi<=10억)
 * 입력의 마지막줄에는 0이 주어진다
 * 
 * 출력
 * 각 테스트케이스에 대해서, 히스토그램에서 가장 넓이가 큰 직사각형의 넓이 출력
 */
public class BOJ6549 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			if (n == 0) {
				break;
			}
			int[] h = new int[n];
			for (int i = 0; i < n; i++) {
				h[i] = Integer.parseInt(st.nextToken());
			}
			
			long ans = 0;
			long temp = 0;
			int cnt = 0;
			Stack<Integer> s = new Stack<>();
			s.push(0);
			for (int i = 1; i < n; i++) {
				if (h[i - 1] > h[i]) {
					while (!s.isEmpty() && h[s.peek()] > h[i]) {
						temp = h[s.pop()];
						if (!s.isEmpty()) {
							temp *= (i - s.peek() - 1);
						} else {
							temp *= i;
						}
						if (temp > ans) {
							ans = temp;
						}
					}
				}
				s.push(i);
			}
			
			while (!s.isEmpty()) {
				temp = h[s.pop()];
				if (!s.isEmpty()) {
					temp *= (n - s.peek() - 1);
				} else {
					temp *= n;
				}
				if (temp > ans) {
					ans = temp;
				}
			}
			System.out.println(ans);
		}
	}
}
