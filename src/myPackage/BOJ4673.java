package myPackage;

import java.util.function.Function;

public class BOJ4673 {
  private static final int TEN_THOUSAND = 10000;
  private static final int THOUSAND = 1000;
  private static final int HUNDRED = 100;
  private static final int TEN = 10;
  private static final int ONE = 1;
  private static final String NEW_LINE = "\n";

  private static final Function<Integer, Integer> EXTRACT_TEN_THOUSANDS_PLACE =
      n -> n / TEN_THOUSAND;
  private static final Function<Integer, Integer> EXTRACT_THOUSANDS_PLACE = n -> n / THOUSAND;
  private static final Function<Integer, Integer> EXTRACT_HUNDREDS_PLACE = n -> n / HUNDRED;
  private static final Function<Integer, Integer> EXTRACT_TENS_PLACE = n -> n / TEN;
  private static final Function<Integer, Integer> EXTRACT_ONES_PLACE = n -> n % TEN;

  public static void main(String[] args) {
    final boolean[] check = new boolean[TEN_THOUSAND + ONE];

    final StringBuilder builder = new StringBuilder();
    for (int i = 1; i < TEN_THOUSAND + ONE ; i++) {
      if (!check[i]) {
        int nextN = i;
        builder.append(nextN).append(NEW_LINE);
        while(true) {
          nextN = d(nextN);
          if (nextN > TEN_THOUSAND) {
            break;
          }
          check[nextN] = true;
        }
      }
    }

    System.out.println(builder);

  }

  public static int d(final int n) {
    return n
        + EXTRACT_TEN_THOUSANDS_PLACE.apply(n)
        + EXTRACT_THOUSANDS_PLACE.apply(n % TEN_THOUSAND)
        + EXTRACT_HUNDREDS_PLACE.apply(n % THOUSAND)
        + EXTRACT_TENS_PLACE.apply(n % HUNDRED)
        + EXTRACT_ONES_PLACE.apply(n % TEN);
  }
}
