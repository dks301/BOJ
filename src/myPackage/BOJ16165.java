package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
/*
 * 걸그룹 마스터 준석이
 * 걸그룹의 수 N(0<N<100), 문제의 수M(0<M<100)
 */
public class BOJ16165 {
	private static final String NEW_LINE = "\n";
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<String>[] group = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			group[i] = new ArrayList<>();
			group[i].add(br.readLine());
			int num = Integer.parseInt(br.readLine());
			for (int j = 1; j <= num; j++) {
				group[i].add(br.readLine());
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			String quiz = br.readLine();
			
			int type = Integer.parseInt(br.readLine());
			switch (type) {
			case 0:
				for (int j = 0; j < N; j++) {
					if (group[j].get(0).equals(quiz)) {
						for (int k = 1; k < group[j].size(); k++) {
							sb.append(group[j].get(k)).append(NEW_LINE);
						}
					}
				}
				break;
			case 1:
				for (int j = 0; j < N; j++) {
					for (String name : group[j]) {
						if (name.equals(quiz)) {
							sb.append(group[j].get(0)).append(NEW_LINE);
							break;
						}
					}
				}
				break;
			}
		}
		System.out.println(sb);
	}
}
