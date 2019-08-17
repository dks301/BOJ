package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ16637 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[] a = br.readLine().toCharArray(); // 짝수자리 숫자, 홀수자리 연산자
		
		int[][]d = new int[N][2]; // i번째 자리에 있는 수가 i-2자리에 있는 수와 괄호로 묶일때 j=0, 안묶일때 j=1
		d[0][0] = d[0][1] = Character.getNumericValue(a[0]);
		if (N >= 3) { // N이 1일때, 잘못 된 index참조 방지
			d[2][0] = d[2][1] = operation(Character.getNumericValue(a[0]), a[1], Character.getNumericValue(a[2]));

			for (int i = 4; i < N; i += 2) { 
				int temp = operation(Character.getNumericValue(a[i - 2]), a[i - 1], Character.getNumericValue(a[i])); // a[i-2]와 a[i]를 a[i-1]연산자로 계산
				d[i][0] = operation(Math.max(d[i - 4][0], d[i - 4][1]), a[i - 3], temp); // i-4번쨰까지 최댓값과 위 연산값을 a[i-3]연산자로 계산
				d[i][1] = Math.max(operation(d[i - 2][0], a[i - 1], Character.getNumericValue(a[i])), operation(d[i - 2][1], a[i - 1], Character.getNumericValue(a[i])));
				// i-2 자리까지 최댓값과 a[i]의 값을  a[i-1]연산자로 계산
			}
		}
		for (int i = 0; i < N; i += 2) {
			System.out.println(d[i][0] + " " + d[i][1]);
		}
		System.out.println(Math.max(d[N - 1][0], d[N - 1][1])); // 최댓값 출력
	}

	public static int operation(int val1, char op, int val2) {
		switch (op) {
		case '+':
			return val1 + val2;

		case '-':
			return val1 - val2;

		case '*':
			return val1 * val2;
		}

		return Integer.MIN_VALUE; // error!
	}
}
