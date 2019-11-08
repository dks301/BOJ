package realization;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Woo6 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int total = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		String[] logs = new String[n];
		for (int i = 0; i < n; i++) {
			logs[i] = br.readLine();
		}
		
		String[] answer = solution(total, logs);
		for (String next : answer) {
			System.out.println(next);
		}
	}
	
	public static String[] solution(int totalTicket, String[] logs) {
		ArrayList<String> answerList = new ArrayList<>();
		Queue<Log> logQueue = new LinkedList<>();
		
		for (int i = 0; i < logs.length; i++) {
			if (totalTicket == 0) {
				break;
			}
			
			StringTokenizer st = new StringTokenizer(logs[i]);
			String id = st.nextToken();
			String action = st.nextToken();
			long time = toSecond(st.nextToken());
			if (action.equals("leave")) {
				long diff = time - logQueue.remove().time;
				if (diff == 60 && !alreadyTicketing(answerList, id)) {
					answerList.add(id);
					totalTicket--;
				}
				continue;
			}
			
			if (logQueue.isEmpty()) {
				logQueue.add(new Log(id, action, time));
				
			} else {
				Log prev = logQueue.remove();
				Log cur = new Log(id, action, time);
				
				long diff = cur.time - prev.time;
				if (diff >= 60) {
					if (!alreadyTicketing(answerList, prev.id)) {
						answerList.add(prev.id);
						totalTicket--;
					}
					logQueue.add(cur);
					
				} else {
					logQueue.add(prev);
				}
			}
		}
		
		if (!logQueue.isEmpty()) { // 마지막 request 체크
			Log prev = logQueue.remove();
			long diff = toSecond("10:00:00") - prev.time;
			if (diff >= 60) {
				if (!alreadyTicketing(answerList, prev.id) && totalTicket != 0) {
					answerList.add(prev.id);
				}
			}
		}
		
		String[] answer = answerList.toArray(new String[answerList.size()]);
		Arrays.sort(answer);
		
		return answer;
	}
	
	public static long toSecond(String t) {
		long sec = 0;
		StringTokenizer st = new StringTokenizer(t, ":");
		sec += (Long.parseLong(st.nextToken()) * 3600); // hh
		sec += (Long.parseLong(st.nextToken()) * 60); // mm
		sec += Long.parseLong(st.nextToken()); // ss
		
		return sec;
	}
	
	public static boolean alreadyTicketing(ArrayList<String> answerList, String id) {
		for (String next : answerList) {
			if (next.equals(id)) {
				return true;
			}
		}
		return false;
	}
	
	public static class Log {
		String id, action;
		long time;
		
		public Log(String id, String action, long time) {
			this.id = id;
			this.action = action;
			this.time = time;
		}
	}
}
