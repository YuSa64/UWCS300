//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: Study Playlist
// Files: Song.java, DoublyLinkedNode.java, SongCollection.java Playlist.java, ReversePlaylist.java
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
/**
 * 
 * An instance of this class represents a single node within a doubly linked list.
 * 
 * @author Hyeon Jun Jeong
 * 
 */
public class DoublyLinkedNode<T> {

  private DoublyLinkedNode<T> previous;
  private DoublyLinkedNode<T> next;
  private T data;

  /**
   * Initializes a new node with the specified information.
   * 
   * @param data - to be stored within this node
   * @throws IllegalArgumentException - when data is a null reference
   */
  public DoublyLinkedNode(T data) {
    if (data == null)
      throw new IllegalArgumentException();
    this.data = data;
  }

  /**
   * Initializes a new node with the specified information.
   * 
   * @param previous - node, which comes before this node in a doubly linked list
   * @param data     - to be stored within this node
   * @param next     - node, which comes after this node in a doubly linked list
   * @throws IllegalArgumentException - when data is a null reference
   */
  public DoublyLinkedNode(DoublyLinkedNode<T> previous, T data, DoublyLinkedNode<T> next) {
    if (data == null)
      throw new IllegalArgumentException();
    this.previous = previous;
    this.data = data;
    this.next = next;
  }

  /**
   * Accessor method for this node's data.
   * 
   * @return the data stored within this node.
   */
  public T getData() {
    return data;
  }

  /**
   * Mutator method for this node's previous node reference.
   * 
   * @param previous - node, which comes before this node in a doubly linked list
   */
  public void setPrevious(DoublyLinkedNode<T> previous) {
    this.previous = previous;
  }

  /**
   * Accessor method for this node's previous node reference.
   * 
   * @return reference to the node that comes before this one in the list or null when this is the
   *         first node in that list
   */
  public DoublyLinkedNode<T> getPrevious() {
    return previous;
  }

  /**
   * Mutator method for this node's next node reference.
   * 
   * @param next - node, which comes after this node in a doubly linked list
   */
  public void setNext(DoublyLinkedNode<T> next) {
    this.next = next;
  }

  /**
   * Accessor method for this node's next node reference.
   * 
   * @return reference to the node that comes after this one in the list, or null when this is the
   *         last node in that list
   */
  public DoublyLinkedNode<T> getNext() {
    return next;
  }
}
