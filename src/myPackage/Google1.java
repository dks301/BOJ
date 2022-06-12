package myPackage;

import java.io.IOException;
import java.util.Arrays;

public class Google1 {

  public static void main(String[] args) throws IOException {

    System.out.println(jump(new int[]{0, 46, 46, 0, 2, 47, 1, 24, 45, 0, 0, 24, 18, 29, 27, 11, 0, 0, 40, 12, 4, 0, 0, 0, 49, 42, 13, 5, 12, 45, 10, 0, 29, 11, 22, 15, 17, 41, 34, 23, 11, 35, 0, 18, 47, 0, 38, 37, 3, 37, 0, 43, 50, 0, 25, 12, 0, 38, 28, 37, 5, 4, 12, 23, 31, 9, 26, 19, 11, 21, 0, 0, 40, 18, 44, 0, 0, 0, 0, 30, 26, 37, 0, 26, 39, 10, 1, 0, 0, 3, 50, 46, 1, 38, 38, 7, 6, 38, 27, 7, 25, 30, 0, 0, 36, 37, 6, 39, 40, 32, 41, 12, 3, 44, 44, 39, 2, 26, 40, 36, 35, 21, 14, 41, 48, 50, 21, 0, 0, 23, 49, 21, 11, 27, 40, 47, 49
}));
  }

    public static int jump(int[] A) {
        final int[] d = new int[A.length];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[0] = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                continue;
            }
            for (int j = A[i]; j >= 0 ; j--) {
                int jumpCount = d[i] + 1;
                int currentIndex = i + j;
                if (currentIndex >= A.length) {
                    return jumpCount;
                }
                int nextIndex = currentIndex + A[currentIndex];
                if (nextIndex >= A.length) {
                    return jumpCount + 1;
                }
                if (d[currentIndex] > jumpCount) {
                    d[currentIndex] = jumpCount;
                }
            }
        }

        return d[A.length - 1] == Integer.MAX_VALUE ? -1 : d[A.length - 1];
    }
}
