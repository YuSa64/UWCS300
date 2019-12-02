//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: P10 SJF Process Scheduler
// Files: CustomProcess.java, ProcessScheduler.java, ProcessSchedulerTester.java,
//////////////////// WaitingProcessQueue.java
// Course: CS300 Fall 2019
//
// Author: Hyeon Jun Jeong
// Email: hjeong44@wisc.edu
// Lecturer's Name: Mouna Ayari Ben Hadj Kacem
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
import java.util.NoSuchElementException;

/**
 * Queue class of the CustomProcess instances
 * 
 * @author Hyeon Jun Jeong/hjeong44@wisc.edu
 */
public class WaitingProcessQueue implements WaitingQueueADT<CustomProcess> {

  private static final int INITIAL_CAPACITY = 20; // the initial capacity of this waiting process
                                                  // queue
  private CustomProcess[] data; // min heap-array storing the CustomProcesses inserted in this
                                // WaitingProcessQueue. data is an oversize array
  private int size; // number of CustomProcesses stored in this WaitingProcessQueue


  public WaitingProcessQueue() {
    data = new CustomProcess[INITIAL_CAPACITY];
    size = 0;
  }

  @Override
  /**
   * inserts a newObject in this waiting queue.
   * 
   * @param newObject to insert in this waiting queue
   */
  public void insert(CustomProcess newObject) {
    // TODO Auto-generated method stub
    if (size + 1 < data.length) {
      if (isEmpty()) {
        data[0] = newObject;
      } else {
        data[size] = newObject;
        minHeapPercolateUp(size);
      }
      size++;
    } else {
      CustomProcess[] temp = new CustomProcess[data.length + INITIAL_CAPACITY];
      for (int i = 0; i < size; i++)
        temp[i] = data[i];
      data = temp;
      insert(newObject);
    }
  }

  @Override
  /**
   * removes and returns the element with the highest priority.
   * 
   * @return the removed element
   * @throws java.util.NoSuchElementException with a descriptive error message if this waiting queue
   *                                          is empty
   */
  public CustomProcess removeBest() {
    // TODO Auto-generated method stub
    if (isEmpty())
      throw new NoSuchElementException("This waiting queue is empty!");
    CustomProcess output = data[0];
    data[0] = data[size - 1];
    data[size - 1] = null;
    minHeapPercolateDown(0);
    size--;
    return output;
  }

  @Override
  /**
   * returns without removing the element with the highest priority.
   * 
   * @return the element with the highest priority
   * @throws java.util.NoSuchElementException with a descriptive error message if this waiting queue
   *                                          is empty
   */
  public CustomProcess peekBest() {
    // TODO Auto-generated method stub
    if (isEmpty())
      throw new NoSuchElementException("This waiting queue is empty!");
    return data[0];
  }

  @Override
  /**
   * returns size of priority queue
   * 
   * @return the size of priority queue
   */
  public int size() {
    // TODO Auto-generated method stub
    return size;
  }

  @Override
  /**
   * checks whether this waiting queue is empty or not.
   * 
   * @return true if this waiting queue is empty, false otherwise
   */
  public boolean isEmpty() {
    // TODO Auto-generated method stub
    return size == 0;
  }

  /**
   * Percolate up the data in given index
   * 
   * @param index of the data to percolate up
   */
  private void minHeapPercolateUp(int index) {
    int root = (index - 1) / 2;
    if (data[index].compareTo(data[root]) < 0) {
      CustomProcess temp = data[index];
      data[index] = data[root];
      data[root] = temp;

      minHeapPercolateUp(root);
    }
  }

  /**
   * Percolate down the data in given index
   * 
   * @param index of the data to percolate down
   */
  private void minHeapPercolateDown(int index) {
    int root = index, r = 2 * index + 2, l = 2 * index + 1;
    if (data[l] != null && l < size && data[l].compareTo(data[root]) < 0)
      root = l;
    if (data[r] != null && r < size && data[r].compareTo(data[root]) < 0)
      root = r;
    if (root != index) {
      CustomProcess temp = data[index];
      data[index] = data[root];
      data[root] = temp;

      minHeapPercolateDown(root);
    }
  }

}
