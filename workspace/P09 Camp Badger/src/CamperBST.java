
public class CamperBST {

  public CampTreeNode root;
  private int size;

  public CamperBST() {
    root = null;
    size = 0;
  }

  /**
   * returns the current size of the CamperBST
   * 
   * @return
   */
  public int size() {
    return size;
  }

  /**
   * returns true if the tree is empty, false otherwise
   * 
   * @return
   */
  public boolean isEmpty() {
    return root == null;
  }


}
