package myPackage;

import java.util.Arrays;

public class BOJ15596 {
  public static long sum(int[] a) {
    return Arrays.stream(a)
            .mapToLong(it -> it) // LongStream -> long
            .sum();
  }
}

