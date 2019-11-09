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
import java.util.Iterator;

public class Canvas {

  private final int width; // width of the canvas
  private final int height; // height of the canvas
  private char[][] drawingArray; // 2D character array to store the drawing
  private final DrawingStack undoStack; // store previous changes for undo
  private final DrawingStack redoStack; // store undone changes for redo


  /**
   * Constructor creates a new canvas which is initially blank (use the default value for char type
   * or you can use spaces)
   * 
   * @param width
   * @param height
   * @throws IllegalArgumentException - if width or height is 0 or negative.
   */
  public Canvas(int width, int height) {
    if (width <= 0 || height <= 0)
      throw new IllegalArgumentException("width or height cannot be 0 or negative!");
    this.width = width;
    this.height = height;
    drawingArray = new char[this.height][this.width];
    undoStack = new DrawingStack();
    redoStack = new DrawingStack();
  }

  /**
   * Draw a character at the given position drawingArray[row][col]
   * 
   * @param row
   * @param col
   * @param c
   * @throws IllegalArgumentException - if the drawing position is outside the canvas
   */
  public void draw(int row, int col, char c) {
    // If that position is already marked with a different character, overwrite it.
    // After making a new change, add a matching DrawingChange to the undoStack
    // so that we can undo if needed.
    // After making a new change, the redoStack should be empty (meaning that
    // you should clear the redoStack if it is not already empty).
    if (row < 0 || row > this.width || col < 0 || col > this.height)
      throw new IllegalArgumentException("You cannot draw outside the canvas!");
    char temp = drawingArray[row][col];
    drawingArray[row][col] = c;
    undoStack.push(new DrawingChange(row, col, temp, c));
  }

  /**
   * Undo the most recent drawing change.
   * 
   * @return true if successful. False otherwise.
   */
  public boolean undo() {
    // An undone DrawingChange should be popped off the undoStack.
    // An undone DrawingChange should be added to the redoStack so that
    // we can redo if needed.
    // The content of the drawingArray should be updated accordingly to this change.
    if (!undoStack.isEmpty()) {
      DrawingChange temp = undoStack.peek();
      if (drawingArray[temp.row][temp.col] != temp.newChar)
        return false;
      drawingArray[temp.row][temp.col] = temp.prevChar;
      redoStack.push(undoStack.pop());
      return true;
    } else
      return false;
  }

  /**
   * Redo the most recent undone drawing change.
   * 
   * @return true if successful. False otherwise.
   */
  public boolean redo() {
    // A redone DrawingChange should be popped off the redoStack.
    // A redone DrawingChange should be added (back) to the undoStack so that
    // we can undo again if needed.
    // The content of the drawingArray should be updated accordingly to this change.
    if (!redoStack.isEmpty()) {
      DrawingChange temp = redoStack.peek();
      if (drawingArray[temp.row][temp.col] != temp.prevChar)
        return false;
      drawingArray[temp.row][temp.col] = temp.newChar;
      undoStack.push(redoStack.pop());
      return true;
    } else
      return false;
  }

  // Return a printable string version of the Canvas.
  public String toString() {
    /*
     * Format example: [_ is blank. Use System.lineSeparator() to put a newline character between
     * rows] X___X _X_X_ __X__ _X_X_ X___X
     */
    String output = "";
    for (char[] a : drawingArray) {
      for (char c : a) {
        if (c == '\0')
          output += "_";
        else
          output += c;
      }
      output += System.lineSeparator();
    }
    return output;
  }

  public void printDrawing() {
    System.out.println(this);
  }

  public void printHistory() {
    Iterator<DrawingChange> itr = undoStack.iterator();
    DrawingChange data;
    for (int i = 0; i < undoStack.size(); i++) {
      data = itr.next();
      System.out.print((undoStack.size() - i) + ". draw \'" + data.newChar + "\' on (" + data.row
          + ", " + data.col + ")" + System.lineSeparator());
    }
  }

// Getter Methods
  
  /**
   * Returns width
   * @return width of the Canvas
   */
  public int getWidth() {
    return width;
  }

  /**
   * Returns height
   * @return height of the Canvas
   */
  public int getHeight() {
    return height;
  }

  /**
   * Returns drawing array
   * @return drawing array of the canvas
   */
  public char[][] getDrawingArray() {
    return drawingArray;
  }

  /**
   * Returns undoStack
   * @return undoStack of the canvas
   */
  public DrawingStack getUndoStack() {
    return undoStack;
  }

  /**
   * Returns redoStack
   * @return redoStack of the canvas
   */
  public DrawingStack getRedoStack() {
    return redoStack;
  }

}
