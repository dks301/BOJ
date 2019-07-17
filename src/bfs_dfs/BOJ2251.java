package bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 물통
 * 부피가 A, B, C(1<=A,B,C<=200)리터인 세 물통
 * 처음에는 A,B는 비어있고 C는 가득 차있다.
 * 물을 부을때는 한 물통이 비거나, 다른 한 통이 가득 찰때까지 부을 수 있다
 * 
 * 입력
 * 세 정수 A, B, C
 * 
 * 출력
 * 공백으로 구분하여 C에 담겨있을 수 있는 물의 양을 오름차순 정렬하여 출력
 */
public class BOJ2251 {
	private static int[] max = new int[3];
	private static HashMap<Integer, Integer> hm;

	private static final char SPACE = ' ';
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		max[0] = Integer.parseInt(st.nextToken());
		max[1] = Integer.parseInt(st.nextToken());
		max[2] = Integer.parseInt(st.nextToken());
		
		hm = new HashMap<>();
		bfs(max[2]);
		
		ArrayList<Integer> al = new ArrayList<>();
		for (int i = 0; i < 1_000_000; i++) {
			if (hm.containsKey(i)) {
				al.add(hm.get(i));
			}
		}
		
		Collections.sort(al);
		
		StringBuilder sb = new StringBuilder();
		for (int next : al) {
			sb.append(next).append(SPACE);
		}
		System.out.println(sb);
		
	}
	
	public static void bfs(int n) {
		Queue<Integer> q = new LinkedList<>();
		q.add(n);
		hm.put(n, n);
		
		while (!q.isEmpty()) {
			n = q.remove();
			int temp = n;
			int[] info = new int[9];
			for (int i = 8; i >= 0; i--) {
				info[i] = temp % 10;
				temp /= 10;
			}
			int[] bucket = new int[3];
			for (int i = 0; i < 3; i++) {
				bucket[i] = info[i * 3] * 100 + info[(i * 3)+ 1] * 10 + info[(i * 3) + 2];
			}
			
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (i != j && bucket[i] != 0) {
						int val = pour(bucket.clone(), i, j);
						if (!hm.containsKey(val)) {
							q.add(val);
							hm.put(val, val % 1000);
						}
					}
				}
			}			
		}
	}
	
	public static int pour(int[] bucket, int from, int to) {
		int fromLitter = bucket[from]; //b[from].now;
		int toLitter = max[to] - bucket[to];//b[to].max - b[to].now;
		
		if (fromLitter < toLitter) {
			bucket[from] = 0; //b[from].now = 0;
			bucket[to] += fromLitter; //b[to].now += fromLitter;
		} else {
			bucket[to] = max[to];  //b[to].now = b[to].max;
			bucket[from] -= toLitter; //b[from].now -= toLitter;
		}
		int val = 0;
		for (int i = 0; i < 3; i++) {
			val = val * 1000 + bucket[i];
		}
		return val;
	}

	public static class Bucket {
		int now, max;

		public Bucket(int now, int max) {
			this.now = now;
			this.max = max;
		}
	}
}
