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

public class DrawingStack implements StackADT<DrawingChange>, java.lang.Iterable<DrawingChange> {

  private LinkedNode<DrawingChange> top; // top of the stack
  private int size = 0; // size of the stack (initially 0)

  @Override
  /**
   * Returns Iterator of Stack
   * 
   * @return Iterator of the Stack
   */
  public Iterator<DrawingChange> iterator() {
    // TODO Auto-generated method stub
    return new DrawingStackIterator(top); // returns Iterator of the stack
  }

  @Override
  /**
   * Add an element to this stack
   * 
   * @param element an element to be added
   * @throws java.util.IllegalArgumentException with a descriptive error message if the input
   *                                            element is null
   */
  public void push(DrawingChange element) {
    // TODO Auto-generated method stub
    if (element == null) // if argument is null
      throw new IllegalArgumentException("Elemnet is null!"); // throw descriptive exception
    LinkedNode<DrawingChange> temp = new LinkedNode<DrawingChange>((DrawingChange) element);
    // new node whose data is argument
    temp.setNext(top);// set the current top as a next node
    top = temp; // change the top node
    size++;// increase size
  }

  @Override
  /**
   * Remove the element on the top of this stack and return it
   * 
   * @return the element removed from the top of the stack
   * @throws java.util.EmptyStackException without error message if the stack is empty
   */
  public DrawingChange pop() {
    // TODO Auto-generated method stub
    if (isEmpty()) // if stack is empty
      throw new java.util.EmptyStackException(); // throw exception
    DrawingChange output = top.getData(); // output to be returned
    top = top.getNext(); // change top (remove current top)
    size--; // decrease size
    return output; // return DrawingChange
  }

  @Override
  /**
   * Get the element on the top of this stack
   * 
   * @return the element on the stack top
   * @throws java.util.EmptyStackException without error message if the stack is empty
   */
  public DrawingChange peek() {
    // TODO Auto-generated method stub
    if (isEmpty()) // if stack is empty
      throw new java.util.EmptyStackException();// throw exception
    return top.getData(); // return DrawingChange
  }

  @Override
  /**
   * Check whether this stack is empty or not
   * 
   * @return true if this stack contains no elements, otherwise false
   */
  public boolean isEmpty() {
    // TODO Auto-generated method stub
    return top == null; // it is empty when top node does not exist/
  }

  @Override
  /**
   * Get the number of elements in this stack
   * 
   * @return the size of the stack
   */
  public int size() {
    // TODO Auto-generated method stub
    return size; // return current size
  }


}
