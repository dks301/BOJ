package realization;
/*
 * Yee
 * Ba ba ba ba, ba, ba ba, baa, ba ba
 * Ba ba ba ba, ba, ba ba Yee
 * 반복주기 7초, 총 영상 길이 7200초
 * answer가 Yee초
 * 정답이 나오는 영상의 시간을 구해서 정답을 입력.
 */
public class BOJ15643 {
	public static void main(String[] args){
		// O(logL)
		for (int i = 0; i <= 7200; i += 7) {
			for (int j = 2; j <= 7200; j += 7) {
				if (i + j == 7198 && i == 6377) {
					System.out.println("x: " + i + ", y: " + j);
				}
			}
		}
	}
}
