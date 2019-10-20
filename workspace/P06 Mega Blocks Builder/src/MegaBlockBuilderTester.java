//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: Mega Blocks Builder
// Files: LinkedMegaBlock.java, LinkedListMegaBlock.java, MegaBlockBuilderTester.java
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
import java.util.NoSuchElementException;

public class MegaBlockBuilderTester {


  public static void main(String[] args) {
    System.out.println("testMegaBlockEquals: " + testMegaBlockEquals());
    System.out.println("testMegaBlockToString: " + testMegaBlockToString());
    System.out.println("testLinkedMegaBlock: " + testLinkedMegaBlock());
    System.out.println("testLinkedMegaBlockListAddRed: " + testLinkedMegaBlockListAddRed());
    System.out.println("testLinkedListMegaBlockRemoveBlue: " + testLinkedListMegaBlockRemoveBlue());

  }

  public static boolean testMegaBlockEquals() {
    MegaBlock a = new MegaBlock(Color.RED, 't');
    MegaBlock b = new MegaBlock(Color.RED, 't');
    MegaBlock c = new MegaBlock(Color.YELLOW, 'T');
    return a.equals(b) && !a.equals(c);
  }

  public static boolean testMegaBlockToString() {
    MegaBlock test = new MegaBlock(Color.BLUE, 'B');
    return test.toString().equals("BLUE B");
  }

  public static boolean testLinkedMegaBlock() {
    MegaBlock testMB1 = new MegaBlock(Color.YELLOW, 'L');
    MegaBlock testMB2 = new MegaBlock(Color.RED, 'D');
    MegaBlock testMB3 = new MegaBlock(Color.BLUE, 'U');
    LinkedMegaBlock testLB1 = new LinkedMegaBlock(testMB1);
    LinkedMegaBlock testLB2 = new LinkedMegaBlock(testMB2, testLB1);
    testLB1.setNext(testLB2);
    testLB2.setBlock(testMB3);
    if (testLB2.getNext().getNext().equals(testLB2) && testLB2.getBlock().getColor() == Color.BLUE)
      return true;
    else
      return false;
  }

  // checks for the correctness of the LinkedListMegaBlock.addRed() method
  public static boolean testLinkedMegaBlockListAddRed() {
    boolean catchExcp = false;
    LinkedListMegaBlock test = new LinkedListMegaBlock();
    test.addRed(new MegaBlock(Color.RED, 'F'));
    test.addRed(new MegaBlock(Color.RED, 'S'));
    try {
      test.addRed(new MegaBlock(Color.BLUE, 'w'));
    } catch (IllegalArgumentException e) {
      catchExcp = true;
    }
    if (catchExcp && test.get(1).getLabel() == 'F'
        && test.toString().equals("RED S -> RED F -> END"))
      return true;
    else
      return false;
  }

  // checks for the correctness of the LinkedListMegaBlock.removeBlue() method
  public static boolean testLinkedListMegaBlockRemoveBlue() {
    boolean catchExcp = false;
    LinkedListMegaBlock test = new LinkedListMegaBlock();
    try {
      test.removeBlue();
    } catch (NoSuchElementException e) {
      catchExcp = true;
    }
    test.addBlue(new MegaBlock(Color.BLUE, 'F'));
    test.addBlue(new MegaBlock(Color.BLUE, 'S'));
    test.removeBlue();
    if (catchExcp && test.get(0).getLabel() == 'F' && test.toString().equals("BLUE F -> END"))
      return true;
    else
      return false;
  }
}
