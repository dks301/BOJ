package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class N1 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		HashMap<String, Integer> card = new HashMap<>();
		
		int type = 0;
		int max = 1;
		for (int i = 0; i < N; i++) {
			String next = st.nextToken();
			if (card.containsKey(next)) {
				int val = card.get(next);
				card.put(next, val + 1);
				if (max < val + 1) {
					max = val + 1;
				}
				
			} else {
				card.put(next, 1);
				type++;
			}
		}

		boolean isPossible = true;
		boolean isBuy = false;
		for (String next : card.keySet()) {
			if (card.get(next) == max) {
				continue;
			} else if (card.get(next) == max - 1){
				if (!isBuy) {
					isBuy = true;
					continue;
				} else {
					isPossible = false;
				}
			} else {
				isPossible = false;
				break;
			}
		}
		
		System.out.println(isPossible ? "Y" : "N");
		System.out.println(isBuy ? (isPossible ? N + 1 : N) : N);
		System.out.println(type);
	}
}
