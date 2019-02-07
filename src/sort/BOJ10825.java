package sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 국영수
 * 1. 국어 점수가 감소하는 순서로
 * 2. 국어 점수가 같으면 영어 점수가 증가하는 순서로
 * 3. 국어 점수와 영어 점수가 같으면 수학 점수가 감소하는 순서로
 * 4. 모든 점수가 같으면 이름이 사전 순으로 증가하는 순서로(대문자가 소문자보다 앞으로)
 * 위 4가지 정렬 기준대로 정렬 후 순서대로 출력
 */
public class BOJ10825 {
	private static final String NEW_LINE = "\n";
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Student[] stu = new Student[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			stu[i] = new Student(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(stu);
		
		StringBuilder sb = new StringBuilder();
		for (Student s : stu) {
			sb.append(s.name).append(NEW_LINE);
		}
		System.out.println(sb);
	}
	
	private static class Student implements Comparable<Student>{
		private final int ko, en, ma; // 국, 영, 수
		private final String name;
		
		public Student(String name, int ko, int en, int ma) {
			this.name = name;
			this.ko = ko;
			this.en = en;
			this.ma = ma;
		}
		
		public int compareTo(Student that) {
			if (this.ko > that.ko) {
				return -1;
			} else if (this.ko == that.ko) {
				if (this.en < that.en) {
					return -1;
				} else if (this.en == that.en) {
					if (this.ma > that.ma) {
						return -1;
					} else if (this.ma == that.ma) {
						return this.name.compareTo(that.name);
					} else {
						return 1;
					}
				} else {
					return 1;
				}
			} else {
				return 1;
			}
		}
	}
}
