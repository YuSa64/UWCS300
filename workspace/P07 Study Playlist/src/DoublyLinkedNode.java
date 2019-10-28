
public class DoublyLinkedNode<T> {

  private DoublyLinkedNode<T> previous;
  private DoublyLinkedNode<T> next;
  private T data;

  public DoublyLinkedNode(T data) {
    this.data = data;
  }

  public DoublyLinkedNode(DoublyLinkedNode<T> previous, T data, DoublyLinkedNode<T> next) {
    this.previous = previous;
    this.data = data;
    this.next = next;
  }
  
  public T getData() {
    return data;
  }
  
  public void setPrevious(DoublyLinkedNode<T> previous) {
    this.previous = previous;
  }
  
  public DoublyLinkedNode<T> getPrevious(){
    return previous;
  }
  
  public void setNext(DoublyLinkedNode<T> next) {
    this.next = next;
  }
  
  public DoublyLinkedNode<T> getNext(){
    return next;
  }
}
