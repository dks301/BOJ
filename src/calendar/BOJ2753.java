package calendar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;

public class BOJ2753 {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int year = Integer.parseInt(br.readLine());
        final boolean isLeapYear = LocalDate.of(year, 1, 1).isLeapYear();

        System.out.println(isLeapYear ? 1 : 0);
    }
}
