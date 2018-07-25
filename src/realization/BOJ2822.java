package success;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;

public class BOJ2822 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();
		for (int i = 1; i <= 8; i++) {
			hs.put(i, Integer.parseInt(br.readLine()));
		}
		
		int result = 0;
		int[] num = new int[5];
		Iterator it = sortByValue(hs).iterator();
		for (int i = 0; i < 5; i++) {
			int temp = (int)it.next();
			result += hs.get(temp);
			num[i] = temp;
		}
		
		Arrays.sort(num);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 5; i++) {
			sb.append(num[i] + " ");
		}
		System.out.println(result);
		System.out.println(sb.toString());
	}
	
	public static ArrayList sortByValue(final HashMap hm) {
		ArrayList<Integer> al = new ArrayList();
		al.addAll(hm.keySet());
		
		Collections.sort(al, new Comparator() {
			public int compare(Object o1, Object o2) {
				Object v1 = hm.get(o1);
				Object v2 = hm.get(o2);
				
				return ((Comparable)v2).compareTo(v1);
			}
		});
		return al;
	}
}
