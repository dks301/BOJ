package realization;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class W2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
	}
	
	public static int[] solution(String logs) { // "yyyy/mm/dd hh:mm:ss\nyyyy/mm/dd hh:mm:ss\n..." format logs 
        int[] answer = new int[24];
        StringTokenizer st = new StringTokenizer(logs, "\n");
        int logSize = st.countTokens();
        Log[] logArr = new Log[logSize];
        
        for (int i = 0; i < logSize; i++) {
        	logArr[i] = new Log(st.nextToken().split(" ")[1]); // hh:mm:ss만 필요 
        	logArr[i].hh = toKoreanHour(logArr[i].hh);
        	
        	answer[logArr[i].hh]++; // 시간대별로 로그가 몇개인지 체크
        }
        
        return answer;
    }
	
	public static int toKoreanHour(int hh) { // 24시 넘는것 처리
		return hh % 24;
	}
	
	
	public static class Log {
		int hh, mm, ss;
		
		public Log(String log) {
			StringTokenizer st = new StringTokenizer(log, ":");
			this.hh = Integer.parseInt(st.nextToken()) + 9; // 서울 UTC +09:00이라 +9
			this.mm = Integer.parseInt(st.nextToken());
			this.ss = Integer.parseInt(st.nextToken());
		}
	}
}
