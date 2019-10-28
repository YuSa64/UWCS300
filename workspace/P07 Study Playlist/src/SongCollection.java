import java.util.NoSuchElementException;

public class SongCollection {

  private DoublyLinkedNode<Song> head;
  private DoublyLinkedNode<Song> tail;
  private boolean playDirectionForward;

  public void SongCollection() {
    head = null;
    tail = null;
    playDirectionForward = true;
  }
  
  public void add(Song song) { // adds song to the end/tail of this doubly linked list
    // when song is null, throws a NullPointerException
    if(head == null && tail == null) {
      head = new DoublyLinkedNode<Song>(song);
      tail = head;
    } else {
      DoublyLinkedNode<Song> current = head;
      while(current.getNext() != null)
        current = current.getNext();
    }
  }

  public Song remove() {// removes and returns song from the front/head of this list
    // when list is empty, throws a NoSuchElementException
     if(head == null)
       throw new NoSuchElementException();
     DoublyLinkedNode<Song> output = head;
     head = head.getNext();
     if(head == null)
       tail = head;
     return output.getData();
  }
}
