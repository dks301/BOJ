package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SCPCRound2_3 {
	private static final String CASE = "Case #";
	private static final char NEW_LINE = '\n';
	private static final char SPACE = ' ';
	
	private static int L, S, E, A, B;
	private static ArrayList<Info> ceil, floor;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringBuilder sb = new StringBuilder();
			sb.append(CASE).append(t).append(NEW_LINE);
			StringTokenizer st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			S = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			A = Integer.parseInt(br.readLine());
			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine());
				ceil.add(new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}
			B = Integer.parseInt(br.readLine());
			for (int i = 0; i < B; i++) {
				st = new StringTokenizer(br.readLine());
				floor.add(new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}
			
			if (E - S > 0) {
				int i = 0, j = 0, top = E, now = S;
				long area = 0;
				while (i < A && j < B) {
					if (ceil.get(i).h > ceil.get(i + 1).h) {
						area += ceil.get(i).len * now;
						
					}
				}
			} else {
				
			}
			
		}
	}
	
//	public static void merge(int A, int B, int cur) {
//		int i = 0, j = 0, k = 0;
//		int now = cur;
//		int area = 0;
//		while (i < A && j < B) {
//			if (ceil.get(i).len >= floor.get(j).len) {
//				if (ceil.get(i + 1).h < cur) {
//					area = ceil.get(i).len * 
//				}
//				result[k++] = A[i++];
//			} else {
//				result[k++] = B[j++];
//			}
//		}
//		
//		while (i < N) {
//			result[k++] = A[i++];
//		}
//		while (j < M) {
//			result[k++] = B[j++];
//		}
//	}
	
	public static class Info {
		int len, h;
		
		public Info(int len, int h) {
			this.len = len;
			this.h = h;
		}
	}
}
