//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: Camp Badger
// Files: CampEnrollmentApp.java, Camper.java, CamperBST.java, CampManager.java, CampTreeNode.java
// Course: CS300 Fall 2019
//
// Author: Hyeon Jun Jeong
// Email: hjeong44@wisc.edu
// Lecturer's Name: Mouna Ayari Ben Hadj Kacem
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

public class CampEnrollmentApp {

  public static void main(String[] args) throws IOException {
    List<String> fileLines = Files.readAllLines(Paths.get("sim.txt"));
    CampManager manager = new CampManager();

    for (String s : fileLines) {
      String[] temp = s.split(" ");
      switch (temp[0].charAt(0)) {
        case 'S':
          Statistics(manager);
          break;
        case 'E':
          Enroll(manager, new Camper(temp[2], temp[1], Integer.parseInt(temp[3])));
          break;
        case 'R':
          Unenroll(manager, new Camper(temp[2], temp[1], 11));
          break;
        case 'T':
          Traverse(manager, temp[1]);
          break;
        default:
          break;
      }
    }
  }

  /**
   * Enroll the camper to the campmanager
   * 
   * @param manager - a CampManager to enroll the camper
   * @param camper  - a Camper to be enrolled
   */
  public static void Enroll(CampManager manager, Camper camper) {
    try {
      manager.enrollCamper(camper);
      System.out.println(
          "Enrollment of " + camper.getFirstName() + " " + camper.getLastName() + " Successful!");
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * Show statistics of the campmanager
   * 
   * @param manager - a CampManager to show the statistics
   */
  public static void Statistics(CampManager manager) {
    System.out.println("--- Camp Statistics ---");
    manager.printStatistics();
    System.out.println("-----------------------");
  }

  /**
   * Unenroll the camper from the campmanager
   * @param manager - a CampManager to unenroll the camper
   * @param camper - a Camper to be unenrolled 
   */
  public static void Unenroll(CampManager manager, Camper camper) {
    try {
      manager.unenrollCamper(camper);
      System.out.println("Unenrollment of " + camper.getFirstName() + " " + camper.getLastName() + " Successful!");
    } catch (Exception e) {
      System.out.println("That camper is not enrolled.");
    }
  }

  /**
   * Print out traverse of the campmanager
   * @param manager - a CampManager to print traverse
   * @param order - an order of the travese(PREORDER, INORDER, POSTORDER)
   */
  public static void Traverse(CampManager manager, String order) {
    Iterator<Camper> itr = manager.traverse(order);
    System.out.println("--- " + order + " Traversal ---");
    while (itr.hasNext()) {
      System.out.println(itr.next().toString());
    }
    System.out.println("--------------------------");
  }


}
