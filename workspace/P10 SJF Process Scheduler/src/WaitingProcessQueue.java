import java.util.NoSuchElementException;

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
        size++;
      }
      else {
        for (int i = 0; i < size; i++) {
          if (newObject.compareTo(data[i]) < 0) {
            for (int j = size; j > i; j--)
              data[j] = data[j - 1];
            data[i] = newObject;
            size++;
            return;
          }
        }
        data[size++] = newObject;
      }
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
    for (int i = 0; i < size - 1; i++)
      data[i] = data[i + 1];
    data[size - 1] = null;
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

}
