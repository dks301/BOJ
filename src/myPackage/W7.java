package myPackage;

public class W7 {
  private static final double MON_START = 13d;
  private static final double MON_END = 18d;
  private static final double FRI_START = 9.5d;
  private static final double FRI_END = 18d;

  public static void main(String[] args) {
    System.out.println(solution(0, new String[][]{{"홍콩", "11PM", "9AM"}, {"엘에이", "3PM", "2PM"}}));
  }

  public static String solution(double time, String[][] plans) {
    Plan last = new Plan(plans[0][0], hourTo24(plans[0][1]), hourTo24(plans[0][2]));
    time -= last.calculateNeeds();
    if (time == 0) {
      return last.name;
    }

    for (int i = 1 ; i < plans.length; i++) {
      final Plan plan = new Plan(plans[i][0], hourTo24(plans[i][1]), hourTo24(plans[i][2]));
      time -= plan.calculateNeeds();
      if (time == 0) {
        return plan.name;
      } else if (time < 0) {
        return last.name;
      }
      last = plan;
    }
    return last.name;
  }

  private static int hourTo24(final String time) {
    if (time.length() == 3) {
      final String s = time.substring(1);
      if (s.equals("PM")) {
        final int hour = Integer.parseInt(time.substring(0, 1));
        if (hour == 12) {
          return hour;
        }
        return 12 + hour;
      }
      return Integer.parseInt(time.substring(0, 1));
    }

    final String s = time.substring(2);
    if (s.equals("PM")) {
      final int hour = Integer.parseInt(time.substring(0, 2));
      if (hour == 12) {
        return hour;
      }
      return 12 + hour;
    }
    return Integer.parseInt(time.substring(0, 2));
  }

  private static class Plan {
    String name;
    int startTime;
    int endTime;

    public Plan(final String name, final int startTime, final int endTime) {
      this.name = name;
      this.startTime = startTime;
      this.endTime = endTime;
    }

    public double calculateNeeds() {
      double total = 0;
      if (FRI_END > startTime) {
        total = FRI_END - startTime;
        if (total >= 8.5) {
          total = 8.5;
        }
      }
      double total2 = 0;
      if (MON_START < endTime) {
        total2 = endTime - MON_START;
        if (endTime - MON_START >= 5) {
          total2 = 5;
        }
      }
      return total + total2;
    }
  }
}
