//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: Memeage 5000
// Files: Color.java, ColorPlusChar.java, Memeage.java, MemeageTests.java
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
import java.io.File;
import java.io.IOException;

public class MemeageTests {
  public static void main(String[] args) {
    System.out.println(testFourBytesGetBits());
    System.out.println(testFourBytesSetBits());
    System.out.println(testColor());
    System.out.println(testImage());
    System.out.println(testColorPlusChar());
    System.out.println(testMemeage());
  }

  public static boolean testFourBytesGetBits() {
    FourBytes test = new FourBytes(Integer.parseInt("11010000000000", 2)); // bitstring:
                                                                           // 110100 00000000
    if (test.getBits(14, 0) == 13312)
      return true;
    else
      return false;
  }

  public static boolean testFourBytesSetBits() {
    FourBytes test = new FourBytes(0); // bitstring: 000 00000000
    test.setBits(3, 8, 5); // bitstring: 101 00000000
    if (test.getBits(11, 0) == 1280)
      return true;
    else
      return false;
  }

  public static boolean testColor() {
    Color test = new Color(255, 224, 255, 255); // bitstring: 1111111 11100000 11111111 11111111
    // which is equal to -2031617
    if (test.getARGB() != -2031617)
      return false;
    test.setARGB(-1073807105); // bitstring: 10111111 11111111 00000000 11111111
    if (test.getAlpha() != 191 || test.getRed() != 255 || test.getGreen() != 0
        || test.getBlue() != 255)
      return false;
    return true;

  }

  public static boolean testImage() {
    File image = new File("testImage.png");
    Image test;
    try {
      test = new Image(image);
      if (test.getHeight() != 3 || test.getWidth() != 3)
        return false;
      if (test.getColor(1, 1).getARGB() != -16711681)
        return false;
      return true;
    } catch (IOException e) {
      return false;
    }
  }

  public static boolean testColorPlusChar() {
    Color test1 = new Color(255, 143, 200, 31); // bitstring: 11111111 10001111 11001000 00011111
    char c = 'j'; // bitstring: 01101010
    ColorPlusChar test2 = new ColorPlusChar(test1, c);
    if (test2.getARGB() != -40973794)
      return false;
    if (test2.revealChar() != 'j')
      return false;
    return true;
  }

  public static boolean testMemeage() {
    try {
      File image1 = new File("image01.png");
      String meme = "420 Blaze it";
      Memeage test;
      test = new Memeage(image1, meme);
      if (!test.getMeme().equals(meme))
        return false;
      
      test.saveAs(new File("testdone.png"));
      return true;
    } catch (IOException | IllegalArgumentException e) {
      return false;
    }
  }
}
