package myPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1110 {
  public static void main(String[] args) throws IOException {
      final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      final int value = Integer.parseInt(reader.readLine());

      System.out.println(solve(value));
  }

  public static int solve(final int value) {
      int count = 0;
      int nextValue = value;

      while (true) {
          final int[] tensAndUnits = divideTensAndUnits(nextValue);
          nextValue = calculateNext(tensAndUnits[1], divideTensAndUnits(tensAndUnits[0] + tensAndUnits[1])[1]);
          count++;

          if (nextValue == value) {
              return count;
          }
      }
  }

  public static int[] divideTensAndUnits(final int value) {
      if (value < 10) {
          return new int[] {0, value};
      }
      return new int[] {value / 10, value % 10};
  }

  public static int calculateNext(final int originUnits, final int sumUnits) {
      return originUnits * 10 + sumUnits;
  }
}
