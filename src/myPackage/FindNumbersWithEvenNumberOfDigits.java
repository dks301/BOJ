package myPackage;

import java.util.Arrays;

/*
   https://leetcode.com/explore/featured/card/fun-with-arrays/521/introduction/3237/
*/
public class FindNumbersWithEvenNumberOfDigits {
  public static void main(String[] args) {
    System.out.println(findNumbers(new int[] {12, 345, 2, 6, 7896}));
  }

  public static int findNumbers(int[] nums) {
    return (int)
        Arrays.stream(nums)
            .map(num -> String.valueOf(num).length())
            .filter(num -> num % 2 == 0)
            .count();
  }
}
