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
public class Color extends FourBytes {
  public Color(int argb) {
    super(argb);
  }

  public Color(int alpha, int red, int green, int blue) {
    super(0);
    super.setBits(8, 0, blue);
    super.setBits(8, 8, green);
    super.setBits(8, 16, red);
    super.setBits(8, 24, alpha);
  }

  public Color(Color other) {
    super(0);
    super.setInt(other.getInt());
  }

  public int getARGB() {
    return super.getInt();
  }

  public int getAlpha() {
    return super.getBits(8, 24);
  }

  public int getRed() {
    return super.getBits(8, 16);
  }

  public int getGreen() {
    return super.getBits(8, 8);
  }

  public int getBlue() {
    return super.getBits(8, 0);
  }

  public void setARGB(int argb) {
    super.setInt(argb);
  }

  public void setAlpha(int alpha) {
    super.setBits(8, 24, alpha);
  }

  public void setRed(int red) {
    super.setBits(8, 16, red);
  }

  public void setGreen(int green) {
    super.setBits(8, 8, green);
  }

  public void setBlue(int blue) {
    super.setBits(8, 0, blue);
  }
}
