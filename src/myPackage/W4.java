package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class W4 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		solution(new String[]{"aa bb", "ac bb"}, new String[]{"LOGIN bb aa"}); // 로그인 시도하는 id가 null이면 error
	}
	
	public static boolean[] solution(String[] infos, String[] actions) {
        boolean[] answer = new boolean[actions.length];
        Server s = new Server(infos);
        
        for (int i = 0; i < actions.length; i++) {
        	answer[i] = s.doAction(actions[i]);
        }
        return answer;
    }
	
	public static class Server {
		HashMap<String, String> infos;
		boolean login;
		boolean order;
		
		public Server(String[] infos) {
			this.infos = new HashMap<>();
			login = false;
			order = false;
			
			for (int i = 0; i < infos.length; i++) {
				StringTokenizer st = new StringTokenizer(infos[i]);
				String id = st.nextToken();
				String password = st.nextToken();
				this.infos.put(id, password);
			}
		}
		
		public boolean doAction(String action) {
			StringTokenizer st = new StringTokenizer(action);
			String ac = st.nextToken();
			switch(ac) {
			case "ADD":
				return add();
				
			case "LOGIN":
				String id = st.nextToken();
				String password = st.nextToken();
				return login(id, password);
				
			case "ORDER":
				return order();
			}
			return false;
		}
		
		public boolean add() {
			if (login) {
				order = true;
				return true;
			} else {
				return false;
			}
		}
		
		public boolean login(String id, String p) {
			if (login) {
				return false;
			} else {
				String rp = infos.get(id);
				if (rp.equals(p)) {
					login = true;
					return true;
				} else {
					return false;
				}
			}
		}
		
		public boolean order() {
			if (order) {
				order = false;
				return true;
			} else {
				return false;
			}
		}
	}
}
