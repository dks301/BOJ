package realization;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
 * 숫자 맞추기
 * '스탠'은 1과 10사이 정수 하나를 생각하고 '올리'는 맞추기.
 * 올리가 말한수가 큰지 작은지 일치하는지 스탠이 말해준다.
 * 
 * 입력
 * 각 게임: 첫줄- 올리가 외친 수(1이상, 10미만)
 *       두번째줄- too high, too low, right on중 하나
 *       반복하다가 right on이 들어오면 한 게임이 끝
 * 마지막 줄에는 0을 입력
 * 
 * 출력
 * 각각의 게임에 대해서,
 * 스탠이 거짓말을 한 적이 있다면: Stan is dishonest
 * 없다면: Stan may be honest 
 */
public class BOJ4335 {
	private static final String HONEST = "Stan may be honest";
	private static final String DISHONEST = "Stan is dishonest";
	private static final String NEW_LINE = "\n";
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int Ollie;
		char Stan;
		
		ArrayList<Integer> al = new ArrayList<>();
		ArrayList<Character> al2 = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		while (true) {
			Ollie = Integer.parseInt(br.readLine());
			if (Ollie == 0) {
				break;
			}

			Stan = br.readLine().charAt(4);
			if (Stan == 't') {
				boolean isHonest = true;
				for (int i = 0; i < al.size(); i++) {
					if (Ollie < al.get(i)) {
						isHonest = al2.get(i) == 'h' ? true : false;
					} else if (Ollie > al.get(i)) {
						isHonest = al2.get(i) == 'l' ? true : false;
					} else {
						isHonest = false;
					}
					
					if (!isHonest) {
						break;
					}
				}
				sb.append(isHonest ? HONEST : DISHONEST).append(NEW_LINE);
				al.clear();
				al2.clear();
			} else {
				al.add(Ollie);
				al2.add(Stan);
			}
		}
		
		System.out.print(sb);
	}
}
