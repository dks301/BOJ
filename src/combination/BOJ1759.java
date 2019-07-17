package combination;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 암호 만들기
 * 암호는 서로 다른 L개의 알파벳 소문자들로 구성
 * 최소 한 개의 모음과 최소 두 개의 자음으로 구성
 * 알파벳 오름차순으로 구성
 * C개의 문자 종류로 구성
 * 
 * 입력
 * 첫째줄: 두 정수 L, C(3<=L<=C<=15)
 * 다음줄: C개의 문자들이 공백으로 구분(모두 소문자이며, 중복x)
 * 
 * 출력
 * 사전순으로 가능성 있는 암호를 모두 출력
 */
public class BOJ1759 {
	private static int L, C;
	private static char[] alpha;
	
	private static final char[] VOWEL = {'a', 'e', 'i', 'o', 'u'};
	private static final char NEW_LINE = '\n';
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		alpha = new char[C];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			alpha[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(alpha);
		
		combination(new int[L], 0, C, L, 0);
		System.out.print(sb);
	}
	
	public static void combination(int[] arr, int index, int n, int r, int target) {
		if (r == 0) {
			if (isPossible(arr)) {
				for (int i = 0; i < arr.length; i++) {
					sb.append(alpha[arr[i]]);
				}
				sb.append(NEW_LINE);
			}
		} else if (target == n) {
			return;
		} else {
			arr[index] = target;
			combination(arr, index + 1, n, r - 1, target + 1);
			combination(arr, index, n, r, target + 1);
		}
	}
	
	public static boolean isPossible(int[] arr) {
		int len = arr.length;
		int consonant = 0;
		int vowel = 0;
		for (int i = 0; i < len; i++) {
			for (char next : VOWEL) {
				if (next == alpha[arr[i]]) {
					vowel++;
				}
			}
		}
		consonant = len - vowel;
		if (consonant >= 2 && vowel >= 1) {
			return true;
		} else {
			return false;
		}
	}
}
