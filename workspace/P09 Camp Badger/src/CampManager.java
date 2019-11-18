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

public class CampManager {

  private CamperBST campers;
  private final static String[] CABIN_NAMES =
      new String[] {"Otter Overpass", "Wolverine Woodland", "Badger Bunkhouse"};

  /**
   * Constructor of CampManager instance
   */
  public CampManager() {
    campers = new CamperBST();
  }

  /**
   * enroll a camper to the CamperBST
   * @param newCamper - a camper to be enrolled
   */
  public void enrollCamper(Camper newCamper) {
    if (newCamper.getAge() >= 8 && newCamper.getAge() <= 9)
      newCamper.assignCabin(CABIN_NAMES[0]);
    else if (newCamper.getAge() >= 10 && newCamper.getAge() <= 12)
      newCamper.assignCabin(CABIN_NAMES[1]);
    else if (newCamper.getAge() >= 13 && newCamper.getAge() <= 14)
      newCamper.assignCabin(CABIN_NAMES[2]);
    campers.insert(newCamper);
  }

  /**
   * print out the numver of campers
   */
  public void printStatistics() {
    System.out.println("Number of Campers: " + campers.size());
  }

  /**
   * return an Iterator with ordered traverse
   * @param order - the type of traversal to perform
   * @return an Iterator with ordered traverse
   */
  public java.util.Iterator<Camper> traverse(String order) {
    return campers.traverse(order);
  }
  
  /**
   * Unenroll the camper from the CamperBST
   * @param delCamper - a camper to be unenrolled
   * @throws java.util.NoSuchElementException - when delCamper does not exist in CamperBST
   */
  public void unenrollCamper(Camper delCamper) throws java.util.NoSuchElementException {
    campers.delete(delCamper);
  }
}
