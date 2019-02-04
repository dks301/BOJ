package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * ���丮�� 0�� ����
 * N!�� �ڿ������� ó�� 0�� �ƴ� ���ڰ� ���� ������ 0�� ���� ���
 */
public class BOJ1676 {
	private static final int FIVE = 5;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int cntFive = 0;
		for (int i = 1; i <= N; i++) {
			int temp = i;
			while (temp % FIVE == 0) {
				temp /= FIVE;
				cntFive++;
			}
		}
		System.out.println(cntFive);
	}
}