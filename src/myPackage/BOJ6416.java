package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ6416 {
	private static final String SPACE = " ";
	
	public static void main(String[] args) throws Exception {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int k = 1;
		int tree = 0;
		
		while (true) {
			String temp = br.readLine();
			StringTokenizer st = new StringTokenizer(temp, SPACE);
			LinkedList<String> uv = new LinkedList<String>();
			
			while(true) {
				temp = st.nextToken();
				uv.add(temp);

				if (!st.hasMoreTokens()) {
					if (Integer.parseInt(uv.get(uv.size() - 1)) == 0 && Integer.parseInt(uv.get(uv.size() - 2)) == 0) {
						break;
					}
					else {
						st = new StringTokenizer(br.readLine(), SPACE);
					}
				}
			}

			for (int i = 0; i < uv.size() - 2; i = i + 2) {
				for (int j = 1; j < uv.size() - 2; j = j + 2) {
					if (uv.get(i).equals(uv.get(j))) {
						tree++;
					}
				}
			}
			
			temp = br.readLine();
			if (temp.isEmpty())
				continue;
			st = new StringTokenizer(temp, SPACE);
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			if (n1 < 0 && n2 < 0)
				break;
		}
	}
}
