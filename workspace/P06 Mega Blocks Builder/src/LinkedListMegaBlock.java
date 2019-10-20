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

public class LinkedListMegaBlock {
  private LinkedMegaBlock head; // head of this list
  private LinkedMegaBlock tail; // tail of this list
  private int size; // size of this list (total number of megablocks stored in this list)
  private int redCount; // number of RED megablocks stored in this list
  private int yellowCount; // number of YELLOW megablocks stored in this list
  private int blueCount; // number of BLUE megablocks stored in this list

  /**
   * Creates an empty linked list of mega blocks
   */
  public LinkedListMegaBlock() {
    clear();
  }

  /**
   * Adds a blueBlock at the end of this list
   * 
   * @param blueBlock - new element to be added to this list
   * @throws java.lang.IllegalArgumentException - if blueBlock is null or if the color of the
   *                                            specific blueBlock is not equal to Color.BLUE
   */
  public void addBlue(MegaBlock blueBlock) {
    if (blueBlock == null || blueBlock.getColor() != Color.BLUE)
      throw new IllegalArgumentException();
    if (head == null || tail == null) {
      head = new LinkedMegaBlock(blueBlock);
      tail = head;
    } else {
      tail.setNext(new LinkedMegaBlock(blueBlock));
      tail = tail.getNext();
    }
    blueCount++;
    size++;
  }

  /**
   * Adds a new redBlock at the head of this list
   * 
   * @param redBlock - new element to be added to this list
   * @throws java.lang.IllegalArgumentException - if redBlock is null or if its color does not equal
   *                                            to Color.RED
   */
  public void addRed(MegaBlock redBlock) {
    if (redBlock == null || redBlock.getColor() != Color.RED)
      throw new IllegalArgumentException();
    if (head == null || tail == null) {
      head = new LinkedMegaBlock(redBlock);
      tail = head;
    } else {
      LinkedMegaBlock current = head;
      head = new LinkedMegaBlock(redBlock);
      head.setNext(current);
    }
    redCount++;
    size++;
  }

  /**
   * Adds the provided yellowBlock at the position index in this list
   * 
   * @param index       - index at which the specified yellow block is to be inserted
   * @param yellowBlock - new element to be added to this list
   * @throws java.lang.IllegalArgumentException  - if yellowBlock is null or if it does not have a
   *                                             Color.YELLOW color
   * @throws java.lang.IndexOutOfBoundsException - if the index is out of the range reserved for
   *                                             yellow blocks (index < redCount || index > size -
   *                                             blueCount)
   */
  public void addYellow(int index, MegaBlock yellowBlock) {
    if (yellowBlock == null || yellowBlock.getColor() != Color.YELLOW)
      throw new IllegalArgumentException();
    if (head == null || tail == null) {
      head = new LinkedMegaBlock(yellowBlock);
      tail = head;
    } else {
      if (index < redCount || index > size - blueCount)
        throw new IndexOutOfBoundsException();
      LinkedMegaBlock currentp = head, currentb = head, add = new LinkedMegaBlock(yellowBlock);
      for (int i = 0; i < index; i++) {
        currentb = currentp;
        currentp = currentp.getNext();
      }
      if (currentp == null) {
        currentb.setNext(add);
        tail = add;
      } else if (currentp.equals(currentb)) {
        add.setNext(currentb);
        head = add;
      } else {
        currentb.setNext(add);
        add.setNext(currentp);
      }
    }
    yellowCount++;
    size++;
  }

  /**
   * Removes all of the elements from this list. The list will be empty after this call returns.
   */
  public void clear() {
    head = null;
    tail = null;
    size = 0;
    redCount = 0;
    yellowCount = 0;
    blueCount = 0;
  }

  /**
   * Returns the element stored at position index of this list without removing it.
   * 
   * @param index - position within this list
   * @return the megablock object stored at position index of this list
   * @throws java.lang.IndexOutOfBoundsException - if the index is out of range (index < 0 || index
   *                                             >= size())
   */
  public MegaBlock get(int index) {
    if (index < 0 || index >= size)
      throw new IndexOutOfBoundsException();
    LinkedMegaBlock links = head;
    for (int i = 0; i < index; i++) {
      links = links.getNext();
    }
    return links.getBlock();
  }

  /**
   * Returns the number of blue mega bloks stored in this list
   * 
   * @return the blueCount
   */
  public int getBlueCount() {
    return blueCount;
  }

  /**
   * Returns the number of red mega bloks stored in this list
   * 
   * @return the redCount
   */
  public int getRedCount() {
    return redCount;
  }

  /**
   * Returns the number of yellow mega bloks stored in this list
   * 
   * @return the yellowCount
   */
  public int getYellowCount() {
    return yellowCount;
  }

  /**
   * Returns true if this list contains no elements.
   * 
   * @return true if this list is empty, and false otherwise.
   */
  public boolean isEmpty() {
    return size == 0;
  }

  /**
   * Removes and returns the element at the tail of this list if it has a blue color
   * 
   * @return a reference to the removed element
   * @throws java.util.NoSuchElementException - if this list does not contain any blue block
   */
  public MegaBlock removeBlue() {
    if (blueCount == 0)
      throw new NoSuchElementException();
    LinkedMegaBlock output = tail, current = head;
    while (current.getNext().getNext() != null) {
      current = current.getNext();
    }
    tail = current;
    tail.setNext(null);
    blueCount--;
    size--;
    return output.getBlock();
  }

  /**
   * Removes and returns the mega block at the head of this list if its color is red
   * 
   * @return a reference to the removed element
   * @throws java.util.NoSuchElementException - if this list does not contain any blue block
   */
  public MegaBlock removeRed() {
    if (redCount == 0)
      throw new NoSuchElementException();
    LinkedMegaBlock current = head;
    head = head.getNext();
    redCount--;
    size--;
    return current.getBlock();
  }

  /**
   * Removes and returns the element stored at index position in this list
   * 
   * @param index - position of the element to remove in this list
   * @return a reference to the removed element
   * @throws java.lang.IndexOutOfBoundsException - if the index is out of range (index < redCount or
   *                                             index >= size - blueCount)
   */
  public MegaBlock removeYellow(int index) {
    if (index < redCount || index > size - blueCount || yellowCount == 0)
      throw new IndexOutOfBoundsException();
    LinkedMegaBlock currentp = head, currentb = head, output = null;
    for (int i = 0; i < index; i++) {
      currentb = currentp;
      currentp = currentp.getNext();
    }
    output = currentp;
    currentb.setNext(currentp.getNext());
    yellowCount--;
    size--;
    return output.getBlock();
  }

  /**
   * Replaces the megablock at the specified position in this list with the specified element if
   * they have the same Color
   * 
   * @param index - index of the block to replace
   * @param block - element to be stored at the specified position
   * @return the element previously at the specified position
   * @throws java.lang.IllegalArgumentException  - if object is null or is not equal to the
   *                                             megablock already at at index position
   * @throws java.lang.IndexOutOfBoundsException - if the index is out of range (index < 0 || index
   *                                             >= size())
   */
  public MegaBlock set(int index, MegaBlock block) {
    if (index < 0 || index >= size)
      throw new IndexOutOfBoundsException();
    LinkedMegaBlock current = head, output = null;
    for (int i = 0; i < index; i++) {
      current = current.getNext();
    }
    if (block == null || get(index).equals(block))
      throw new IllegalArgumentException();
    else
      output = current;
    current.setBlock(block);
    return output.getBlock();
  }

  /**
   * Returns the size of this list
   * 
   * @return the number of megablocks stored in this list
   */
  public int size() {
    return size;
  }

  /**
   * Returns a String representation of the contents of this list
   * 
   * @return return a String representation of the content of this list. If this list is empty, an
   *         empty String ("") will be returned.
   */
  public String toString() {
    String output = "";
    LinkedMegaBlock current = head;
    if (current != null)
      do {
        output += current.toString();
        current = current.getNext();
      } while (current != null);
    return output;
  }
}
