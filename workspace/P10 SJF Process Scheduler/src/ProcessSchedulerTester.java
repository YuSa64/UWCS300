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
public class ProcessSchedulerTester {

  public static void main(String[] args) {
    System.out.println(testConstructorCustomProcess());
    System.out.println(testCompareToCustomProcess());
    System.out.println(testInsertWaitingProcessQueue());
    System.out.println(testRemoveBestWaitingProcessQueue());
  }

  /**
   * checks the correctness of the constructor operation implemented in the CustomProcess class
   * 
   * @return true if operation works correctly
   */
  public static boolean testConstructorCustomProcess() {
    try {
      new CustomProcess(-10);
      return false;
    } catch (Exception e) {
      return true;
    }
  }

  /**
   * checks the correctness of the compareTo operation implemented in the CustomProcess class
   * 
   * @return true if operation works correctly
   */
  public static boolean testCompareToCustomProcess() {
    CustomProcess testData1 = new CustomProcess(10); // p1(10)
    CustomProcess testData2 = new CustomProcess(10); // p2(10)
    CustomProcess testData3 = new CustomProcess(5); // p3(5)
    return testData1.compareTo(testData2) < 0 && testData2.compareTo(testData3) > 0;
  }

  /**
   * checks the correctness of the insert operation implemented in the WaitingProcessQueue class
   * 
   * @return true if operation works correctly
   */
  public static boolean testInsertWaitingProcessQueue() {
    WaitingProcessQueue tester = new WaitingProcessQueue();
    CustomProcess testData1 = new CustomProcess(10); // p1(10)
    CustomProcess testData2 = new CustomProcess(10); // p2(10)
    CustomProcess testData3 = new CustomProcess(5); // p3(5)
    boolean isSame = false;
    tester.insert(testData2); // p2
    tester.insert(testData1); // p1 p2
    tester.insert(testData3); // p3 p1 p2
    isSame = tester.removeBest().compareTo(testData3) == 0 // p1 p2
        && tester.peekBest().compareTo(testData1) == 0;
    return isSame;
  }

  /**
   * checks the correctness of the removeBest operation implemented in the WaitingProcessQueue class
   * 
   * @return true if operation works correctly
   */
  public static boolean testRemoveBestWaitingProcessQueue() {
    WaitingProcessQueue tester = new WaitingProcessQueue();
    CustomProcess testData1 = new CustomProcess(10); // p1(10)
    CustomProcess testData2 = new CustomProcess(5); // p2(5)
    CustomProcess testData3 = new CustomProcess(20); // p3(20)
    boolean isSame1 = false, isSame2 = false, isSame3 = false;
    tester.insert(testData1); // p1
    tester.insert(testData2); // p2 p1
    isSame1 = tester.removeBest().compareTo(testData2) == 0; // p1
    tester.insert(testData3); // p1 p3
    isSame2 = tester.removeBest().compareTo(testData1) == 0; // p3
    isSame3 = tester.removeBest().compareTo(testData3) == 0; //
    return isSame1 && isSame2 && isSame3;
  }


}
