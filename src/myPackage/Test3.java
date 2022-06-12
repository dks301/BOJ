package myPackage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test3 {
    /*
        n = 5
        {{1,5,2},{2,3,1}}
        {{1,5},{1,3},{2,5},{2,4},{2,4},{3,5},{4,5}}
        result = 4

        n = 7
        {{1,3,3},{4,7,3}}
        {{1,3},{2,5},{3,7},{4,7},{5,6},{6,7},{5,7}}
        result = 5
     */
    public static void main(String[] args) {
        System.out.println(solution(5, new int[][]{{1,5,2},{2,3,1}}, new int[][]{{1,5},{1,3},{2,5},{2,4},{2,4},{3,5},{4,5}}));
    }

    private static int solution(int n, int[][] trains, int[][] bookings) {
        final List<Guest> guests = Arrays.stream(bookings)
                .map(booking -> new Guest(booking[0], booking[1]))
                .sorted()
                .collect(Collectors.toList());
        final Station[] stations = new Station[n + 1];
        for (int i = 1; i <= n; i++) {
            for (Guest guest : guests) {
                if (guest.start == i) {
                    
                }
            }
//            stations[i] = new Station(i, )
        }
        return 0;
    }

    public static class Guests {
        List<Guest> guests;
    }
    private static class Guest implements Comparable<Guest> {
        int start;
        int end;

        public Guest(final int start, final int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(final Guest that) {
            if (this.start < that.start) {
                return -1;
            } else if (this.start == that.start) {
                return Integer.compare(this.end, that.end);
            } else {
                return 1;
            }
        }
    }

    private static class Station {
       int number;
       List<Guest> guests;

        public Station(final int number, final List<Guest> guests) {
            this.number = number;
            this.guests = guests;
        }
    }

    private static class Train {
        int departureStationNumber;
        int arrivalStationNumber;
        int capacity;
        int countGuest;
        int currentStationNumber;

        public Train(final int departureStationNumber, final int arrivalStationNumber, final int capacity, final int countGuest, final int currentStationNumber) {
            this.departureStationNumber = departureStationNumber;
            this.arrivalStationNumber = arrivalStationNumber;
            this.capacity = capacity;
            this.countGuest = countGuest;
            this.currentStationNumber = currentStationNumber;
        }
    }

    private static String replaceArray(final String input) {
        return input.replace('[', '{').replace(']','}');
    }
}
