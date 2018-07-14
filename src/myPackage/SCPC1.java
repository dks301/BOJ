package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class SCPC1 {
	static int Answer = 1;
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		TreeMap<Integer, Integer> tm = new TreeMap<Integer, Integer>();
		
		int T = sc.nextInt();
		for (int test_case = 0; test_case < T; test_case++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			
			for (int i = 1; i <= N; i++) {
				tm.put(sc.nextInt(), i);
			}
			
			Iterator it = tm.keySet().iterator();
			
			int key[] = {0, 0};
			int temp = 0;
			while (it.hasNext()) {
				key[0] = (int)it.next();
				if (!it.hasNext()) {
					if ((key[0] - temp > 0 ? key[0] - temp : temp - key[0]) <= K) {
						Answer++;
					}
					break;
				}
				key[1] = (int)it.next();
				temp = key[1];
				if ((key[0] - key[1] > 0 ? key[0] - key[1] : key[1] - key[0]) <= K) {
					Answer++;
				}
			}
			
			
			System.out.println("Case #" + (test_case + 1));
			System.out.println(Answer);
		}
	}
}
