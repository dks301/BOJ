package myPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class W3 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] prices = new int[3];
		prices[0] = 143673;
		prices[1] = 88000;
		prices[2] = 10000;
		int[] discounts = new int[2];
		discounts[0] = 30;
		discounts[1] = 20;
		System.out.println((double)1/2);
		System.out.println(solution(prices, discounts));
	}
	
	public static int solution(int[] prices, int[] discounts) {
        int answer = 0;
        Arrays.sort(prices);
        Arrays.sort(discounts);
        
        int priceTop = prices.length - 1;
        int couponTop = discounts.length - 1;
        
        for (int i = priceTop; i >= 0; i--) {
        	if (couponTop >= 0) {
        		answer += ((double)prices[i] / 100) * (100 - discounts[couponTop]);
        		System.out.println(((double)prices[i] / 100) * (100 - discounts[couponTop]));
        		couponTop--;
        	} else {
        		answer += prices[i];
        	}
        }
        
        return answer;
    }
}
