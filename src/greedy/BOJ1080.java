package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 행렬
 * 0과 1로만 이루어진 행렬A와 B
 * 변환 연산은 3x3부분 행렬을 0->1, 1->0
 * 
 * 입력
 * 첫째 줄: 크기 N M, 50보다 작거나 같은 자연수
 * 둘째 줄~N개 줄: 행렬 A
 * 그 다음줄~N개 줄: 행렬 B
 * 
 * 출력
 * 행렬 A를 행렬 B로 바꾸는데 필요한 연산의 최솟값, 바꿀 수 없다면 -1 출력
 */
public class BOJ1080 {
	private static boolean[][] A, B;
	private static int N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		A = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				A[i][j] = temp[j] == '0' ? false : true;
			}
		}

		B = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				B[i][j] = temp[j] == '0' ? false : true;
			}
		}

		if (N < 3 || M < 3) {
			System.out.println(isSame() ? 0 : -1);
		
		} else {
			int ans = 0;
			for (int i = 0; i < N - 2; i++) {
				for (int j = 0; j < M - 2; j++) {
					if (A[i][j] != B[i][j]) {
						operation(i, j);
						ans++;
					}
				}
			}
			System.out.println(isSame() ? ans : -1);
		}
	}

	public static void operation(int row, int cal) {
		for (int i = row; i < row + 3; i++) {
			for (int j = cal; j < cal + 3; j++) {
				A[i][j] = !A[i][j];
			}
		}
	}

	public static boolean isSame() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (A[i][j] != B[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}
