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
public class ColorPlusChar extends Color {
  public ColorPlusChar(Color color, char character) {
    super(color);
    hideChar(character);
  }

  public ColorPlusChar(Color color) {
    super(color);
  }

  // stores 8-bit character within the least significant bits of color components
  public void hideChar(char character) {
    String charNum = Integer.toBinaryString((int) character);
    if (charNum.length() != 8) {
      for (int i = charNum.length(); i < 8; i++)
        charNum = "0" + charNum;
    }
    super.setBits(2, 24, Integer.parseInt(charNum.substring(0, 2)));
    super.setBits(2, 16, Integer.parseInt(charNum.substring(2, 4)));
    super.setBits(2, 8, Integer.parseInt(charNum.substring(4, 6)));
    super.setBits(2, 0, Integer.parseInt(charNum.substring(6)));
  }

  // retrieves 8-bit character from the least significant bits of color components
  public char revealChar() {
    String charNum = "";
    for (int i = 0; i < 4; i++) {
      String temp = Integer.toBinaryString(super.getBits(2, 24 - 8 * i));
      if (temp.length() != 2)
        temp = "0" + temp;
      charNum += temp;
    }
    FourBytes charOut = new FourBytes(Integer.parseInt(charNum, 2));

    return charOut.getChar();
  }
}
