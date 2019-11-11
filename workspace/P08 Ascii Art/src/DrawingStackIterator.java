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

public class DrawingStackIterator implements Iterator<DrawingChange> {

  private LinkedNode<DrawingChange> node; //current node of Iterator

  public DrawingStackIterator(LinkedNode<DrawingChange> node) {
    this.node = node;
  }

  @Override
  /**
   * Check if the node is null or not
   * 
   * @return true if the node is not null
   */
  public boolean hasNext() {
    // TODO Auto-generated method stub
    return node != null; //if current node is null, the node does not have next.
  }

  @Override
  /**
   * Return the data of the LinkedNode
   * 
   * @return DrawingChange of the LinkedNode
   */
  public DrawingChange next() {
    // TODO Auto-generated method stub
    DrawingChange output; //DrawingChange instance to be returned
    if (!hasNext()) //if current node is null
      throw new java.util.NoSuchElementException(); //throw exception
    output = node.getData();
    node = node.getNext(); //move to the next node
    return output;
  }

}
