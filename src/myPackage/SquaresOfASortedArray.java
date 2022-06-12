package myPackage;

import java.util.Arrays;

/*
   https://leetcode.com/explore/learn/card/fun-with-arrays/521/introduction/3240/
*/
public class SquaresOfASortedArray {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(sortedSquares2(new int[] {1,3,4,5})));
  }

  public static int[] sortedSquares(int[] nums) {
    return Arrays.stream(nums).map(num -> num * num).sorted().toArray();
  }

  public static int[] sortedSquares2(int[] nums) {
    final int[] result = new int[nums.length];
    int leftIdx = 0;
    int rightIdx = nums.length - 1;
    int resultIdx = nums.length - 1;

    while (leftIdx <= rightIdx) {
      if (squaresOf(nums[leftIdx]) > squaresOf(nums[rightIdx])) {
        result[resultIdx] = squaresOf(nums[leftIdx]);
        leftIdx++;
      } else {
        result[resultIdx] = squaresOf(nums[rightIdx]);
        rightIdx--;
      }
      resultIdx--;
    }

    return result;
  }

  public static int squaresOf(final int value) {
    return value * value;
  }
}
