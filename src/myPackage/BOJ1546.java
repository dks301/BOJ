package myPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class BOJ1546 {
  public static void main(String[] args) throws IOException {
    final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    final int N = Integer.parseInt(reader.readLine());

    final StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
    final List<Double> scores = new ArrayList<>(N);
    for (int i = 0; i < N; i++) {
      scores.add(Double.parseDouble(tokenizer.nextToken()));
    }

    System.out.println(solve(scores));
  }

  public static Double solve(final List<Double> scores) {
    final Double maximum = max(scores);
    return scores.stream() // 40 80 60
            .map(score -> (score / maximum) * 100) // f(40), f(80) f(60)
            .collect(Collectors.averagingDouble(it -> it));
  }

  public static Double max(final List<Double> scores) {
    return scores.stream() //Stream<Double> -> Double //   DoubleStream -> double
            .mapToDouble(Double::doubleValue).max().getAsDouble();
  }
}
