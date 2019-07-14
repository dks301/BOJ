package combination;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * 로또
 * 독일 로또는 {1, 2, ..., 49}에서 6개를 고른다
 * 49개 중 k(k>6)개의 수를 골라 집합 S를 만든 다음 그 수만 가지고 번호를 선택하는 전략
 * 
 * 입력
 * 각 테스트케이스(한줄): 첫번째 수 k(6<k<13), 다음 k개 수(오름차순 집합S)
 * 입력의 마지막은 0
 * 
 * 출력
 * 수를 고르는 모든 방법을 사전순으로 출력
 * 각 테스트 케이스 사이에는 빈 줄을 하나 출력
 */
public class BOJ6603 {
	private static ArrayList<Integer> al;
	private static final char SPACE = ' ';
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			if (k == 0) {
				break;
			}
			al = new ArrayList<>();
			int[] S = new int[k];
			for (int i = 0; i < k; i++) {
				S[i] = Integer.parseInt(st.nextToken());
				al.add(S[i]);
			}
			
			combination(new int[6], 0, k, 6, 0);
			System.out.println();
		}
	}
	
	public static void combination(int[] arr, int index, int n, int r, int target) {
		if (r == 0) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < arr.length; i++) {
				sb.append(al.get(arr[i])).append(SPACE);
			}
			System.out.println(sb);
			
		} else if (target == n) {
			return;
		} else {
			arr[index] = target;
			combination(arr, index + 1, n, r - 1, target + 1);
			combination(arr, index, n, r, target + 1);
		}
	}
}
