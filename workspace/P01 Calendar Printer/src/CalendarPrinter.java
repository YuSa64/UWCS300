//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: Calendar Printer
// Files: CalendarPrrinter.java, CalendarTester.java
// Course: CS300 Fall 2019
//
// Author: Hyeon Jun Jeong
// Email: hjeong44@wisc.edu
// Lecturer's Name: Mouna Ayari Ben Hadj Kacem
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: (identify each person and describe their help in detail)
// Online Sources: (identify each URL and describe their assistance in detail)
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
import java.util.Scanner;

public class CalendarPrinter {

  private final static String[] DAYS_OF_WEEK = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
  private final static String[] MONTHS_OF_YEAR =
      {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};

  public static void main(String[] args) {
    Scanner stdIn = new Scanner(System.in);
    String month;
    String year;
    String[][] calendar;
    System.out.println("Welcom to the Calendar Printer.");
    System.out.println("================================");
    System.out.print("Enter the month to print: ");
    month = stdIn.nextLine();
    System.out.print("Enter the year to print: ");
    year = stdIn.nextLine();
    calendar = generateCalendar(month, year);
    for (int i = 0; i < calendar.length; i++) {
      for (int j = 0; j < calendar[i].length; j++) {
        System.out.print(calendar[i][j]);
      }
      System.out.println();
    }
    System.out.println("================================");
    System.out.println("Thanks, and have a nice day.");
    stdIn.close();
  }

  /**
   * Calculates the number of centuries (rounded down) that is represented by the specified year
   * (ie. the integer part of year/100).
   * 
   * @param year to compute the century of (based on the Gregorian Calendar AD) String must contain
   *             the digits of a single non-negative int for year.
   * @return number of centuries in the specified year
   */
  public static int getCentury(String year) {
    int Century = Integer.parseInt(year) / 100;
    return Century;
  }

  /**
   * Calculates the number of years between the specified year, and the first year in the specified
   * year's century. This number is always between 0 - 99.
   * 
   * @param year to compute the year within century of (Gregorian Calendar AD) String must contain
   *             the digits of a single non-negative int for year.
   * @return number of years since first year in the current century
   */
  public static int getYearWithinCentury(String year) {
    int year_within_century = Integer.parseInt(year) % 100;
    return year_within_century;
  }

  /**
   * This method computes whether the specified year is a leap year or not.
   * 
   * @param yearString is the year that is being checked for leap-year-ness String must contain the
   *                   digits of a single non-negative int for year.
   * @return true when the specified year is a leap year, and false otherwise
   */
  public static boolean getIsLeapYear(String yearString) {
    int Year = Integer.parseInt(yearString);
    if (Year % 4 != 0) {
      return false;
    } else if (Year % 100 != 0) {
      return true;
    } else if (Year % 400 != 0) {
      return false;
    } else
      return true;
  }

  // Note implementation tips in Appendix I below.
  /**
   * Converts the name or abbreviation for any month into the index of that month's abbreviation
   * within MONTHS_OF_YEAR. Matches the specified month based only on the first three characters,
   * and is case in-sensitive.
   * 
   * @param month which may or may not be abbreviated to 3 or more characters
   * @return the index within MONTHS_OF_YEAR that a match is found at and returns -1, when no match
   *         is found
   */
  public static int getMonthIndex(String month) {
    String first_three = month.substring(0, 3).toUpperCase();
    for (int i = 0; i < MONTHS_OF_YEAR.length; i++) {
      if (MONTHS_OF_YEAR[i].contentEquals(first_three))
        return i;
    }
    return -1;
  }

  /**
   * Calculates the number of days in the specified month, while taking into consideration whether
   * or not the specified year is a leap year.
   * 
   * @param month which may or may not be abbreviated to 3 or more characters
   * @param year  of month that days are being counted for (Gregorian Calendar AD) String must
   *              contain the digits of a single non-negative int for year.
   * @return the number of days in the specified month (between 28-31)
   */
  public static int getNumberOfDaysInMonth(String month, String year) {
    int index_of_month = getMonthIndex(month);
    boolean isLeap = getIsLeapYear(year);
    if (index_of_month == 1) {
      if (isLeap)
        return 29;
      else
        return 28;
    } else if (index_of_month == 3 || index_of_month == 5 || index_of_month == 8
        || index_of_month == 10) {
      return 30;
    } else
      return 31;
  }

  /**
   * Calculates the index of the first day of the week in a specified month. The index returned
   * corresponds to position of this first day of the week within the DAYS_OF_WEEK class field.
   * 
   * @param month which may or may not be abbreviated to 3 or more characters
   * @param year  of month to determine the first day from (Gregorian Calendar AD) String must
   *              contain the digits of a single non-negative int for year.
   * @return index within DAYS_OF_WEEK of specified month's first day
   */
  public static int getFirstDayOfWeekInMonth(String month, String year) {
    int index_of_month = getMonthIndex(month);
    int year_within_century = getYearWithinCentury(year);
    if (index_of_month <= 1) {
      index_of_month += 12;
      year_within_century--;
    }
    int century = getCentury(year);
    int first_day_of_week = (1 + (int) Math.floor(13 * (index_of_month + 2) / 5)
        + year_within_century + (int) Math.floor(year_within_century / 4)
        + (int) Math.floor(century / 4) + (5 * century)) % 7;

    if (first_day_of_week == 0 || first_day_of_week == 1)
      return first_day_of_week + 5;
    else
      return first_day_of_week - 2;
  }

  // Note implementation tips in Appendix I below.
  /**
   * Creates and initializes a 2D String array to reflect the specified month. The first row of this
   * array [0] should contain labels representing the days of the week, starting with Monday, as
   * abbreviated in DAYS_OF_WEEK. Every later row should contain dates under the corresponding days
   * of week. Entries with no corresponding date in the current month should be filled with a single
   * period. There should not be any extra rows that are either blank, unused, or completely filled
   * with periods. For example, the contents for September of 2019 should look as follows, where
   * each horizontal row is stored in different array within the 2d result:
   *
   * MON TUE WED THU FRI SAT SUN . . . . . . 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21
   * 22 23 24 25 26 27 28 29 30 . . . . . .
   *
   * @param month which may or may not be abbreviated to 3 or more characters
   * @param year  of month generate calendar for (Gregorian Calendar AD) String must contain the
   *              digits of a single non-negative int for year.
   * @return 2d array of strings depicting the contents of a calendar
   */
  public static String[][] generateCalendar(String month, String year) {
    int days_in_month = getNumberOfDaysInMonth(month, year);
    int first_day_of_week = getFirstDayOfWeekInMonth(month, year);
    int row_of_month = (days_in_month + first_day_of_week) / 7;
    if ((days_in_month + first_day_of_week) % 7 != 0)
      row_of_month++;
    String[][] Calendar = new String[row_of_month + 1][7];
    int day_count = 0;
    for (int i = 0; i < 7; i++)
      Calendar[0][i] = DAYS_OF_WEEK[i] + " ";
    for (int i = 1; i < row_of_month + 1; i++) {
      for (int j = 0; j < 7; j++) {
        if (day_count < days_in_month) {
          if (i == 1 && j < first_day_of_week)
            Calendar[i][j] = "  . ";
          else {
            Calendar[i][j] = " " + (++day_count) + " ";
            if (Calendar[i][j].length() == 3)
              Calendar[i][j] += " ";
          }
        } else
          Calendar[i][j] = "  . ";
      }
    }
    return Calendar;
  }
}
