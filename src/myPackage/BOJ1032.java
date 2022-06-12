package myPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class BOJ1032 {
  private static int[] patternNumber;

  public static void main(String[] args) throws IOException {
    final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    final int N = Integer.parseInt(bufferedReader.readLine());
    patternNumber = new int[27];
    Arrays.fill(patternNumber, N);

    final char[] first = bufferedReader.readLine().toCharArray();
    check(first);
    for (int i = 0; i < N - 1; i++) {
      check(bufferedReader.readLine().toCharArray());
    }

    final StringBuilder sb = new StringBuilder();
    for (final char alphabet : first) {
      if (alphabet == '.') {
        sb.append(patternNumber[0] == 0 ? alphabet : '?');
      } else {
        sb.append(patternNumber[alphabet - 'a' + 1] == 0 ? alphabet : '?');
      }
    }
    System.out.println(sb);
  }

  private static void check(final char[] chars) {
    for (final char c : chars) {
      if (c == '.') {
        patternNumber[0]--;
      } else {
        patternNumber[c - 'a' + 1]--;
      }
    }
  }
}
