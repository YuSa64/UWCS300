import java.util.Scanner;

public class ProcessScheduler {

  private int currentTime; // stores the current time after the last run
  private int numProcessesRun; // stores the number of processes run so far
  private WaitingProcessQueue queue; // this processing unit’s queue

  public ProcessScheduler() {
    currentTime = 0;
    numProcessesRun = 0;
    queue = new WaitingProcessQueue();
  }

  /**
   * This method inserts the given process in the WaitingProcessQueue queue.
   * @param process to inserts in queue
   */
  public void scheduleProcess(CustomProcess process) {
    queue.insert(process);
  }

  /**
   *  runs the ready processes already scheduled in this processScheduler’s queue
   * @return String of whole process run
   */
  public String run() {
    String output = "";
    int size = queue.size();
    output += "Starting " + size;
    if (queue.size() <= 1)
      output += " process\n\n";
    else
      output += " processes\n\n";

    for (int i = 0; i < size; i++) {
      output += "Time " + currentTime + " : Process ID " + queue.peekBest().getProcessId()
          + " Starting.\n";
      currentTime += queue.peekBest().getBurstTime();
      output += "Time " + currentTime + " : Process ID " + queue.removeBest().getProcessId()
          + " Completed.\n";
      numProcessesRun++;
    }

    output += "\nTime " + currentTime + ": All scheduled processes completed.\n";
    return output;
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    ProcessScheduler scd = new ProcessScheduler();
    System.out.print("========== Welcome to the SJF Process Scheduler App ========\n");
    boolean roop = true;
    do {
      String[] command;
      System.out.print(
          "\nEnter command:\n[schedule <burstTime>] or [s <burstTime>]\n[run] or [r]\n[quit] or [q]\n\n");
      command = scn.nextLine().split(" ");
      if (command[0].equals("schedule") || command[0].equals("s")) {
        try {
          CustomProcess temp = new CustomProcess(Integer.parseInt(command[1]));
          scd.scheduleProcess(temp);
          System.out.print("Process ID " + temp.getProcessId() + " scheduled. Burst Time = "
              + temp.getBurstTime() + "\n");
        } catch (Exception e) {
          System.out.print("WARNING: burst time MUST be an integer!\n");
        }
      } else if (command[0].equals("run") || command[0].equals("r")) {
        System.out.print(scd.run());
      } else if (command[0].equals("quip") || command[0].equals("q")) {
        roop = false;
      } else {
        System.out.print("WARNING: Please enter a valid command!\n");
      }

    } while (roop);
    System.out.print(scd.numProcessesRun + " processes run in " + scd.currentTime
        + " units of time!\nThank you for using our scheduler!\nGoodbye!");
    scn.close();

  }
}
