package myPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SA1 {
  private static int MAX = 1;

  public static void main(String[] args) throws IOException {
    // N = 8, abbababb , 5
    final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    final String input = bufferedReader.readLine();

    for (int i = 0; i < input.length(); i++) {
      for (int j = i + 1; j <= input.length(); j++) {
        final String substring = input.substring(i, j);
        if (recurse(substring) && MAX <= substring.length()) {
          MAX = substring.length();
        }
      }
    }

    System.out.println(MAX);
  }


  private static boolean recurse(final String value) {
    for (int i = 0; i < value.length(); i++) {
      for (int j = i + 1; j <= value.length(); j++) {
        final boolean solve = solve(value.substring(i, j));
        if (!solve) {
          return false;
        }
      }
    }
    return true;
  }

  private static boolean solve(final String value) {
    final int[] AB = countAB(value);
    final int abs = Math.abs(AB[0] - AB[1]);
    if (abs == 0 || abs == 1) {
      return true;
    }
    return false;
  }

  private static int[] countAB(final String value) {
    final int[] counts = new int[2];
    for (final char c : value.toCharArray()) {
      if (c == 'a') {
        counts[0]++;
      } else {
        counts[1]++;
      }
    }
    return counts;
  }
}
