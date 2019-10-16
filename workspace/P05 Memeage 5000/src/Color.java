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

  /**
   * Create a new Color object with the specific initial value
   * 
   * @param argb contains initial four bytes (32 bits) of data
   */
  public Color(int argb) {
    super(argb);
  }

  /**
   * Create a new Color object with the specific initial value
   * 
   * @param alpha contains initial one byte (8 bits) of data
   * @param red   contains initial one byte (8 bits) of data
   * @param green contains initial one byte (8 bits) of data
   * @param blue  contains initial one byte (8 bits) of data
   */
  public Color(int alpha, int red, int green, int blue) {
    super(0);
    super.setBits(8, 0, blue);
    super.setBits(8, 8, green);
    super.setBits(8, 16, red);
    super.setBits(8, 24, alpha);
  }

  /**
   * Create a new Color object with the specific initial value
   * 
   * @param other contains four bytes (32 bits) of data as a value
   */
  public Color(Color other) {
    super(0);
    super.setInt(other.getInt());
  }

  /**
   * Retrieve the int argb value represented by this Color object.
   * 
   * @return that int argb value
   */
  public int getARGB() {
    return super.getInt();
  }

  /**
   * Retrieve the int alpha value represented by this Color object.
   * 
   * @return that int alpha value
   */
  public int getAlpha() {
    return super.getBits(8, 24);
  }

  /**
   * Retrieve the int red value represented by this Color object.
   * 
   * @return that int red value
   */
  public int getRed() {
    return super.getBits(8, 16);
  }

  /**
   * Retrieve the int green value represented by this Color object.
   * 
   * @return that int grenn value
   */
  public int getGreen() {
    return super.getBits(8, 8);
  }

  /**
   * Retrieve the int blue value represented by this Color object.
   * 
   * @return that int blue value
   */
  public int getBlue() {
    return super.getBits(8, 0);
  }

  /**
   * Changes the value of this this Color object.
   * 
   * @param argb value is the new data that this object is being changed to store
   */
  public void setARGB(int argb) {
    super.setInt(argb);
  }

  /**
   * Changes the value of this this Color object.
   * 
   * @param alpha value is the new data that this object is being changed to store
   */
  public void setAlpha(int alpha) {
    super.setBits(8, 24, alpha);
  }

  /**
   * Changes the value of this this Color object.
   * 
   * @param red value is the new data that this object is being changed to store
   */
  public void setRed(int red) {
    super.setBits(8, 16, red);
  }

  /**
   * Changes the value of this this Color object.
   * 
   * @param green value is the new data that this object is being changed to store
   */
  public void setGreen(int green) {
    super.setBits(8, 8, green);
  }

  /**
   * Changes the value of this this Color object.
   * 
   * @param blue value is the new data that this object is being changed to store
   */
  public void setBlue(int blue) {
    super.setBits(8, 0, blue);
  }
}
