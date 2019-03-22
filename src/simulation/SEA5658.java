package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class SEA5658 {
	private static final String NUMBER = "#";
	private static final String SPACE = " ";
	private static final String NEW_LINE = "\n";
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			sb.append(NUMBER).append(t).append(SPACE);
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			String in = br.readLine();
			int[] val = hexToInt(in, N);
			TreeSet<Integer> ts = new TreeSet<>();
			for (int v : val) {
				ts.add(v);
			}
			
			for (int i = 0; i < N / 4; i++) {
				in = rotate(in);
				
				val = hexToInt(in, N);
				for (int v : val) {
					ts.add(v);
				}
			}
			Iterator it = ts.descendingIterator();
			int cnt = 0;
			while (it.hasNext()) {
				if (cnt == K - 1) {
					sb.append(it.next());
					break;
				}
				it.next();
				cnt++;
			}
			
			sb.append(NEW_LINE);
		}
		System.out.print(sb);
	}
	
	public static int[] hexToInt(String in, int n) {
		int size = n / 4;
		
		int[] val = new int[4];
		for (int i = 0; i < 4; i++) {
			val[i] = Integer.parseInt(in.substring((i * size), ((i * size) + size)), 16);
		}
		
		return val;
	}
	
	public static String rotate(String in) {
		return (in.charAt(in.length() - 1) + in.substring(0, in.length() - 1));
	}
}
