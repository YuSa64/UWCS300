
public class ProcessScheduler {

  private int currentTime; // stores the current time after the last run
  private int numProcessesRun; // stores the number of processes run so far
  private WaitingProcessQueue queue; // this processing unit’s queue
  
  public ProcessScheduler() {
    currentTime = 0;
    numProcessesRun = 0;
    queue = new WaitingProcessQueue();
  }

  // This method inserts the given process in the WaitingProcessQueue queue.
  public void scheduleProcess(CustomProcess process) {
    queue.insert(process);
  }

  // runs the ready processes already scheduled in this processScheduler’s queue
  public String run() {
    
    return null;
  }

}
