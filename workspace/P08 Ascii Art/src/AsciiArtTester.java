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

    boolean test = false;
    try {
    test = runAsciiArtTestSuite(); // run tests;
    } catch(Exception e) {
      printPrln(0, "fail");
    }
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
    printPrln(0, "testStackPushPeek test: ");
    printPr(1, "initialize testData...");
    DrawingChange testData = new DrawingChange(0, 0, '\0', '\0');
    printPrln(0, "done");
    printPr(1, "initialize testData2...");
    DrawingChange testData2 = new DrawingChange(0, 0, '\0', '\0');
    printPrln(0, "done");
    printPr(1, "initialize testStack...");
    DrawingStack testStack = new DrawingStack();
    printPrln(0, "done");
    boolean testpush = false, testpop = false, testpeek = false, testsize = false;

    printPrln(2, "peek null stack test:");
    try {
      printPr(3, "try peek...");
      testStack.peek();
      printPrln(0, "fail");
    } catch (Exception e) {
      printPrln(0, "pass");
      testpeek = true;
    }

    printPrln(2, "pop null stack test:");
    try {
      printPr(3, "try null pop...");
      testStack.pop();
      printPrln(0, "fail");
    } catch (Exception e) {
      printPrln(0, "pass");
      testpop = true;
    }

    printPr(1, "push testData...");
    testStack.push(testData);
    printPrln(0, "done");
    printPr(1, "push testData2...");
    testStack.push(testData2);
    printPrln(0, "done");
    printPrln(2, "peek stack test:");
    printPr(3, "try peek...");
    testpush = testStack.peek().equals(testData2);
    if (testpush)
      printPrln(0, "pass");
    else
      printPrln(0, "fail");
    printPrln(2, "stack size test:");
    printPr(3, "get size...");
    testsize = testStack.size() == 2;
    if (testsize) {
      printPrln(0, "pass");
      printPr(3, "pop and get size...");
      testStack.pop();
      testsize = testStack.size() == 1;
      if (testsize)
        printPrln(0, "pass");
      else
        printPrln(0, "fail");
    } else
      printPrln(0, "fail");

    if (testpush && testpop && testpeek && testsize) {
      printPrln(0, "test pass");
      return true;
    } else {
      printPrln(0, "test fail");
      return false;
    }
  }

  public static boolean testCanvasDraw() {
    printPrln(0, "testCanvasDraw test: ");
    printPr(1, "initialize 5x5 Canvas...");
    Canvas tester = new Canvas(5, 5);
    printPrln(0, "done");
    printPr(1, "initialize comparison String...");
    String compare = "_____" + System.lineSeparator() + "_____" + System.lineSeparator() + "__t__"
        + System.lineSeparator() + "_____" + System.lineSeparator() + "_____"
        + System.lineSeparator();
    printPrln(0, "done");
    printPr(1, "draw on canvas...");
    tester.draw(2, 2, 't');
    printPrln(0, "done");
    printPr(2, "compare canvas and comparison string...");
    if (tester.toString().equals(compare)) {
      printPrln(0, "pass");
      return true;
    } else {
      printPrln(0, "fail");
      return false;
    }
  }

  public static boolean testCanvasUndo() {
    printPrln(0, "testCanvasUndo test: ");
    printPr(1, "initialize 5x5 Canvas...");
    Canvas tester = new Canvas(5, 5);
    printPrln(0, "done");
    printPr(1, "initialize comparison String...");
    String compare = "_____" + System.lineSeparator() + "_____" + System.lineSeparator() + "_____"
        + System.lineSeparator() + "_____" + System.lineSeparator() + "_____"
        + System.lineSeparator();
    printPrln(0, "done");
    printPr(1, "draw on canvas...");
    tester.draw(2, 2, 't');
    printPrln(0, "done");
    printPr(1, "undo draw...");
    tester.undo();
    printPrln(0, "done");
    printPr(2, "compare canvas and comparison string...");
    if (tester.toString().equals(compare)) {
      printPrln(0, "pass");
      return true;
    } else {
      printPrln(0, "fail");
      return false;
    }
  }

  public static boolean testCanvasRedo() {
    printPrln(0, "testCanvasRedo test: ");
    printPr(1, "initialize 5x5 Canvas...");
    Canvas tester = new Canvas(5, 5);
    printPrln(0, "done");
    printPr(1, "initialize comparison String...");
    String compare = "_____" + System.lineSeparator() + "_____" + System.lineSeparator() + "__t__"
        + System.lineSeparator() + "_____" + System.lineSeparator() + "_____"
        + System.lineSeparator();
    printPrln(0, "done");
    printPr(1, "draw on canvas...");
    tester.draw(2, 2, 't');
    printPrln(0, "done");
    printPr(1, "undo draw...");
    tester.undo();
    printPrln(0, "done");
    printPr(1, "redo draw...");
    tester.redo();
    printPrln(0, "done");
    printPr(2, "compare canvas and comparison string...");
    if (tester.toString().equals(compare)) {
      printPrln(0, "pass");
      return true;
    } else {
      printPrln(0, "fail");
      return false;
    }
  }

  public static boolean testDrawingStackIterator() {
    printPrln(0, "testDrawingStackIterator test: ");
    printPr(1, "initialize testStack...");
    DrawingStack testStack = new DrawingStack();
    printPrln(0, "done");
    printPr(1, "initialize testItr...");
    Iterator<DrawingChange> testItr = testStack.iterator();
    printPrln(0, "done");
    boolean testHasNext = false, testNext = false;
    printPr(2, "test hasNext...");
    testHasNext = !testItr.hasNext();
    if (testHasNext)
      printPrln(0, "done");
    else
      printPrln(0, "fail");
    printPr(2, "test next...");
    try {
      testItr.next();
      printPrln(0, "fail");
    } catch (Exception e) {
      printPrln(0, "done");
      testNext = true;
    }
    if (testHasNext && testNext) {
      printPrln(0, "test pass");
      return true;
    } else {
      printPrln(0, "test fail");
      return false;
    }
  }
  
  /**
   * Print String with tabs
   * 
   * @param n - number of tabs
   * @param s - string to print
   */
  private static void printPr(int n, String s) {
    for (int i = 0; i < n; i++) {
      System.out.print('\t');
    }
    System.out.print(s);
  }

  /**
   * Print String with tabs and new line
   * 
   * @param n - number of tabs
   * @param s - string to print
   */
  private static void printPrln(int n, String s) {
    printPr(n, s + System.lineSeparator());
  }

}
