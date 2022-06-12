package myPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class BOJ4344 {
  public static final String PERCENT = "%";
  public static final String NEW_LINE = "\n";

  public static void main(String[] args) throws IOException {
    final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    final int C = Integer.parseInt(reader.readLine());
    final StringBuilder builder = new StringBuilder();
    for (int i = 0; i < C; i++) {
      final StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
      final int N = Integer.parseInt(tokenizer.nextToken());

      builder.append(String.format("%.3f", solve(tokenizer, N))).append(PERCENT).append(NEW_LINE);
    }

    System.out.println(builder);
  }

  private static Double solve(final StringTokenizer tokenizer, final int N) {
    final List<Double> scores = new ArrayList<>();
    for (int j = 0; j < N; j++) {
      scores.add(Double.parseDouble(tokenizer.nextToken()));
    }

    final Double average = calculateAverageBy(scores);

    return (double) scores.stream().filter(score -> score > average).count() / N * 100.0;
  }

  private static Double calculateAverageBy(final List<Double> scores) {
    return scores.stream().collect(Collectors.averagingDouble(it -> it));
  }
}
