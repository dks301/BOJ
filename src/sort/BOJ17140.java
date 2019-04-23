package sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 이차원 배열과 연산
 * 3x3 배열A를 1초마다 R or C연산 진행
 * A[r][c]에 들어있는 값이 k가 되기 위한 최소시간 출력
 * 100초가 넘어가면 -1출력
 */
public class BOJ17140 {
	private static final int SIZE = 101;
	private static PriorityQueue<Node> pq = new PriorityQueue<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[SIZE][SIZE];
		for (int i = 1; i <= 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int maxRow = 3; 
		int maxCol = 3;
		int t = 0;
		if (map[r][c] != k) {
			for (t = 1; t < SIZE; t++) {
				if (maxRow < maxCol) { // c연산
					for (int j = 1; j <= maxCol; j++) {
						int[] arr = new int[SIZE];

						for (int i = 1; i <= maxRow; i++) {
							if (map[i][j] == 0) {
								continue;
							}
							arr[map[i][j]]++;
						}

						for (int i = 1; i < SIZE; i++) {
							if (arr[i] != 0) {
								pq.add(new Node(i, arr[i]));
							}
						}

						int i = 0;
						while (!pq.isEmpty()) {
							Node n = pq.remove();
							map[++i][j] = n.key;
							map[++i][j] = n.value;
						}
						if (i > maxRow) {
							maxRow = i;
						}
						for (int l = i + 1; l < SIZE; l++) {
							map[l][j] = 0;
						}
						
					}
				} else { // r연산
					for (int i = 1; i <= maxRow; i++) {
						int[] arr = new int[SIZE];

						for (int j = 1; j <= maxCol; j++) {
							if (map[i][j] == 0) {
								continue;
							}
							arr[map[i][j]]++;
						}

						for (int j = 1; j < SIZE; j++) {
							if (arr[j] != 0) {
								pq.add(new Node(j, arr[j]));
							}
						}

						int j = 0;
						while (!pq.isEmpty()) {
							Node n = pq.remove();
							map[i][++j] = n.key;
							map[i][++j] = n.value;
						}
						if (j > maxCol) {
							maxCol = j;
						}
						for (int l = j + 1; l < SIZE; l++) {
							map[i][l] = 0;
						}
					}
				}
				
				if (map[r][c] == k) {
					break;
				}
			}
		}

		if (t > 100) {
			System.out.println(-1);
		} else {
			System.out.println(t);
		}
	}

	public static class Node implements Comparable<Node> {
		int key, value;

		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public int compareTo(Node that) {
			if (this.value < that.value) {
				return -1;

			} else if (this.value == that.value) {
				if (this.key < that.key) {
					return -1;

				} else if (this.key == that.key) {
					return 0;

				} else {
					return 1;

				}
			} else {
				return 1;
			}
		}
	}
}
