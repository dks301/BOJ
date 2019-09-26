package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ17471 {
	private static int N, ans;
	private static int[] A;
	private static ArrayList<Integer>[] al;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		al = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			al[i] = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			for (int j = 0; j < cnt; j++) {
				al[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		for (int i = 1; i <= N / 2; i++) {
			combination(new int[i], 0, N, i, 0);
		}
		
	}
	
	public static void bfs(int[] arr) {
		Queue<Integer> q = new LinkedList<>();
		int[] check = new int[N];
		for (int i = 0; i < arr.length; i++) {
			q.add(al[arr[i]].get(arr[i]));
		}
	}
	
	public static void combination(int[] arr, int index, int n, int r, int target) {
		if (r == 0) {
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		} else if (target == n) {
			return;
		} else {
			arr[index] = target;
			combination(arr, index + 1, n, r - 1, target + 1);
			combination(arr, index, n, r, target + 1);
		}
	}
}
