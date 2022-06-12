package myPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2577 {

  private static final String NEW_LINE = "\n";

  public static void main(String[] args) throws IOException {
    final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    final Integer value =
        Integer.parseInt(reader.readLine())
            * Integer.parseInt(reader.readLine())
            * Integer.parseInt(reader.readLine());

    final StringBuilder builder = new StringBuilder();
    for (final int result : solve(value)) {
      builder.append(result).append(NEW_LINE);
    }
    System.out.println(builder);
  }

  public static int[] solve(final Integer value) {
    final int[] result = new int[10];

    for (final char c : value.toString().toCharArray()) {
      final int number = c - '0';
      result[number]++;
    }

    return result;
  }
}
