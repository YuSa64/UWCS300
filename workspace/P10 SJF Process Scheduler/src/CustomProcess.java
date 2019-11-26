
public class CustomProcess implements java.lang.Comparable<CustomProcess> {

  private static int nextProcessId = 1; // stores the id to be assigned to the next process to be
                                        // created
  private final int PROCESS_ID; // unique identifier for this process
  private int burstTime; // time required by this process for CPU execution

  public CustomProcess(int burstTime) {
    if (burstTime <= 0)
      throw new IllegalArgumentException("Argument should be non-zero positive int!");
    this.PROCESS_ID = nextProcessId++;
    this.burstTime = burstTime;
  }

  public int getProcessId() {
    return PROCESS_ID;
  }

  public int getBurstTime() {
    return burstTime;
  }

  /**
   * Returns a String representation of this CustomProcess
   * 
   * @return a string representation of this CustomProcess
   */
  public String toString() {
    return "p" + this.PROCESS_ID + "(" + this.burstTime + ")";
  }

  @Override
  public int compareTo(CustomProcess other) {
    if (other.getBurstTime() != burstTime)
      return burstTime - other.getBurstTime();
    else
      return PROCESS_ID - other.getProcessId();
  }
}
