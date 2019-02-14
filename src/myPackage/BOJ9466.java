package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * 텀 프로젝트
 * 학생 수(2<=n<=100,000)
 * 각 학생들이 같은 팀을 하고싶은 학생을 선택할 때, 사이클이 완성되어야 팀이 완성(ex. 1->2->3->1)
 * 팀이 없는 학생의 수를 출력
 */
public class BOJ9466 {
	private static final String NEW_LINE = "\n";
	private static int[] cycle;
	private static int[] a;
	private static ArrayList<Integer> al;
	private static int num = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			a = new int[n + 1];
			cycle = new int[n + 1];
			for (int i = 1; i <= n; i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 1; i <= n; i++) {
				if (cycle[i] == 0) {
					al = new ArrayList<>();
					dfs(i);
				}
			}

			
			sb.append(n - num).append(NEW_LINE);
		}
		System.out.println(sb);
	}

	public static void dfs(int x) {
		if (al.contains(x)) {
			for (int i = al.indexOf(x); i < al.size(); i++) {
				cycle[al.get(i)] = 1;
				num++;
			}
		}
		if (cycle[x] != 0) {
			return;
		}
		
		al.add(x);
		cycle[x] = -1;

		dfs(a[x]);
	}
}
