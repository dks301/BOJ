package myPackage;

import java.util.Arrays;

/*
  https://leetcode.com/explore/featured/card/fun-with-arrays/521/introduction/3238/
 */
public class MaxConsecutiveOnes {
  public static void main(String[] args) {
    System.out.println(findMaxConsecutiveOnes(new int[]{1,0,1,1,0,1}));
  }

  public static int findMaxConsecutiveOnes(int[] nums) {
    if (Arrays.stream(nums).distinct().count() == 1) {
      return nums[0] == 1 ? nums.length : 0;
    }

    final int[] max = new int[nums.length];

    for (int i = 1; i < nums.length; i++) {
      if (nums[i - 1] == 1 && nums[i] == 1) {
        max[i] = max[i - 1] + 1;
      }
    }

    return Arrays.stream(max).max().getAsInt() + 1;
  }
}
