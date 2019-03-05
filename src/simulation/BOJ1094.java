package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
/*
 * 막대기
 * 초기에는 64cm 막대 하나만 가지고 있다.
 * 이 때, 합이 X보다 크다면, 아래와 같은 과정을 반복한다.
 * 1. 가지고 있는 막대 중 길이가 가장 짧은 것을 절반으로 자른다.
 * 2. 만약, 위에서 자른 막대의 절반 중 하나를 버리고 남아있는 막대의 길이의 합이 X보다 크거나 같다면, 위에서 자른 막대의 절반 중 하나를 버린다.
 * 남아있는 막대를 모두 붙여 Xcm를 만든다.
 * 몇 개의 막대로 Xcm를 만들 수 있는지 출력.
 */
public class BOJ1094 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine());
		
		int pipe = 64;
		LinkedList<Integer> list = new LinkedList<>();
		list.add(64);
		int total = 64;
		
		while (total > X) {
			pipe /= 2;
			list.removeFirst();
			list.addFirst(pipe);
			list.addFirst(pipe);
			
			total -= pipe;
			if (total >= X) {
				list.removeFirst();
			} else {
				total += pipe;
			}
		}
		
		System.out.println(list.size());
	}
}
