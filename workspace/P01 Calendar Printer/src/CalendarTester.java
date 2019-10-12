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
public class CalendarTester {
  public static void main(String[] args) {

    System.out.println("getCentury: ");
    if (testGetCentury()) {
      System.out.print("Works\n");
    } else {
      System.out.print("Not Works\n");
    }

    System.out.println("getYearWithinCentury: ");
    if (testGetYearWithinCentury()) {
      System.out.print("Works\n");
    } else {
      System.out.print("Not Works\n");
    }

    System.out.println("getIsLeapYear: ");
    if (testGetIsLeapYear()) {
      System.out.print("Works\n");
    } else {
      System.out.print("Not Works\n");
    }

    System.out.println("getMonthIndex: ");
    if (testGetMonthIndex()) {
      System.out.print("Works\n");
    } else {
      System.out.print("Not Works\n");
    }

    System.out.println("getNumberOfDaysInMonth: ");
    if (testGetNumberOfDaysInMonth()) {
      System.out.print("Works\n");
    } else {
      System.out.print("Not Works\n");
    }

    System.out.println("getFirstDayOfWeekInMonth: ");
    if (testGetFirstDayOfWeekInMonth()) {
      System.out.print("Works\n");
    } else {
      System.out.print("Not Works\n");
    }
    testGenerateCalendar();
  }

  public static boolean testGetCentury() {
    if (CalendarPrinter.getCentury("2") != 0)
      return false;
    if (CalendarPrinter.getCentury("2019") != 20)
      return false;
    if (CalendarPrinter.getCentury("44444") != 444)
      return false;
    return true;
  }

  public static boolean testGetYearWithinCentury() {
    if (CalendarPrinter.getYearWithinCentury("2") != 2)
      return false;
    if (CalendarPrinter.getYearWithinCentury("2019") != 19)
      return false;
    if (CalendarPrinter.getYearWithinCentury("44444") != 44)
      return false;
    return true;
  }

  public static boolean testGetIsLeapYear() {
    if (!CalendarPrinter.getIsLeapYear("2012"))
      return false;
    if (CalendarPrinter.getIsLeapYear("1977"))
      return false;
    if (CalendarPrinter.getIsLeapYear("66666"))
      return false;
    return true;
  }

  public static boolean testGetMonthIndex() {
    if (CalendarPrinter.getMonthIndex("mAYdaymay") != 4)
      return false;
    if (CalendarPrinter.getMonthIndex("OCtobeer") != 9)
      return false;
    if (CalendarPrinter.getMonthIndex("AuGust") != 7)
      return false;
    return true;
  }

  public static boolean testGetNumberOfDaysInMonth() {
    if (CalendarPrinter.getNumberOfDaysInMonth("apr", "2") != 30)
      return false;
    if (CalendarPrinter.getNumberOfDaysInMonth("feb", "2016") != 29)
      return false;
    if (CalendarPrinter.getNumberOfDaysInMonth("may", "2222") != 31)
      return false;
    return true;
  }

  public static boolean testGetFirstDayOfWeekInMonth() {
    if (CalendarPrinter.getFirstDayOfWeekInMonth("mar", "2000") != 2)
      return false;
    if (CalendarPrinter.getFirstDayOfWeekInMonth("nov", "1974") != 4)
      return false;
    if (CalendarPrinter.getFirstDayOfWeekInMonth("jan", "1765") != 1)
      return false;
    return true;
  }

  public static void testGenerateCalendar() {
    String[][] print1 = CalendarPrinter.generateCalendar("apr", "2019");
    String[][] print2 = CalendarPrinter.generateCalendar("jun", "2045");
    String[][] print3 = CalendarPrinter.generateCalendar("sep", "1998");
    for (int i = 0; i < print1.length; i++) {
      for (int j = 0; j < print1[i].length; j++) {
        System.out.print(print1[i][j] + "\t");
      }
      System.out.println();
    }
    for (int i = 0; i < print2.length; i++) {
      for (int j = 0; j < print2[i].length; j++) {
        System.out.print(print2[i][j] + "\t");
      }
      System.out.println();
    }
    for (int i = 0; i < print3.length; i++) {
      for (int j = 0; j < print3[i].length; j++) {
        System.out.print(print3[i][j] + "\t");
      }
      System.out.println();
    }
  }
}
