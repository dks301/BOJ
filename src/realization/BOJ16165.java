package realization;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
/*
 * 걸그룹 마스터 준석이
 * 걸그룹의 수 N(0<N<100), 문제의 수M(0<M<100)
 * 문제 유형별로 문제의 답 출력
 */
public class BOJ16165 {
	private static final String NEW_LINE = "\n";
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		String[] groupName = new String[N];
		ArrayList<String>[] group = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			groupName[i] = br.readLine();
			group[i] = new ArrayList<>();
			int num = Integer.parseInt(br.readLine());
			for (int j = 0; j < num; j++) {
				group[i].add(br.readLine());
			}
			Collections.sort(group[i]);
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			String quiz = br.readLine();
			
			int type = Integer.parseInt(br.readLine());
			switch (type) {
			case 0:
				for (int j = 0; j < N; j++) {
					if (groupName[j].equals(quiz)) {
						for (int k = 0; k < group[j].size(); k++) {
							sb.append(group[j].get(k)).append(NEW_LINE);
						}
					}
				}
				break;
			case 1:
				for (int j = 0; j < N; j++) {
					for (String name : group[j]) {
						if (name.equals(quiz)) {
							sb.append(groupName[j]).append(NEW_LINE);
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
