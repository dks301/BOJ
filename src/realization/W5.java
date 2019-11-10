package realization;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class W5 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] history = new String[]{"2.0", "2.5", "2.5"};
		solution(history);
	}
	
	public static int[] solution(String[] history) {
        int[] answer = new int[history.length];
        Freeze f = new Freeze();
        
        for (int i = 0; i < history.length; i++) {
        	answer[i] = f.makeJok(history[i]);
        	f.setCostZero();
        	System.out.println(answer[i]);
        	if (answer[i] == -1) {
        		return new int[]{-1};
        	}
        }
        return answer;
    }
	
	public static class Freeze {
		int pig; // 10kg당 10,000원
		int onion; // 100g당 3,000원
		int leek; // 30cm 당 1,000원
		int garlic; // 50g당 2,000원 
		int pepper; // 10g당 1,000원
		int cost;
		
		public Freeze() {
			this.pig = 5;
			this.onion = 100;
			this.leek = 10;
			this.garlic = 5;
			this.pepper = 2;
			this.cost = 0;
		}
		
		public int makeJok(String history) {
			double serve = Double.parseDouble(history);
			if (serve < 1.0) { // 준이 굶는 경우
				return -1;
			} else {
				System.out.println("before " + pig + " " + onion + " " + leek + " " + garlic + " " + pepper);
				pig -= (4 * serve);
				if (pig < 0) {
					pig += 10;
					cost += 10000;
				}
				onion -= (50 * serve);
				if (onion < 0) {
					onion += 100;
					cost += 3000;
					if (onion <= 0) { // 한 번 더사야하는 경우
						onion += 100;
						cost += 3000;
						System.out.println("??ASDFasdfa");
					}
				}
				leek -= (10 * serve);
				if (leek < 0) {
					leek += 30;
					cost += 1000;
				}
				garlic -= (10 * serve);
				if (garlic < 0) {
					garlic += 50;
					cost += 2000;
				}
				
				if (serve == 1.0 || serve == 2.0) { // 준이 혼자 먹는 경우
					pepper -= (4 * serve);
				} else if (serve == 1.5 || serve == 2.5) { // 애인이 같이 먹는 경우
					pepper -= ((4 * serve) / 2);
				}
				
				if (pepper < 0) {
					pepper += 10;
					cost += 1000;
				}
			}
			System.out.println("after " + pig + " " + onion + " " + leek + " " + garlic + " " + pepper);
			System.out.println();
			return cost;
		}
		
		public void setCostZero() {
			this.cost = 0;
		}
	}
}
