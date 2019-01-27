package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1764 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashSet names = new HashSet();
		for (int i = 0; i < N; i++) {
			names.add(br.readLine());
		}
		List<String> result = new ArrayList<String>();
		for (int i = 0; i < M; i++) {
			String temp = br.readLine();
			if (!names.add(temp)) {
				result.add(temp);
			}
		}
		Collections.sort(result);
		StringBuilder sb = new StringBuilder();
		sb.append(result.size() + "\n");
		for (int i = 0; i < result.size(); i++) {
			sb.append(result.get(i) + "\n");
		}
		System.out.println(sb.toString());
	}
	
}
