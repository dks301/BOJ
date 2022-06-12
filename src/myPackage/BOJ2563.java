package myPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2563 {
  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int N = Integer.parseInt(br.readLine());

    final WhitePaper whitePaper = new WhitePaper(new int[100][100]);
    for (int i = 0; i < N; i++) {
      final StringTokenizer st = new StringTokenizer(br.readLine());
      whitePaper.attach(new ColorPaper(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
    }
    System.out.println(whitePaper.calculateBlack());
  }

  private static class ColorPaper {
    private static final int LENGTH = 10;
    private final int startX;
    private final int startY;

    ColorPaper(final int startX, final int startY) {
      this.startX = startX;
      this.startY = startY;
    }
  }

  private static class WhitePaper {
    private final int[][] map;

    WhitePaper(final int[][] map) {
      this.map = map;
    }

    public void attach(final ColorPaper colorPaper) {
      for (int i = 0; i < ColorPaper.LENGTH; i++) {
        for (int j = 0; j < ColorPaper.LENGTH; j++) {
          this.map[colorPaper.startX + i][colorPaper.startY + j]++;
        }
      }
    }

    public int calculateBlack() {
      return (int) Arrays.stream(this.map)
              .flatMapToInt(Arrays::stream)
              .filter(it -> it >= 1)
              .count();
    }
  }
}
