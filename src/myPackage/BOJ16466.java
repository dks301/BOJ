package myPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16466 {

  private static final int MAX = 1_000_001;

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int N = Integer.parseInt(br.readLine());

    final StringTokenizer st = new StringTokenizer(br.readLine());
    final boolean[] soldTickets = new boolean[MAX];
    for (int i = 0; i < N; i++) {
      try {
        soldTickets[Integer.parseInt(st.nextToken())] = true;
      } catch (ArrayIndexOutOfBoundsException ignored) {
      }
    }

    System.out.println(findMin(N, soldTickets));
  }

  private static int findMin(final int N, final boolean[] soldTickets) {
    for (int i = 1; i <= N; i++) {
      if (!soldTickets[i]) {
        return i;
      }
    }
    return N + 1;
  }
}
