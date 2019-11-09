import java.util.Iterator;

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
public class AsciiArtTester {
  public static void main(String[] args) {

    boolean test = runAsciiArtTestSuite();
    if (test)
      System.out.println("All test passed!");
    else
      System.out.print("Test Failed!");
  }

  public static boolean runAsciiArtTestSuite() {
    return testStackPushPeek() && testCanvasDraw() && testCanvasUndo() && testCanvasRedo()
        && testDrawingStackIterator();
  }

  public static boolean testStackPushPeek() {
    System.out.print("testStackPushPeek test: ");
    DrawingChange testData = new DrawingChange(0, 0, '\0', '\0');
    DrawingChange testData2 = new DrawingChange(0, 0, '\0', '\0');
    DrawingStack testStack = new DrawingStack();
    boolean testpush = false, testpop = false, testpeek = false;
    try {
      testStack.peek();
    } catch (Exception e) {
      testpeek = true;
    }
    try {
      testStack.pop();
    } catch (Exception e) {
      testpop = true;
    }
    testStack.push(testData);
    testStack.push(testData2);
    testpush = testStack.peek().equals(testData2);


    if (testpush && testpop && testpeek) {
      System.out.println("pass");
      return true;
    } else {
      System.out.println("fail");
      return false;
    }
  }

  public static boolean testCanvasDraw() {
    System.out.print("testCanvasDraw test: ");
    Canvas tester = new Canvas(5, 5);
    tester.draw(2, 2, 't');
    String compare = "_____" + System.lineSeparator() + "_____" + System.lineSeparator() + "__t__"
        + System.lineSeparator() + "_____" + System.lineSeparator() + "_____"
        + System.lineSeparator();
    if (tester.toString().equals(compare)) {
      System.out.println("pass");
      return true;
    } else {
      System.out.println("fail");
      return false;
    }
  }

  public static boolean testCanvasUndo() {
    System.out.print("testCanvasUndo test: ");
    Canvas tester = new Canvas(5, 5);
    tester.draw(2, 2, 't');
    tester.undo();
    String compare = "_____" + System.lineSeparator() + "_____" + System.lineSeparator() + "_____"
        + System.lineSeparator() + "_____" + System.lineSeparator() + "_____"
        + System.lineSeparator();
    if (tester.toString().equals(compare)) {
      System.out.println("pass");
      return true;
    } else {
      System.out.println("fail");
      return false;
    }
  }

  public static boolean testCanvasRedo() {
    System.out.print("testCanvasRedo test: ");
    Canvas tester = new Canvas(5, 5);
    tester.draw(2, 2, 't');
    tester.undo();
    tester.redo();
    String compare = "_____" + System.lineSeparator() + "_____" + System.lineSeparator() + "__t__"
        + System.lineSeparator() + "_____" + System.lineSeparator() + "_____"
        + System.lineSeparator();
    if (tester.toString().equals(compare)) {
      System.out.println("pass");
      return true;
    } else {
      System.out.println("fail");
      return false;
    }
  }

  public static boolean testDrawingStackIterator() {
    System.out.print("testDrawingStackIterator test: ");
    DrawingStack testStack = new DrawingStack();
    Iterator<DrawingChange> testItr = testStack.iterator();
    boolean testHasNext = false, testNext = false;
    testHasNext = !testItr.hasNext();
    try {
      testItr.next();
    } catch (Exception e) {
      testNext = true;
    }
    if (testHasNext && testNext) {
      System.out.println("pass");
      return true;
    } else {
      System.out.println("fail");
      return false;
    }
  }
}
