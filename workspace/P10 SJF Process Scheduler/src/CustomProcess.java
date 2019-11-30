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
public class CustomProcess implements java.lang.Comparable<CustomProcess> {

  private static int nextProcessId = 1; // stores the id to be assigned to the next process to be
                                        // created
  private final int PROCESS_ID; // unique identifier for this process
  private int burstTime; // time required by this process for CPU execution

  /**
   * Constructor of CustomProcess instance
   * 
   * @param burstTime of the instance
   */
  public CustomProcess(int burstTime) {
    if (burstTime <= 0)
      throw new IllegalArgumentException("Argument should be non-zero positive int!");
    this.PROCESS_ID = nextProcessId++;
    this.burstTime = burstTime;
  }

  /**
   * returns process id of the instance
   * 
   * @return process id of the instance
   */
  public int getProcessId() {
    return PROCESS_ID;
  }

  /**
   * returns burst time of the instance
   * 
   * @return burst time of the instance
   */
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
  /**
   * Compares different CustomProcess instances p1.compareT o(p2) < 0 means that the p1 is smaller
   * than p2.
   * p1.compareT o(p2) == 0 means that p1 and p2 are equals with respect to the comparison
   * criteria. 
   * p1.compareT o(p2) > 0 means that p1 is larger than p2.
   */
  public int compareTo(CustomProcess other) {
    if (other.getBurstTime() != burstTime)
      return burstTime - other.getBurstTime();
    else
      return PROCESS_ID - other.getProcessId();
  }
}
