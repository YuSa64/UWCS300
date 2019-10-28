import java.util.Iterator;
import java.util.NoSuchElementException;

public class SongCollection implements java.lang.Iterable<Song>{

  private DoublyLinkedNode<Song> head;
  private DoublyLinkedNode<Song> tail;
  private boolean playDirectionForward;

  public SongCollection() {
    head = null;
    tail = null;
    playDirectionForward = true;
  }

  public void add(Song song) { // adds song to the end/tail of this doubly linked list
    // when song is null, throws a NullPointerException
    if(song == null) throw new NullPointerException();
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

  public Song remove() {// removes and returns song from the front/head of this list
    // when list is empty, throws a NoSuchElementException
    if (head == null)
      throw new NoSuchElementException();
    DoublyLinkedNode<Song> output = head;
    head = head.getNext();
    if (head == null)
      tail = head;
    return output.getData();
  }
  
  public void setPlayDirection(boolean isForward) {
    playDirectionForward = isForward;
  }

  @Override
  public Iterator<Song> iterator() {
    if(playDirectionForward)
      return new Playlist(head);
    else
      return new ReversePlaylist(tail);
  }
}
///////////////////////////////////////////////////////////////////////////////////
//For each of the following big-O time complexity analyses, consider the problem
//size to be the number of Songs that are stored within the argument songs, when
//the method is first called.
//
//For analysisMethodA, the big-O time complexity is ____________.
//
//For analysisMethodB, the big-O time complexity is ____________.
//
//For analysisMethodC, the big-O time complexity is ____________.
//
///////////////////////////////////////////////////////////////////////////////////