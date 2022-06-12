package myPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ8958 {

  public static final String NEW_LINE = "\n";

  public static void main(String[] args) throws IOException {
    final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    final int N = Integer.parseInt(reader.readLine());

    final StringBuilder builder = new StringBuilder();
    for (int i = 0; i < N; i++) {
      builder.append(solve(reader.readLine().toCharArray())).append(NEW_LINE);
    }
    System.out.println(builder);
  }

  public static int solve(final char[] ox) {
    final int[] scores = new int[ox.length];
    for (int i = 0; i < ox.length; i++) {
      if (ox[i] == 'O') {
        scores[i] = 1;
      } else {
        scores[i] = 0;
      }
    }

    for (int i = 0; i < ox.length; i++) {
      if (scores[i] != 0 && i > 0) {
        scores[i] += scores[i - 1];
      }
    }

    return Arrays.stream(scores).sum();
  }
}
