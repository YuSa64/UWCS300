import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class CamperBST {

  public CampTreeNode root;
  private int size;
  // LinkedList to maintain current traversal
  private LinkedList<Camper> traversedLList;


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

  // starts tree insertion by calling insertHelp() on the root and
  // assigning root to be the subtree returned by that method
  public void insert(Camper newCamper) {
    root = insertHelp(root, newCamper);
  }

  /**
   * Recursive helper method to insert.
   * 
   * @param current,   The "root" of the subtree we are inserting into, ie the node we are currently
   *                   at.
   * @param newCamper, the camper to be inserted into the tree
   * @return the root of the modified subtree we inserted into
   */
  private CampTreeNode insertHelp(CampTreeNode current, Camper newCamper) {
    if (current == null) {
      current = new CampTreeNode();
      current.setData(newCamper);
      size++;
    } else if (current.getData().compareTo(newCamper) < 0) {
      current.setRightNode(insertHelp(current.getRightNode(), newCamper));
    } else if (current.getData().compareTo(newCamper) > 0) {
      current.setLeftNode(insertHelp(current.getLeftNode(), newCamper));
    }
    return current;
  }

  // Prints the contents of this tree in alphabetical order
  // based on the string "lastName, firstName"
  public void print() {
    printHelp(root);
  }

  private void printHelp(CampTreeNode current) {
    if (current == null) {
      return;
    }
    printHelp(current.getLeftNode());
    System.out.println(current.getData());
    printHelp(current.getRightNode());
  }

  /**
   * Deletes a Camper into the binary search tree if it exists.
   * 
   * @param key, the camper to be deleted from the tree
   * @throws NoSuchElementException if it is thrown by deleteHelp
   */
  public void delete(Camper key) throws NoSuchElementException {
    root = deleteHelp(root, key);
  }

  /**
   * Recursive helper method to delete.
   * 
   * @param current, The "root" of the subtree we are deleting from, ie the node we are currently
   *                 at.
   * @param key,     the camper to be deleted from the tree
   * @return the root of the modified subtree we deleted from
   * @throws NoSuchElementException if the camper is not in the tree
   */
  private CampTreeNode deleteHelp(CampTreeNode current, Camper key) {
    /* YOUR RECURSIVE IMPLEMENTATION OF DELETE HERE */

    if (current == null) {
      return current;
    }


    if (current.equals(root)) {
      Iterator<Camper> itr = traverse("INORDER");
      boolean isIntree = false;
      while (itr.hasNext()) {
        if (itr.next().compareTo(key) == 0)
          isIntree = true;
      }
      if (!isIntree)
        throw new NoSuchElementException();
    }

    if (current.getData().compareTo(key) < 0) {
      current.setRightNode(deleteHelp(current.getRightNode(), key));
    } else if (current.getData().compareTo(key) > 0) {
      current.setLeftNode(deleteHelp(current.getLeftNode(), key));
    } else {
      size--;
      if (current.getRightNode() == null)
        return current.getLeftNode();
      else if (current.getLeftNode() == null)
        return current.getRightNode();

      CampTreeNode temp = current.getRightNode();
      while (temp.getLeftNode() != null)
        temp = temp.getLeftNode();

      current.setData(temp.getData());
      current.setRightNode(deleteHelp(current.getRightNode(), key));
    }

    return current;
  }

  // returns an iterator of camper in the correct order as designated
  public Iterator<Camper> traverse(String order) {
    // first time traversing need to initialize LinkedList
    if (traversedLList == null) {
      traversedLList = new LinkedList<Camper>();
    } else {
      // clear the list to start over for a new traversal
      traversedLList.clear();
    }
    traverseHelp(root, order);
    return traversedLList.listIterator();
  }

  /**
   * Recursive helper method to traverse. Will take the current CampTreeNode’s data and add it to
   * traversedLList based on the given order. Then continue to recurse on the correct subtree.
   * 
   * @param current, the root of the current subtree we are traversing
   * @param order,   the type of traversal to perform
   */
  private void traverseHelp(CampTreeNode current, String order) {
    /* YOUR IMPLEMENTATION OF TRAVERSE HERE */
    if (current == null)
      return;
    if (order.equals("PREORDER")) {
      traversedLList.add(current.getData());
      traverseHelp(current.getLeftNode(), order);
      traverseHelp(current.getRightNode(), order);
    } else if (order.equals("POSTORDER")) {
      traverseHelp(current.getLeftNode(), order);
      traverseHelp(current.getRightNode(), order);
      traversedLList.add(current.getData());
    } else if (order.equals("INORDER")) {
      traverseHelp(current.getLeftNode(), order);
      traversedLList.add(current.getData());
      traverseHelp(current.getRightNode(), order);
    }
  }
}
