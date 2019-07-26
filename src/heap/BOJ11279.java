package heap;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 최대 힙
 */
public class BOJ11279 {
	private static int[] heap = new int[100_001];
	private static int last = 0;
	
	private static final char NEW_LINE = '\n';
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (N-- > 0) {
			int x = Integer.parseInt(br.readLine());
			if (x == 0) {
				sb.append(pop()).append(NEW_LINE);
				
			} else {
				push(x);
			}
		}
		System.out.print(sb);
	}
	
	public static void push(int x) {
		heap[++last] = x;
		int i = last;
		while (i != 1) {
			int p = heap[i / 2];
			int c = heap[i];
			if (p < c) {
				swap(i, i / 2);
				i /= 2;
			} else {
				break;
			}
		}
	}
	
	public static int pop() {
		if (isEmpty()) {
			return 0;
		} else {
			int val = heap[1];
			heap[1] = heap[last];
			heap[last--] = 0;
			
			for (int i = 1; i * 2 <= last;) {
				int p = heap[i];
				int left = heap[2 * i];
				int right = heap[2 * i + 1];
				
				if (p > left && p > right) {
					break;
				} else if (left > right) {
					swap(i, 2 * i);
					i *= 2;
				} else {
					swap(i, 2 * i + 1);
					i = 2 * i + 1;
				}
			}
			return val;
		}
	}
	
	public static void swap(int a, int b) {
		int temp = heap[a];
		heap[a] = heap[b];
		heap[b] = temp;
	}
	
	public static boolean isEmpty() {
		return last > 0 ? false : true;
	}
}
