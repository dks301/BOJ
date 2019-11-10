package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class W6 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	}
	
	public static String[] solution(String[][] forms) {
        HashSet<String> result = new HashSet<>();
        HashMap<String, String> hm = new HashMap<>();
        
        for (int i = 0; i < forms.length; i++) {
        	String email = forms[i][0];
        	StringTokenizer st = new StringTokenizer(email, "@");
        	String eid = st.nextToken();
        	String domain = st.nextToken();
        	if (!domain.equals("email.com")) {
        		continue;
        	}
        	
        	char[] name = forms[i][1].toCharArray();
        	if (name.length == 1) { // 닉네임이 한글자인경우
        		continue;
        	}
        	
        	for (int j = 1; j < name.length; j++) {
        		String two = "" + name[j - 1] + name[j];
        		if (hm.containsKey(two)) {
        			result.add(email);
        			result.add(hm.get(two));
        			
        		} else {
        			hm.put(two, email);
        		}
        	}
        }
        int size = result.size();
        String[] answer = new String[size];
        
        int i = 0;
        for (String next : result) {
        	answer[i] = next;
        	i++;
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
}
