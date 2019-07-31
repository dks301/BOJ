package binarySearchTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeSet;

/*
 * 회사에 있는 사람
 */
public class BOJ7785 {
	private static final char NEW_LINE = '\n';
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		TreeSet<String> Giggle = new TreeSet<>();
		while (n-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			String io = st.nextToken();
			switch (io) {
			case "enter":
				Giggle.add(name);
				break;
				
			case "leave":
				Giggle.remove(name);
				break;
			}
		}
		
		Iterator<String> it = Giggle.descendingIterator();
		StringBuilder sb = new StringBuilder();
		while (it.hasNext()) {
			sb.append(it.next()).append(NEW_LINE);
		}
		System.out.print(sb);
	}
}
