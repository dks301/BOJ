package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 회의실 배정
 * 회의의 수 N(1<=N<=100,000)
 * 시작과 끝나는 시간 2^31-1보다 작거나 같은 자연수 또는 0
 * 회의가 겹치지 않고 최대로 사용할 수 있는 수 출력
 */
public class BOJ1931 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Meeting[] m = new Meeting[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			m[i] = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));	
		}
		
		Arrays.sort(m);
		
		int ans = 0;
		int prevEnd = -1;
		for (int i = 0; i < N; i++) {
			if (prevEnd > m[i].start) {
				continue;
			}
			
			prevEnd = m[i].end;
			ans++;
		}
		
		System.out.println(ans);
	}
	
	public static class Meeting implements Comparable<Meeting> {
		int start, end;
		
		public Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Meeting that) {
			if (this.end < that.end) {
				return -1;
			} else if (this.end == that.end) {
				if (this.start < that.start) {
					return -1;
				} else if (this.start == that.start) {
					return 0;
				} else {
					return 1;
				}
			} else {
				return 1;
			}
		}
	}
}
