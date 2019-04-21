package sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
/*
 * 수 정렬하기2
 * Array.sort()는 최악의 경우 O(n^2)일 수 있으므로
 * Collections.sort()로 바꾸기
 */
public class BOJ2751 {
	private static final String NEW_LINE = "\n";
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		LinkedList<Integer> num = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			num.add(Integer.parseInt(br.readLine()));
		}
		
		Collections.sort(num);
		StringBuilder sb = new StringBuilder();
		
		Iterator<Integer> it = num.iterator();
		while (it.hasNext()) {
			sb.append(it.next()).append(NEW_LINE);
		}
		System.out.println(sb.toString());
	}
}
