
public class CampManager {

  private CamperBST campers;
  private final static String[] CABIN_NAMES =
      new String[] {"Otter Overpass", "Wolverine Woodland", "Badger Bunkhouse"};

  public CampManager() {
    campers = new CamperBST();
  }

  public void enrollCamper(Camper newCamper) {
    if (campers.isEmpty()) {
      campers.root = new CampTreeNode();
      campers.root.setData(newCamper);
    } else {
      int comparison = campers.root.getData().compareTo(newCamper);
      if (comparison < 0) {
        
      } else if (comparison > 1) {

      }
    }
  }

  public void printStatistics() {

  }

  public java.util.Iterator<Camper> traverse(String order) {
    return null;
  }

  public void unenrollCamper(Camper delCamper) throws java.util.NoSuchElementException {

  }
}
