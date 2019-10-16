package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SWEA5658_2 {
	private static int N, K;
	private static HashSet<String> numSet;
	
	private static final char NUM = '#';
	private static final char SPACE = ' ';
	private static final char NEW_LINE = '\n';
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			sb.append(NUM).append(t).append(SPACE);
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			LinkedList<Character>[] passwords = new LinkedList[4];
			for (int i = 0; i < 4; i++) {
				passwords[i] = new LinkedList<>();
			}
			
			int size = N / 4;
			char[] digits = br.readLine().toCharArray();
			int cnt = 0;
			int j = 0;
			for (int i = 0; i < N; i++) {
				if (cnt == size) {
					cnt = 0;
					j++;
				}
				passwords[j].addLast(digits[i]);
				cnt++;
			}
			
			numSet = new HashSet<>();
			
			for (int i = 0; i < size; i++) {
				save(passwords, size);
				rotate(passwords);
			}
			
			int[] results = new int[numSet.size()];
			j = 0;
			for (String next : numSet) {
				results[j] = Integer.parseInt(next, 16);
				j++;
			}
			
			Arrays.sort(results);
			sb.append(results[numSet.size() - K]).append(NEW_LINE);
		}
		
		System.out.println(sb);
	}
	
	public static void save(LinkedList<Character>[] lists, int size) {
		for (int i = 0; i < 4; i++) {
			String s = "";
			for (int j = 0; j < size; j++) {
				char temp = lists[i].removeFirst();
				s += temp;
				lists[i].addLast(temp);
			}
			numSet.add(s);
		}
	}
	
	public static void rotate(LinkedList<Character>[] lists) {
		for (int i = 1; i < 4; i++) {
			lists[i].addFirst(lists[i - 1].removeLast());
		}
		lists[0].addFirst(lists[3].removeLast());
	}
}
