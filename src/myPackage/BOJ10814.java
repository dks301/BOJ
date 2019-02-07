package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ10814 {
	private static final String SPACE = " ";
	private static final String NEW_LINE = "\n";
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		User[] u = new User[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			u[i] = new User(i, Integer.parseInt(st.nextToken()), st.nextToken());
		}
		Arrays.sort(u);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(u[i].age).append(SPACE).append(u[i].name).append(NEW_LINE);
		}
	}
	
	static class User implements Comparable<User>{
		private int idx;
		private int age;
		private String name;
		
		public User(int idx, int age, String name) {
			this.idx = idx;
			this.age = age;
			this.name = name;
		}
		
		public int compareTo(User that) {
			if (this.age < that.age) {
				return -1;
			} else if (this.age == that.age) {
				if (this.idx < that.idx) {
					return -1;
				} else if (this.idx == that.idx) {
					return 0;
				} else {
					return 1;
				}
			} else {
				return 1;
			}
		}
	}
}
