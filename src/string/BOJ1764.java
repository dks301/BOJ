package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BOJ1764 {
	private static final char NEW_LINE = '\n';
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashSet<String> names = new HashSet<>();
		for (int i = 0; i < N; i++) {
			names.add(br.readLine());
		}
		
		TreeSet<String> result = new TreeSet<>();
		for (int i = 0; i < M; i++) {
			String temp = br.readLine();
			if (!names.add(temp)) {
				result.add(temp);
			}
		}

		StringBuilder sb = new StringBuilder();
		sb.append(result.size()).append(NEW_LINE);
		Iterator<String> it = result.iterator();
		while (it.hasNext()) {
			sb.append(it.next()).append(NEW_LINE);
		}
		System.out.print(sb.toString());
	}
	
}
