package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Kakao1 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] record = new String[5];

		for (int i = 0; i < 5; i++) {
			record[i] = br.readLine();
		}
		solution(record);
	}

	public static String[] solution(String[] record) {
		String[] temp = new String[record.length];
		String[] inout = new String[record.length];
		String[] answer;
		int length = 0;
		HashMap hm = new HashMap();

		for (int i = 0; i < record.length; i++) {
			String tempId = "";
			StringTokenizer st = new StringTokenizer(record[i]);
			switch (st.nextToken()) {
			case "Enter":
				tempId = st.nextToken();
				hm.put(tempId, st.nextToken());
				temp[length] = tempId;
				inout[length++] = "´ÔÀÌ µé¾î¿Ô½À´Ï´Ù.";
				break;
			case "Leave":
				tempId = st.nextToken();
				temp[length] = tempId;
				inout[length++] = "´ÔÀÌ ³ª°¬½À´Ï´Ù.";
				break;
			case "Change":
				tempId = st.nextToken();
				hm.put(tempId, st.nextToken());
				break;
			}
		}
		answer = new String[length];

		for (int i = 0; i < length; i++) {
			answer[i] = hm.get(temp[i]).toString() + inout[i];
		}

		return answer;
	}
}
