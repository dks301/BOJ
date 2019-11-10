package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class W7 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
	}
	
	public static String[] solution(String user, String[][] friends, String[] visitors) {
        HashMap<String, Integer> userScore = new HashMap<>();
        HashSet<String> alreadyFriend = new HashSet<>();
        
        for (int i = 0; i < friends.length; i++) { // 이미 친구인지 아닌지 분류
        	String A = friends[i][0];
        	String B = friends[i][1];
        	if (A.equals(user)) {
        		alreadyFriend.add(B);
        	} else if (B.equals(user)) {
        		alreadyFriend.add(A);
        	}
        }
        
        for (int i = 0; i < friends.length; i++) {
        	String A = friends[i][0];
        	String B = friends[i][1];
        	if (alreadyFriend.contains(A) && !B.equals(user)) {
        		if (userScore.containsKey(B)) {
            		userScore.put(B, userScore.get(B) + 10);
            	} else {
                	userScore.put(B, 10);	
            	}
        		
        	} else if (alreadyFriend.contains(B) && !A.equals(user)) {
        		if (userScore.containsKey(A)) {
            		userScore.put(A, userScore.get(A) + 10);
            	} else {
                	userScore.put(A, 10);	
            	}
        	}
        	
        }
        
        for (String next : visitors) { // 방문자 점수 추가하기
        	if (alreadyFriend.contains(next) || next.equals(user)) {
        		continue; // 친구가 방문하거나 자기자신이 방문하면 넘어가기
        	}
        	
        	if (userScore.containsKey(next)) {
        		userScore.put(next, userScore.get(next) + 1);
        	} else {
            	userScore.put(next, 1);	
        	}
        }
        
        ArrayList<User> result = new ArrayList<>();
        for (String next : userScore.keySet()) {
        	result.add(new User(next, userScore.get(next)));
        }
        
        Collections.sort(result);
        int size = result.size() > 5 ? 5 : result.size();
        String[] answer = new String[size];
        
        for (int i = 0; i < size; i++) {
        	answer[i] = result.get(i).name;
        }
        
        return answer;
    }
	
	public static class User implements Comparable<User> {
		String name;
		int score;
		
		public User(String name, int score) {
			this.name = name;
			this.score = score;
		}
		
		@Override
		public int compareTo(User that) {
			// TODO Auto-generated method stub
			if (this.score < that.score) {
				return 1;
			} else if (this.score == that.score) {
				return this.name.compareTo(that.name);
			} else {
				return -1;
			}
		}
	}
}
