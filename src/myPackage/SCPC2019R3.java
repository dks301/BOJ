package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SCPC2019R3 {
	private static final String CASE = "Case #";
	private static final String NEW_LINE = "\n";
	private static final int INF = 447215;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		long[] d = new long[INF]; // index가 jump
		int[] a = new int[INF]; // index가 val
		int k = 1;
		for (int i = 1; i <= 447214; i++) {
			d[i] = ((long) i * (i + 1)) / 2;
			if (k <= 447214) {
				for (int j = 0; j <= i; j++) {
					if (k <= 447214) {
						a[k++] = i + a[j];
					}
				}
			}
		}
		
//		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
//			sb.append(CASE).append(t).append(NEW_LINE);
			StringTokenizer st = new StringTokenizer(br.readLine());
			long x = Long.parseLong(st.nextToken());
			long y = Long.parseLong(st.nextToken());
			
			if (x < INF && y < INF) {
				int max = 0;
				while (x <= y) {
					if (max < a[(int)x]) {
						max = a[(int)x];
					}
					x++;
				}
				System.out.println(CASE + t + NEW_LINE + max);
			} else {
				System.out.println(CASE + t + NEW_LINE + 0);
			}
//			long l = x;
//			int idx = 0;
//			
//			int start = 0, end = a.length;
//			while (start <= end){
//				int mid = (start + end) / 2;
//				
//				if(l >= d[mid]){
//					start = mid + 1;
//					idx = mid;
//				} else if (d[mid] > l) {
//					end = mid - 1;
//				}
//			}
//			
//			int value = (int)(x - d[idx]);
//			int max = 0;
//			for (int i = value; i <= idx; i++) {
//				int temp = idx + a[i];
//				if (max < temp) {
//					max = temp;
//				}
//			}
			
//			for (int i = 0; i <= value; i++) {
//				int temp = idx + 1 + a[i];
//				if (max < temp) {
//					max = temp;
//				}
//			}
//			sb.append(max).append(NEW_LINE);
		}
//		System.out.println(sb);
	}
}
