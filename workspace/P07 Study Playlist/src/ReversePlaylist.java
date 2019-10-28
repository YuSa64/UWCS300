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
import java.util.NoSuchElementException;

/**
 * An instance of this class represent Iterator of DoublyLinkedNode<Song>
 * 
 * @author Hyeon Jun Jeong
 *
 */
public class ReversePlaylist implements java.util.Iterator<Song> {

  private DoublyLinkedNode<Song> tail;
  private DoublyLinkedNode<Song> current;

  /**
   * Initializes a new Iterator with tail node
   * 
   * @param input - a tail node of Iterator
   */
  public ReversePlaylist(DoublyLinkedNode<Song> input) {
    tail = input;
    current = tail;
  }

  @Override
  public boolean hasNext() {
    if (current == null)
      return false;
    else
      return true;
  }

  @Override
  public Song next() {
    if (hasNext()) {
      Song output = current.getData();
      current = current.getPrevious();
      return output;
    } else {
      throw new NoSuchElementException();
    }
  }

}
