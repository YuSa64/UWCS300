import java.util.Scanner;

public class Lab2 {

  public static void main(String[] args) {

    Scanner scr = new Scanner(System.in);
    String str = "", text = "", templast = "", tempstart = "", tempend = "";
    int start = 0, end = 0, temp = 0;
    boolean loop;
    String message = "Please enter a string in the format "
        + "<number>:<number>:<word> or type \"quit\" to end.";

    do {
      str = "";
      text = "";
      templast = "";
      tempstart = "";
      tempend = "";
      start = 0;
      end = 0;
      temp = 0;
      System.out.println(message);
      str = scr.nextLine();
      loop = true;

      if (!"quit".equals(str)) {
        if (!isStringEmpty(str)) {
          if (countSemiColons(str)) {
            temp = str.indexOf(":");
            tempstart = str.substring(0, temp);
            templast = str.substring(temp + 1);
            temp = templast.indexOf(":");
            tempend = templast.substring(0, temp);

            text = templast.substring(temp + 1);
            start = Integer.parseInt(tempstart.trim());
            end = Integer.parseInt(tempend.trim());
            if (verifyNumberIndices(start, end, text)) {
              System.out.println("Result: " + text.trim().substring(start, end + 1));
            } else
              System.out.println("Error, number indices are not correct!");
          } else
            System.out.println("Error, only two colons allowed!");
        } else
          System.out.println("Error, empty string!");
      } else {
        loop = false;
      }

    } while (loop);

    System.out.println("Goodbye");
    scr.close();

  }

  public static boolean isStringEmpty(String str) {
    if (str.trim().equals("")) {
      return true;
    } else {
      return false;
    }
  }

  public static boolean countSemiColons(String str) {
    int cls = 0;
    for (int i = 0; i < str.length(); i++) {
      if (str.substring(i, 1 + i).equals(":"))
        cls++;
    }
    if (cls != 2) {
      return false;
    } else {
      return true;
    }
  }

  public static boolean verifyNumberIndices(int start, int end, String text) {
    if (start < 0 || end < 0 || start > end || end > text.length()) {
      return false;
    } else {
      return true;
    }
  }
}
