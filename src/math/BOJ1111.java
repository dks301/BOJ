package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ1111 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		if (N == 1) {
			System.out.println("A");
		} else {
			ArrayList<Pair> al = new ArrayList<>();
			for (int a = -1_000_000; a <= 1_000_000; a++) {
				int i = 0;
				int b = A[i + 1] - A[i] * a;

				for (i = 0; i < N - 1; i++) {
					if (A[i + 1] != (A[i] * a + b)) {
						break;
					}
				}

				if (i == N - 1) {
					int next = A[N - 1] * a + b;
					if (al.isEmpty()) {
						al.add(new Pair(a, b, next));
					} else {
						if (next != al.get(0).next) {
							al.add(new Pair(a, b, next));
							break;
						}
					}
				}
			}

			int size = al.size();
			if (size == 0) {
				System.out.println("B");

			} else if (size == 1) {
				System.out.println(al.get(0).next);

			} else if (size == 2) {
				System.out.println("A");
			}

		}
	}

	public static class Pair {
		int a, b, next;

		public Pair(int a, int b, int next) {
			this.a = a;
			this.b = b;
			this.next = next;
		}
	}
}
