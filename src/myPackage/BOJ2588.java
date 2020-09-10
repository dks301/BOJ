package myPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2588 {

    private static final String NEW_LINE = "\n";

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int a = Integer.parseInt(br.readLine());
        final int b = Integer.parseInt(br.readLine());
        final int[] bUnits = convert(b);

        final StringBuilder sb = new StringBuilder();
        for (int i = 2; i >= 0; i--) {
            sb.append(a * bUnits[i]).append(NEW_LINE);
        }
        sb.append(a * b);

        System.out.println(sb.toString());
    }

    public static int[] convert(int value) {
        int[] values = new int[3];
        int mod = 100;

        for (int i = 0; i < 3; i++) {
            values[i] = value / mod;
            value %= mod;
            mod /= 10;
        }

        return values;
    }
}
