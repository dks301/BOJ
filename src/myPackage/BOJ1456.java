package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 거의 소수
 * 어떤 소수의 N 제곱 꼴일때, 그 수를 거의 소수라 한다.
 * A와 B가 주어질 때 A(<=10^14), B(A<=B<=10^14)
 * A <= 거의 소수 <= B 인 거의 소수의 수 출력.
 */
public class BOJ1456 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long A = Integer.parseInt(st.nextToken());
		long B = Integer.parseInt(st.nextToken());
	}
}
