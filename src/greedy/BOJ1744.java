package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/*
 * 수 묶기
 * 길이가 N인 수열의 두 수를 위치와 상관없이 묶어서 묶은 것은 곱하기
 * 합이 최대가 되게 하는 프로그램 작성.
 * 
 * 입력
 * 첫째 줄: 수열의 크기 N(<=10,000)
 * 둘째 줄부터 N개의 줄: 수열의 각 수(-10,000<=각수<=10,000 인 정수)
 * 
 * 출력
 * 합의 최댓값(<2^31)
 */
public class BOJ1744 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> plus = new ArrayList<>();
		ArrayList<Integer> zero = new ArrayList<>();
		ArrayList<Integer> minus = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			int val = Integer.parseInt(br.readLine());
			if (val > 0) {
				plus.add(val);
			} else if (val == 0) {
				zero.add(val);
			} else {
				minus.add(val);
			}
		}
		int plusTop = plus.size() - 1;
		int zeroTop = zero.size() - 1;
		int minusTop = minus.size() - 1;
		
		if (plusTop >= 0) {
			Collections.sort(plus);
		}
		if (minusTop >= 0) {
			Collections.sort(minus);
		}
		
		int sum = 0;
		while (plusTop >= 0) {
			int temp = plus.get(plusTop--);
			if (plusTop < 0) {
				sum += temp;
				break;
			} else {
				int temp2 = plus.get(plusTop--);
				if (temp2 == 1) {
					temp++;
				} else {
					temp *= temp2;
				}
				sum += temp;
			}
		}
		
		for (int i = 0; i <= minusTop; i += 2) {
			int temp = minus.get(i);
			if (i == minusTop) {
				if (zeroTop < 0) {
					sum += temp;
				}
				break;
			} else {
				temp *= minus.get(i + 1);
				sum += temp;
			}
		}
		
		System.out.println(sum);
	}
}
