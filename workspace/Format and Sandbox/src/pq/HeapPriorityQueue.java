package pq;
import java.util.ArrayList;

/**
 * This class models a PriorityQueue data structure implemented using an array-based min-heap
 * 
 * @param <T> type parameter of the data stored in an instance of the HeapPriorityQueue. T should be
 *        any time implementing the interface Comparable or extending a class implementing the
 *        interface comparable
 * @author Mouna AYARI BEN HADJ KACEM UW-Madison - Department of Computer Sciences - CS300
 * 
 */
public class HeapPriorityQueue<T extends Comparable<T>>  implements PriorityQueueADT<T> {

  private ArrayList<T> heap; // array-based min heap storing the data

  /**
   * Default constructor Creates an empty priority queue with the default capacity
   */
  public HeapPriorityQueue() {
    heap = new ArrayList<T>();
  }

  /**
   * Overloaded constructor Creates an empty priority queue with a given capacity
   * 
   * @param capacity
   * @throws IllegalArgumentException if capacity <= 0
   */
  public HeapPriorityQueue(int capacity) throws IllegalArgumentException {
    heap = new ArrayList<T>(capacity);
  }

  // public methods
  /**
   * Returns the number of items in the priority queue.
   * 
   * @return the size of the heap
   */
  public int size() {
    // Time complexity: O(1)
    return heap.size();
  }

  /**
   * Returns (but does not remove) an entry with minimal key (if any).
   * 
   * @return the node having the highest priority in the heap
   * @throws EmptyQueueException if this heap priority queue is empty
   */
  @Override
  public T peekBest() {
    // Time complexity: O(1)
    if (heap.isEmpty())
      throw new EmptyQueueException( "\n\tWARNING: Unable to perform " + "peekBest operation. The queue is empty"); 
    return heap.get(0); // return the root
  }

  /**
   * Inserts a newObject to the heap
   * 
   * @param newObject element to insert in the heap
   */
  @Override
  public void insert(T newObject) {
    // Time complexity: O(log(n)), n represents the size of the heap
    heap.add(newObject); // add to the end of the heap
    upHeap(heap.size() - 1); // upHeap newly added element
  }

  /**
   * Removes and returns an element with minimal key (having the highest priority) if any
   * 
   * @return element having the highest priority
   * @throws EmptyQueueException if performed on an empty priority queue
   */
  @Override
  public T removeBest() {
    // Time complexity: O(log(n)), n represents the size of the heap
    if (heap.isEmpty())
      throw new EmptyQueueException(
          "\n\tWARNING: Unable to perform " + "removeBest operation. The queue is empty"); 

    T item = heap.get(0); // save minimum (root) to be returned at item
        swap(0, heap.size() - 1);     // swap minimum item (root) and the last item of the heap
        heap.remove(heap.size() - 1); // and remove it from the heap;
        downheap(0);                  // then fix new root by calling downheap(root_index)
        return item;
  }

  /**
   * Checks whether the heap is empty or not
   * 
   * @return true if the heap is empty, false otherwise
   */
  @Override
  public boolean isEmpty() {
    return heap.isEmpty();
  }

  // helper methods (utilities)

  /**
   * helper method Returns the index of the parent of the node at position j of the heap
   * 
   * @param j index of a node
   * @return index of the parent of node at position j
   */
  private int getParentIndex(int j) {
    return (j - 1) / 2;
  }

  /**
   * helper method Returns the index of the left child of the node of index j in the heap
   * 
   * @param j index of a node
   * @return index of the left child of j
   */
  private int getLeftChildIndex(int j) {
    return 2 * j + 1;
  }

  /**
   * helper method Returns the index of the right child of the node of index j in the heap
   * 
   * @param j index of a node
   * @return index of the right child of j
   */
  private int getRightChildIndex(int j) {
    return 2 * j + 2;
  }

  /**
   * helper method Checks whether the node of index j has a left child or not
   * 
   * @param j index of a node/element stored in the heap
   * @return true if the node of index j has a left child, false otherwise
   */
  private boolean hasLeftChild(int j) {
    return this.getLeftChildIndex(j) < heap.size();
  }

  /**
   * Checks whether the node of index j has a right child
   * 
   * @param j index of a particular node stored in the heap
   * @return true if the node of index j has a left child, false otherwise
   */
  private boolean hasRightChild(int j) {
    return this.getRightChildIndex(j) < heap.size();
  }

  /**  */
  /**
   * Exchanges the entries of nodes at indices i and j of the heap
   * 
   * @param i index of the first node to exchange content with
   * @param j index of the second node to exchange content with
   */
  private void swap(int i, int j) {
    // Time complexity: O(1)
    T temp = heap.get(i);
    heap.set(i, heap.get(j));
    heap.set(j, temp);
  }

  /**
   * Helper method implements UpHeapBubbling operation (percolate up) Moves the entry at index
   * higher, if necessary, to restore the heap property.
   * 
   * @param index index of node to start the upHeap operation from
   */
  private void upHeap(int index) {
    // percolate-up operation
    // Time complexity: O(log(n)), n represents the size of the heap
    while (index > 0) { // continue until reaching root (or break statement)
      int p = getParentIndex(index);// 1. get parent index
      // 2. compare the element at index with its parent
      if (heap.get(index).compareTo(heap.get(p)) >= 0)
        break; // heap-order property verified
     swap(index, p); // swap the element at index with its parent
      index = p; // continue from the parent's location
      }
    // Note that you can design and implement the recursive version of percolate-up algorithm
  }

  /**
   * Helper method DownHeapBubbling operation (percolate down) Moves the entry at index lower, if
   * necessary, to restore the heap property.
   * 
   * @param index index of node to start the upHeap operation from
   */
  private void downheap(int index) {
    // Time complexity: O(log(n)), n represents the size of the heap
    while (hasLeftChild(index)) { // continue to bottom (or break statement)
      // Compare the key of index with the one of its smallest child
      // (i.e. with the child having the highest priority).
      // if its smallest child has a higher priority than index, so perform
      // a swap with it (down-heap) and continue)
      // otherwise, terminate the down-heap process (the min heap order
      // property is restored).
      int leftIndex = getLeftChildIndex(index);
      int smallChildIndex = leftIndex; // although right may be smaller
      if (hasRightChild(index)) {
        int rightIndex = getRightChildIndex(index);
        if (heap.get(leftIndex).compareTo(heap.get(rightIndex)) > 0)
          smallChildIndex = rightIndex; // right child is smaller
      }
      
      if (heap.get(smallChildIndex).compareTo(heap.get(index)) >= 0)
        break; // heap property has been restored
      swap(index, smallChildIndex);
      index = smallChildIndex; // continue at position of the child
    }
  }

  /**
   * prints the priorityQueue in a String format
   * 
   * @return String representing the priority queue state
   */
  @Override
  public String toString() {
    String s = "";
    s += "PriorityQueue Status:";
    s += "\n\t isEmpty: " + isEmpty();
    s += "\n\t size: " + size();
    s += "\n\t Element having highest priority: " + peekBest();
    s += "\n\t Content: ";

    for (int i = 0; i < size(); i++) {
      s += heap.get(i).toString() + " ";
    }
    return s;
  }

  /**
   * Main method used to test the implementation
   * 
   * @param args
   */
  public static void main(String[] args) {
    // Test the implementation of the HeapPrioityQueue class
    HeapPriorityQueue<Integer> priorityQueue = new HeapPriorityQueue<>(3);
    priorityQueue.insert(5);
    priorityQueue.insert(1);
    priorityQueue.insert(2);
    System.out.println(priorityQueue.toString());
    priorityQueue.insert(0);
    try {
      System.out.println("RemoveBest: " + priorityQueue.removeBest());
      System.out.println(priorityQueue.toString());
      System.out.println("RemoveBest: " + priorityQueue.removeBest());
      System.out.println(priorityQueue.toString());
      System.out.println("RemoveBest: " + priorityQueue.removeBest());
      System.out.println(priorityQueue.toString());
      System.out.println("RemoveBest: " + priorityQueue.removeBest());
      System.out.println(priorityQueue.toString());
      System.out.println("RemoveBest: " + priorityQueue.removeBest());
      System.out.println(priorityQueue.toString());
    } catch (EmptyQueueException e) {
      System.err.println(e.getMessage());
    }
  }
}