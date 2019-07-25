package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;

/*
 * 검열
 * 텍스트T에서 A라는 단어를 다음과 같은 알고리즘으로 모두 없애려고 한다
 *   1. T에 A가 없으면 알고리즘을 종료한다.
 *   2. T에서 처음 등장하는 A를 찾은 뒤, 삭제한다.
 *   3. T에 A가 없으면 알고리즘을 종료한다.
 *   4. T에서 마지막으로 등장하는 A를 찾은 뒤, 삭제한다.
 *   5. 1번으로 돌아간다.
 */
public class BOJ3111 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] A = br.readLine().toCharArray();
		char[] T = br.readLine().toCharArray();
		
		boolean sw = false;
		int cur = 0;
		int left = 0;
		int right = T.length - 1;
		Stack<Character> L = new Stack<>();
		Stack<Character> R = new Stack<>();
		
		while (left < right) {
			if (!sw) {
				cur = 0;
				for (int i = left; i < right; i++) {
					L.add(T[i]);
					
					if (T[i] == A[cur]) {
						cur++;
						if (cur == A.length) {
							for(int j = 0; j < A.length; j++) {
								System.out.println(L.pop() + "가 ");
							}
							break;
						}
					} else {
						cur = 0;
					}
					left++;
				}
				
				sw = true;
			} else {
				cur = A.length - 1;
				for (int i = right; i > left; i--) {
					R.add(T[i]);
					
					if (T[i] == A[cur]) {
						cur--;
						if (cur == -1) {
							for (int j = 0; j < A.length; j++) {
								System.out.println(R.pop() + " 나");
							}
							break;
						}
					} else {
						cur = A.length - 1;
					}
				}
				right--;
				sw = false;
			}
		}
		
		System.out.println("Left");
		while (!L.isEmpty()) {
			System.out.print(L.pop() + " ");
		}
		System.out.println("\nRight");
		while (!R.isEmpty()) {
			System.out.print(R.pop() + " ");
		}
	}
}
