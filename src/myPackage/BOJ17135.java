package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 캐슬 디펜스
 * 크기가 NxM인 격자판, 각 칸에 포함된 적의 수는 최대 하나
 * 격자판의 N번행 바로 아래(N+1번행)의 모든 칸에는 성이있다
 * 궁수 3명을 성에 배치, 하나의 칸에 최대 1명, 각 턴마다 궁수는 적 하나 공격 가능
 * 궁수가 공격하는 적은 거리가 D이하인 가장 가까운 적, 이런 적이 여려명일 경우 가장 왼쪽에 있는 적 공격
 * 같은 적이 여러 궁수에게 공격당할 수 있다. 공격받은 적은 게임에서 제외
 * 궁수의 공격이 끝나면 적이 아래로 한 칸 이동, 성에 도달하면 게임에서 제외, 모든 적이 제외되면 게임 끝
 * 격자판의 상태가 주어졌을 때, 궁수의 공격으로 제거할 수 있는 적의 최대 수 출력
 * 격자판의 두 위치 (r1,c1), (r2,c3)의 거리는 |r1-r2| + |c1-c2|
 * 
 * 첫쨰줄: 행N, 열M, 궁수사거리D(3<=N,M<=15, 1<=D<=10)
 * 둘째줄~N개줄: 격자판 상태 0은 빈 칸, 1은 적이 있는 칸
 */
public class BOJ17135 {
	private static int N, M, D;
	private static boolean[][] map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		combination(new int[3], 0, 6, 3, 0);
	}
	
	public static void combination(int[] arr, int index, int n, int r, int target) {
		if (r == 0) {
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		} else if (target == n) {
			return;
		} else {
			arr[index] = target;
			combination(arr, index + 1, n, r - 1, target + 1);
			combination(arr, index, n, r, target + 1);
		}
	}
}
