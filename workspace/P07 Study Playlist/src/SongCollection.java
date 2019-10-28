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
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * An instance of this class represent doubly linked list of DoublyLinkedNode<Song>
 * 
 * @author Hyeon Jun Jeong
 *
 */
public class SongCollection implements java.lang.Iterable<Song> {

  private DoublyLinkedNode<Song> head;
  private DoublyLinkedNode<Song> tail;
  private boolean playDirectionForward;

  /**
   * Initializes the list.
   */
  public SongCollection() {
    head = null;
    tail = null;
    playDirectionForward = true;
  }

  /**
   * Adds song to the end/tail of this doubly linked list.
   * 
   * @param song - to be stored in the list.
   * @throws NullPointerException - when song is null.
   */
  public void add(Song song) {
    if (song == null)
      throw new NullPointerException();
    if (head == null && tail == null) {
      head = new DoublyLinkedNode<Song>(song);
      tail = head;
    } else {
      DoublyLinkedNode<Song> current = head;
      while (current.getNext() != null)
        current = current.getNext();
      current.setNext(new DoublyLinkedNode<Song>(song));
      tail = current.getNext();
      tail.setPrevious(current);
    }
  }

  /**
   * Removes and returns song from the front/head of this list.
   * 
   * @return Song which is within removed node.
   * @throws NoSuchElementException - when list is empty.
   */
  public Song remove() {
    if (head == null)
      throw new NoSuchElementException();
    DoublyLinkedNode<Song> output = head;
    head = head.getNext();
    if (head == null)
      tail = head;
    return output.getData();
  }

  /**
   * Sets playDirectionForward of the instance.
   * 
   * @param isForward - to play forward or not
   */
  public void setPlayDirection(boolean isForward) {
    playDirectionForward = isForward;
  }

  @Override
  public Iterator<Song> iterator() {
    if (playDirectionForward)
      return new Playlist(head);
    else
      return new ReversePlaylist(tail);
  }
}
///////////////////////////////////////////////////////////////////////////////////
// For each of the following big-O time complexity analyses, consider the problem
// size to be the number of Songs that are stored within the argument songs, when
// the method is first called.
//
// For analysisMethodA, the big-O time complexity is _____O(1)_______.
//
// For analysisMethodB, the big-O time complexity is _____O(n)_______.
//
// For analysisMethodC, the big-O time complexity is _____O(1)_______.
//
///////////////////////////////////////////////////////////////////////////////////
