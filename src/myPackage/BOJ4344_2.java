package myPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ4344_2 {

  private static final String NEW_LINE = "\n";
  private static final String PERCENT = "%";

  public static void main(String[] args) throws IOException {
    final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    final int C = Integer.parseInt(reader.readLine());

    final StringBuilder builder = new StringBuilder();
    for (int i = 0; i < C; i++) {
      final StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
      final int N = Integer.parseInt(tokenizer.nextToken());
      final Double[] scores = new Double[N];
      for (int j = 0; j < N; j++) {
        scores[j] = Double.parseDouble(tokenizer.nextToken());
      }
      
      builder.append(String.format("%.3f", solution(scores))).append(PERCENT).append(NEW_LINE);
    }

    System.out.println(builder);
  }

  public static Double solution(final Double[] scores) {
    Double total = 0D;

    for (final Double score : scores) {
      total += score;
    }

    Double average = total / scores.length;
    double count = 0;
    for (final Double score : scores) {
      if (average < score) {
        count++;
      }
    }
    return count / scores.length * 100;
  }
}
