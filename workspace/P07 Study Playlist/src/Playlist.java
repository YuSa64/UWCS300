import java.util.NoSuchElementException;

public class Playlist implements java.util.Iterator<Song> {

  private DoublyLinkedNode<Song> head;
  private DoublyLinkedNode<Song> current;

  public Playlist(DoublyLinkedNode<Song> input) {
    head = input;
    current = null;
  }

  @Override
  public boolean hasNext() {
    if (head.getNext() != null)
      return true;
    else
      return false;
  }

  @Override
  public Song next() {
    if(current == null) {
      current = head;
      return current.getData();
    } else if (hasNext()){
      current = current.getNext();
      return current.getData();
    } else {
      throw new NoSuchElementException();
    }
  }

}
