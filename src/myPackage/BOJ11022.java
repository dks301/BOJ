package myPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.BiFunction;
import java.util.function.Function;

public class BOJ11022 {
  private static final BiFunction<Integer, Integer, Integer> SUM = Integer::sum;
  private static final String CASE = "Case #";
  private static final String COLON = ": ";
  private static final String PLUS = " + ";
  private static final String EQUAL = " = ";
  private static final String NEW_LINE = "\n";

  public static void main(String[] args) throws IOException {
    final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    final int N = Integer.parseInt(reader.readLine());

    final StringBuilder builder = new StringBuilder();
    for (int i = 1; i <= N; i++) {
      final StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
      final int A = Integer.parseInt(tokenizer.nextToken());
      final int B = Integer.parseInt(tokenizer.nextToken());
      builder
          .append(CASE)
          .append(i)
          .append(COLON)
          .append(A)
          .append(PLUS)
          .append(B)
          .append(EQUAL)
          .append(SUM.apply(A, B))
          .append(NEW_LINE);
    }

    System.out.println(builder);
  }
}
