package realization;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class W1 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
	}
	
	public static int solution(int[] restaurant, int[][] riders, int k) { // 레스토랑 (x,y), riders(x,y) 최대 1,000, 반경k
        int answer = 0;
        
        for (int i = 0; i < riders.length; i++) {
        	double dist = distance(restaurant, riders[i]);
        	if (dist <= k) {
        		answer++;
        	}
        }
        return answer;
    }
	
	public static double distance(int[] a, int[] b) { // a와 b사이의 거리 구하기
		return Math.sqrt(Math.pow(a[0] - b[0], 2) + (Math.pow(a[1] - b[1], 2)));
	}
}