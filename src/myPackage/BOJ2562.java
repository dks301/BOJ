package myPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BOJ2562 {
  public static void main(String[] args) throws IOException {
    final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    final List<Number> inputs = new ArrayList<>(9);
    for (int i = 0; i < 9; i++) {
      inputs.add(new Number(Integer.parseInt(reader.readLine()), i + 1));
    }

    final Number result = solve(inputs);
    System.out.println(result.value);
    System.out.println(result.index);
  }

  public static Number solve(final List<Number> numbers) {
    return numbers.stream().max(Comparator.comparing(a -> a.value)).get();
  }

  public static class Number {
    final Integer value;
    final int index;

    public Number(final Integer value, final int index) {
      this.value = value;
      this.index = index;
    }
  }
}
