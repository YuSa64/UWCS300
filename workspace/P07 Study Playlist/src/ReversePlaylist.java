import java.util.NoSuchElementException;

public class ReversePlaylist implements java.util.Iterator<Song>{

  private DoublyLinkedNode<Song> tail;
  private DoublyLinkedNode<Song> current;

  public ReversePlaylist(DoublyLinkedNode<Song> input) {
    tail = input;
    current = null;
  }
  
  @Override
  public boolean hasNext() {
    if (tail.getPrevious() != null)
      return true;
    else
      return false;
  }

  @Override
  public Song next() {
    if(current == null) {
      current = tail;
      return current.getData();
    } else if (hasNext()){
      current = current.getPrevious();
      return current.getData();
    } else {
      throw new NoSuchElementException();
    }
  }

}
