import java.util.Iterator;

public class DrawingStack implements StackADT<DrawingChange>, java.lang.Iterable<DrawingChange> {

  private LinkedNode<DrawingChange> top;
  private int size = 0;

  @Override
  public Iterator<DrawingChange> iterator() {
    // TODO Auto-generated method stub
    return new DrawingStackIterator(top);
  }

  @Override
  public void push(DrawingChange element) {
    // TODO Auto-generated method stub
    if (element == null)
      throw new IllegalArgumentException("Elemnet is null!");
    LinkedNode<DrawingChange> temp = new LinkedNode<DrawingChange>((DrawingChange) element);
    temp.setNext(top);
    top = temp;
    size++;
  }

  @Override
  public DrawingChange pop() {
    // TODO Auto-generated method stub
    if(isEmpty()) throw new java.util.EmptyStackException();
    DrawingChange output = top.getData();
    top = top.getNext();
    size--;
    return output;
  }

  @Override
  public DrawingChange peek() {
    // TODO Auto-generated method stub
    if(isEmpty()) throw new java.util.EmptyStackException();
    return top.getData();
  }

  @Override
  public boolean isEmpty() {
    // TODO Auto-generated method stub
    return top == null;
  }

  @Override
  public int size() {
    // TODO Auto-generated method stub
    return size;
  }


}
