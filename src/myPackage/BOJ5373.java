package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 큐빙
 * 큐브가 모두 풀린 상태에서 시작.
 * 위: 흰, 아래: 노랑, 앞: 빨, 뒤:주, 왼:초, 오:파
 * 큐브를 돌린 방법이 순서대로 주어질 때, 윗면의 색상 출력
 * 
 * 첫째줄: tc(최대 100개)
 * 각 tc 첫째줄: 큐뷰를 돌린 횟수 n(1<=n<=1000)
 * 각 tc 둘째줄: 큐브를 돌린 방법이 주어진다. 각 방법은 공백으로 구분되어져 있다 
 *            첫 번째 문자는 돌린 면이다.
 * U: 윗 면, D: 아랫 면, F: 앞 면, B: 뒷 면, L: 왼쪽 면, R: 오른쪽 면
 * 두 번째 문자는 돌린 방향이다. +인 경우에는 시계 방향 (그 면을 바라봤을 때가 기준), -인 경우에는 반시계 방향이다.
 * 
 * 각 테스트 케이스에 대해서 큐브를 모두 돌린 후의 윗 면의 색상을 출력한다.
 * 첫 번째 줄에는 뒷 면과 접하는 칸의 색을 출력하고, 두 번째, 세 번째 줄은 순서대로 출력하면 된다. 흰색은 w, 노란색은 y, 빨간색은 r, 오렌지색은 o, 초록색은 g, 파란색은 b.
 */
public class BOJ5373 {
	private static final String NEW_LINE = "\n";

	private static char[][][] cube = new char[5][5][5];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		while (tc-- > 0) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int t = 0; t < n; t++) {
				char[] way = st.nextToken().toCharArray();
				rotate(way[0], way[1]);
			}
		}
	}
	
	public static void rotate(char base, char d) {
		if (d == '+') { // 시계방향
			switch (base) {
			case 'U':
				char temp = cube[0][1][1];
				cube[0][1][1] = cube[0][3][1];
				cube[0][3][1] = cube[0][3][3];
				cube[0][3][3] = cube[0][1][3];
				cube[0][1][3] = temp;
				
				temp = cube[0][1][2];
				cube[0][1][2] = cube[0][2][1];
				cube[0][2][1] = cube[0][3][2];
				cube[0][3][2] = cube[0][2][3];
				cube[0][2][3] = temp;
				
				temp = cube[1][4][1];
				cube[1][4][1] = cube[1][3][4];
				cube[1][3][4] = cube[1][0][3];
				cube[1][0][3] = cube[1][1][0];
				cube[1][1][0] = temp;
				
				
				
				break;
				
			case 'D':
				break;
				
			case 'F':
				break;
				
			case 'B':
				break;
				
			case 'L':
				break;
				
			case 'R':
				break;
			}
		} else { // d == '-' 반시계방향
			
		}
	}
	
	public static void lnitialization() {
		for (int i = 1; i <= 3; i++) {
			for (int j = 1; j <= 3; j++) {
				cube[0][i][j] = 'w';
				cube[4][i][j] = 'y';
			}
		}
		
		for (int k = 1; k <= 3; k++) {
			for (int j = 1; j <= 3; j++) {
				cube[k][4][j] = 'r';
				cube[k][0][j] = 'o';
			}
		}
		
		for (int k = 1; k <= 3; k++) {
			for (int i = 1; i <= 3; i++) {
				cube[k][i][0] = 'g';
				cube[k][i][4] = 'b';
			}
		}
		cube[0][1][1] = 'w'; cube[0][1][2] = 'w'; cube[0][1][3] = 'w';
		cube[0][2][1] = 'w'; cube[0][2][2] = 'w'; cube[0][2][3] = 'w';
		cube[0][3][1] = 'w'; cube[0][3][2] = 'w'; cube[0][3][3] = 'w';
		
		cube[4][1][1] = 'y'; cube[4][1][2] = 'y'; cube[4][1][3] = 'y';
		cube[4][2][1] = 'y'; cube[4][2][2] = 'y'; cube[4][2][3] = 'y';
		cube[4][3][1] = 'y'; cube[4][3][2] = 'y'; cube[4][3][3] = 'y';
		
		cube[1][4][1] = 'r'; cube[1][4][2] = 'r'; cube[1][4][3] = 'r';
		cube[2][4][1] = 'r'; cube[2][4][2] = 'r'; cube[2][4][3] = 'r';
		cube[3][4][1] = 'r'; cube[3][4][2] = 'r'; cube[3][4][3] = 'r';
		
		cube[1][0][1] = 'o'; cube[1][0][2] = 'o'; cube[1][0][3] = 'o';
		cube[2][0][1] = 'o'; cube[2][0][2] = 'o'; cube[2][0][3] = 'o';
		cube[3][0][1] = 'o'; cube[3][0][2] = 'o'; cube[3][0][3] = 'o';

		cube[1][1][0] = 'g'; cube[1][2][0] = 'g'; cube[1][3][0] = 'g';
		cube[2][1][0] = 'g'; cube[2][2][0] = 'g'; cube[2][3][0] = 'g';
		cube[3][1][0] = 'g'; cube[3][2][0] = 'g'; cube[3][3][0] = 'g';

		cube[1][1][4] = 'b'; cube[1][2][4] = 'b'; cube[1][3][4] = 'b';
		cube[2][1][4] = 'b'; cube[2][2][4] = 'b'; cube[2][3][4] = 'b';
		cube[3][1][4] = 'b'; cube[3][2][4] = 'b'; cube[3][3][4] = 'b';
	}
}
