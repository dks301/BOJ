package sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 버블 소트
 * 몇단계에서 정렬이 완료되는지 찾기
 */
public class BOJ1377 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Pair[] A = new Pair[N];
		for (int i = 0; i < N; i++) {
			A[i] = new Pair(Integer.parseInt(br.readLine()), i);
		}
		
		Arrays.sort(A);
		
		int max = 0;
		for (int i = 0; i < N; i++) {
			if (max < A[i].idx - i) {
				max = A[i].idx - i;
			}
		}
		System.out.println(max + 1);
	}
	
	public static class Pair implements Comparable<Pair>{
		int val, idx;
		
		public Pair(int val, int idx) {
			this.val = val;
			this.idx = idx;
		}
		
		public int compareTo(Pair that) {
			if (this.val < that.val) {
				return -1;
			} else if (this.val == that.val) {
				return 0;
			} else {
				return 1;
			}
		}
	}
}
