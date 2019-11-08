import java.util.Iterator;

public class DrawingStackIterator implements Iterator<DrawingChange> {

  private LinkedNode<DrawingChange> node;

  public DrawingStackIterator(LinkedNode<DrawingChange> node) {
    this.node = node;
  }

  @Override
  public boolean hasNext() {
    // TODO Auto-generated method stub
    return node != null;
  }

  @Override
  public DrawingChange next() {
    // TODO Auto-generated method stub
    DrawingChange output;
    if (!hasNext())
      throw new java.util.NoSuchElementException();
    output = node.getData();
    node = node.getNext();
    return output;
  }

}
