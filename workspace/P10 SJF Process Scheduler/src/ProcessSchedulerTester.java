
public class ProcessSchedulerTester {

  public static void main(String[] args) {
    System.out.println(testConstructorCustomProcess());
    System.out.println(testCompareToCustomProcess());
    System.out.println(testInsertWaitingProcessQueue());
    System.out.println(testRemoveBestWaitingProcessQueue());
  }

  // checks the correctness of the constructor operation
  // implemented in the CustomProcess class
  public static boolean testConstructorCustomProcess() {
    return false;
  }
  
  // checks the correctness of the compareTo operation
  // implemented in the CustomProcess class
  public static boolean testCompareToCustomProcess() {
    return false;
  }
  
  // checks the correctness of the insert operation
  // implemented in the WaitingProcessQueue class
  public static boolean testInsertWaitingProcessQueue() {
    WaitingProcessQueue tester = new WaitingProcessQueue();
    CustomProcess testData1 = new CustomProcess(10); // p1(10)
    CustomProcess testData2 = new CustomProcess(10); // p2(10)
    CustomProcess testData3 = new CustomProcess(5); // p3(20)
    boolean isSame = false;
    tester.insert(testData1);
    tester.insert(testData2);
    tester.insert(testData3);
    isSame = tester.peekBest().compareTo(testData3) == 0;
    return isSame;
  }

  // checks the correctness of the removeBest operation
  // implemented in the WaitingProcessQueue class
  public static boolean testRemoveBestWaitingProcessQueue() {
    WaitingProcessQueue tester = new WaitingProcessQueue();
    CustomProcess testData1 = new CustomProcess(10); // p1(10)
    CustomProcess testData2 = new CustomProcess(10); // p2(10)
    CustomProcess testData3 = new CustomProcess(20); // p3(20)
    boolean isSame1 = false, isSame2 = false, isSame3 = false;
    tester.insert(testData1);
    tester.insert(testData2);
    isSame1 = tester.removeBest().compareTo(testData1) == 0;
    tester.insert(testData3);
    isSame2 = tester.removeBest().compareTo(testData2) == 0;
    isSame3 = tester.removeBest().compareTo(testData3) == 0;    
    return isSame1 && isSame2 && isSame3;
  }


}
