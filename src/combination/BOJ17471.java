package combination;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ17471 {
	private static int N, ans;
	private static int[] nums;
	private static ArrayList<Integer>[] al;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		nums = new int[N];
		al = new ArrayList[N];
		
		for (int i = 0; i < N; i++) {
			al[i] = new ArrayList<>();
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int size = Integer.parseInt(st.nextToken());
			for (int j = 0; j < size; j++) {
				al[i].add(Integer.parseInt(st.nextToken()) - 1);
			}
		}
		
		ans = -1;
		for (int i = 1; i <= (N / 2); i++) {
			combination(new int[i], 0, N, i, 0);
		}
		System.out.println(ans);
	}
	
	public static int bfs(int[] arr) {
		Queue<Integer> q = new LinkedList<>();
		q.add(arr[0]);
		
		boolean[] check = new boolean[N];
		check[arr[0]] = true;
		
		while (!q.isEmpty()) {
			int x = q.remove();
			
			for (int i = 0; i < al[x].size(); i++) {
				int next = al[x].get(i);
				for (int j = 0; j < arr.length; j++) {
					if (!check[next] && next == arr[j]) {
						q.add(next);
						check[next] = true;
					}
				}
			}
		}
		
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			if (!check[arr[i]]) {
				return -1;
			}
			sum += nums[arr[i]];
		}
		
		return sum;
	}
	
	public static void combination(int[] arr, int index, int n, int r, int target) {
		if (r == 0) {
			int[] B = new int[N - arr.length];
			boolean[] c = new boolean[N];
			for (int i = 0; i < arr.length; i++) {
				c[arr[i]] = true;
			}
			
			int j = 0;
			for (int i = 0; i < N; i++) {
				if (!c[i]) {
					B[j] = i;
					j++;
				}
			}
			
			int totalA = bfs(arr);
			if (totalA == -1) {
				return;
			}
			int totalB = bfs(B);
			if (totalB == -1) {
				return;
			}
			
			int result = Math.abs(totalA - totalB);
			if (ans == -1) {
				ans = result;
				return;
			} else if (ans > result) {
				ans = result;
				return;
			}
			
		} else if (target == n) {
			return;
		} else {
			arr[index] = target;
			combination(arr, index + 1, n, r - 1, target + 1);
			combination(arr, index, n, r, target + 1);
		}
	}
}
