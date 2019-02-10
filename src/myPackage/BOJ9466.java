package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 텀 프로젝트
 * 학생 수(2<=n<=100,000)
 * 각 학생들이 같은 팀을 하고싶은 학생을 선택할 때, 사이클이 완성되어야 팀이 완성(ex. 1->2->3->1)
 * 팀이 없는 학생의 수를 출력
 */
public class BOJ9466 {
	private static final String NEW_LINE = "\n";
	private static boolean[] check;
	private static boolean[] cycle;
	private static int[] a;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			check = new boolean[n + 1];
			a = new int[n + 1];
			cycle = new boolean[n + 1];
			for (int i = 1; i <= n; i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}
			
			int ans = 0;
			for (int i = 1; i <= n; i++) {
				if (check[i] == false) {
					ans += dfs(i);
				}
			}
			sb.append(ans).append(NEW_LINE);
		}
		System.out.println(sb);
	}
	
	public static int dfs(int x) {
		if (check[x] != false) {
			if (cycle[x] != false) {
				return 0;
			}
			return 1;
		}
		check[x] = true;
		cycle[x] = true;
		
		return dfs(a[x]);
	}
}
