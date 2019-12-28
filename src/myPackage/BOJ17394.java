package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ17394 {
	private static int N;
	private static int A;
	private static int B;
	private static final int MAX = 200_001;
	private static final int NOT_POSSIBLE = -1;
	private static final char NEW_LINE = '\n';
	
	private static boolean[] isPrime = new boolean[MAX];
	private static int[] check;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		initIsPrime();
		
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			boolean isNotPossible = true;
			
			for (int i = A; i <= B; i++) {
				if (isPrime[i]) {
					isNotPossible = false;
					break;
				}
			}
			
			if (isNotPossible) {
				sb.append(NOT_POSSIBLE).append(NEW_LINE);
			} else {
				sb.append(bfs()).append(NEW_LINE);
			}
		}
		
		System.out.print(sb);
	}
	
	public static void initIsPrime() {
		Arrays.fill(isPrime, true);
		isPrime[0] = false;
		isPrime[1] = false;
		
		for (int i = 2; i < MAX; i++) {
			if (isPrime[i]) {
				for (int j = (i + i); j < MAX; j += i) {
					isPrime[j] = false;
				}
			}
		}
	}
	
	public static int bfs() {
		Queue<Integer> q = new LinkedList<>();
		check = new int[2 * N];
		
		q.offer(N);
		check[N] = 1;
		
		while (!q.isEmpty()) {
			int n = q.poll();
			if (isPrime[n] && n >= A && n <= B) {
				return check[n] - 1;
			}
			
			int div_two = n / 2;
			if (div_two < check.length && check[div_two] == 0) {
				q.add(div_two);
				check[div_two] = check[n] + 1;
			} else if (check[div_two] != 0 && check[div_two] > check[n] + 1) {
				check[div_two] = check[n] + 1;
			}
			
			int div_three = n / 3;
			if (div_three < check.length && check[div_two] == 0) {
				q.add(div_three);
				check[div_three] = check[n] + 1;
			} else if (check[div_three] != 0 && check[div_three] > check[n] + 1) {
				check[div_three] = check[n] + 1;
			}
			
			int plus_n = n + 1;
			if (plus_n < check.length && check[plus_n] == 0) {
				q.add(plus_n);
				check[plus_n] = check[n] + 1;
			} else if (check[plus_n] != 0 && check[plus_n] > check[n] + 1) {
				check[plus_n] = check[n] + 1;
			}
			
			int minus_n = n - 1;
			//System.out.println(minus_n);
			if (minus_n <= 0) {
				continue;
			}
			if (minus_n < check.length && check[minus_n] == 0) {
				q.add(minus_n);
				check[minus_n] = check[n] + 1;
			} else if (check[minus_n] != 0 && check[minus_n] > check[n] + 1) {
				check[minus_n] = check[n] + 1;
			}
		}
		
		return -1;
	}
}
