package coordinate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ14681 {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int x = Integer.parseInt(br.readLine());
        final int y = Integer.parseInt(br.readLine());
        final Coordinate coordinate = new Coordinate(x, y);

        System.out.println(coordinate.calculateQuadrant());
    }

    private static class Coordinate {
        final int x;
        final int y;

        public Coordinate(final int x, final int y) {
            this.x = x;
            this.y = y;
        }

        public int calculateQuadrant() {
            if (x < 0) {
                if (y < 0) {
                    return 3;
                }
                return 2;
            }
            if (x > 0) {
                if (y < 0) {
                    return 4;
                }
                return 1;
            }
            return 0;
        }
    }
}
