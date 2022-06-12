package myPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.BiFunction;

public class BOJ1330 {

  public static final String SPACE = " ";

  public static void main(String[] args) throws IOException {
    final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    final int[] numbers =
        Arrays.stream(reader.readLine().split(SPACE)).mapToInt(Integer::parseInt).toArray();

    System.out.println();
  }

  public static void printEachSign(int[] numbers) {
      if (isGreaterThan(numbers[0], numbers[1])) {
        System.out.println();
      }
      if (isLessThan(numbers[0], numbers[1])) {

      }
      if (isEquals(numbers[0], numbers[1])) {

      }
  }

  public static boolean isGreaterThan(final int a, final int b) {
      return a > b;
  }

  public static boolean isLessThan(final int a, final int b) {
      return a < b;
  }

  public static boolean isEquals(final int a, final int b) {
      return a == b;
  }
}
