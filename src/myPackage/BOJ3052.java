package myPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public class BOJ3052 {

  private static final int MAX = 10;

  public static void main(String[] args) throws IOException {
    final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    final Set<Integer> sets = new HashSet<>(MAX);

    for (int i = 0; i < MAX; i++) {
      sets.add(Integer.parseInt(reader.readLine()) % 42);
    }

    System.out.println(sets.size());

    for (int i = 0; i< 5; i++) {
      for (int j = 0; j < 5; j++) {

      }
    }
  }
}
