package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 준오는 급식충이야!!
 * 첫째 줄에는 준오를 포함한 친구들의 수 N과 홍수까지 남은 시간 T가 주어진다.
 * (1 ≤ N ≤ 50,000, 1 ≤ T(초) ≤ 1,000,000,000) 남은 시간 T는 소숫점 넷째자리의 실수로 주어진다.
 * 둘째 줄에는 N명 학생들의 위치 x1, x2, ..., xn(1 ≤ xi ≤ 1,000,000,000)가 주어진다. (자연수, 미터 단위)
 * 셋째 줄에는 N명 학생들의 속도 v1, v2, ..., vn(1 ≤ vi ≤ 1,000,000,000)가 주어진다. (자연수, 초당 미터)
 * 준오와 친구들이 모두 만날 수 있으면 1을, 그렇지 않으면 0을 출력
 */
public class BOJ14488 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		double T = Double.parseDouble(st.nextToken());
		
		Student[] s = new Student[N];
		st = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			s[i] = new Student(Integer.parseInt(st.nextToken()), Integer.parseInt(st2.nextToken()));
		}
		
		Arrays.sort(s);
		int min = s[0].x;
		int max = s[N - 1].x;
		
		for (int i = 0; i <=)
	}
	
	public void inside() {
		
	}
	
	public void outside() {
		
	}
	
	public static class Student implements Comparable<Student> {
		int x, v;
		
		public Student(int x, int v) {
			this.x = x;
			this.v = v;
		}

		@Override
		public int compareTo(Student that) {
			if (this.x < that.x) {
				return -1;
			} else if (this.x == that.x) {
				return 0;
			} else {
				return 1;
			}
		}
		
	}
}
