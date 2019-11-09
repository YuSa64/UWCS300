//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: Ascii Art
// Files: AsciiArtTester.java, Canvas.java, DrawingChange.java, DrawingStack.java,
//////////////////// DrawingStackIterator.java
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
public class DrawingChange {

  public final int row; // row (y-coordinate) for this DrawingChange
  public final int col; // col (x-coordinate) for this DrawingChange
  public final char prevChar; // previous character in the (row,col) position
  public final char newChar; // new character in the (row,col) position

  public DrawingChange(int row, int col, char prevChar, char newChar) {
    this.row = row;
    this.col = col;
    this.prevChar = prevChar;
    this.newChar = newChar;
  }
}
