package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * 바둑이 포커
 * 앞면에는 1-15의 자연수, 뒷면은 검은색또는 흰색인 30장짜리 트럼프 카드
 * 카드 한장을 표현할 때는 숫자는 16진수, 색은 b/w
 * 두장씩 한쌍으로 약식 포커를 진행하는데 서열은
 * 1. 연속된 수(1과 f는 연속)
 * 2. 같은 수
 * 3. 그 외
 * 위에서 같은 서열일 경우
 *     1. 색이 같은 쌍
 *     2. 큰 수가 큰 쪽
 *     3. 작은 수가 큰 쪽
 *     4. 큰 수가 검은색
 * 순차적으로 낮은 단계에서 비교가 안 될 경우만 다음 단계로 넘어가서 비교
 * 카드 쌍에서 두 장의 순서는 입력받은 카드 순
 * 
 * 입력
 * 첫째줄: 중복이 아닌 임의의 카드 6장을 ','로 구분해서 입력
 * 
 * 출력
 * 모든 카드쌍의 경우의 수를 서열순으로 출력
 */
public class BOJ17292 {
	private static ArrayList<Card> al;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), ",");
		al = new ArrayList<>();
		for (int i = 0; i < 6; i++) {
			al.add(new Card(st.nextToken()));
		}
		
		
	}
	
	public static class Card {
		int num;
		boolean color;
		
		public Card(String in) {
			char[] temp = in.toCharArray();
			this.num = Integer.parseInt(temp[0] + "", 16);
			this.color = temp[1] == 'b' ? true : false;
		}
	}
}
