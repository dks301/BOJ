package realization;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2108 {
	private static final String NEW_LINE = "\n";
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int [] nums = new int[N];
		double sum = 0;
		
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
			sum += nums[i];
		}
		double avg = sum / N;
		sCalculator(nums, avg, N);
	}
	
	private static void sCalculator(int[] nums, double avg, int N) {
		StringBuilder sb = new StringBuilder();
		sb.append(Math.round(avg)).append(NEW_LINE);
		
		Arrays.sort(nums);
		sb.append(nums[N / 2]).append(NEW_LINE);
		
		int[] countNums = new int[8001];
		for (int i = 0; i < N; i++) {
			countNums[nums[i] + 4000]++;
		}
		int countMax = 0;
		for (int i = 0; i < 8001; i++) {
			if (countNums[i] > countMax)
				countMax = countNums[i];
		}
		int countMode = 0;
		int modeIndex = -1;
		for (int i = 0; i < 8001; i++) {
			if (countNums[i] == countMax) {
				countMode++;
				modeIndex = i;
				if (countMode == 2)
					break;
			}
		}
		sb.append(modeIndex - 4000).append(NEW_LINE);
		
		sb.append(nums[N - 1] - nums[0]).append(NEW_LINE);
		System.out.println(sb.toString());
	}
}
