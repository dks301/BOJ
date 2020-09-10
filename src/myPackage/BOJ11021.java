package myPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11021 {

    private static final String CASE = "Case #";
    private static final String COLON = ": ";
    private static final String NEW_LINE = "\n";

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int T = Integer.parseInt(br.readLine());

        final StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= T; i++) {
            final StringTokenizer st = new StringTokenizer(br.readLine());
            final int A = Integer.parseInt(st.nextToken());
            final int B = Integer.parseInt(st.nextToken());
            sb.append(CASE)
                .append(i)
                .append(COLON)
                .append(A + B)
                .append(NEW_LINE);
        }
        System.out.println(sb.toString());
    }
}
