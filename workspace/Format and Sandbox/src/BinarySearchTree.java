import java.util.NoSuchElementException;

/**
 * CS300 - Programming II University of Wisconsin at Madison Implementation of the BinarySearchTree
 * class
 * @param <T> type parameter of the data field of a binary node T should be a reference type (class)
 *        that implements the comparable interface or extends a class that implements the comparable
 *        interface (compareTo method should be defined to compare to objects of type <T>
 */

public class BinarySearchTree <T extends Comparable<T>> {
  private BinaryNode<T> root; // root of the BST

  /**
   * Creates an empty instance of a Binary Search Tree
   */
  public BinarySearchTree() {
    root = null;
  }


  /**
   * Checks whether the BST is empty
   * 
   * @return true if the BST is empty, false otherwise
   */
  public boolean isEmpty() {
    return root == null;
  }

  /**
   * print all the elements in the BST according to the pre-order traversal algorithm Time
   * Complexity: O(n) ; n number of nodes in the tree
   */
  public void printPreOrder() {
    if (isEmpty()) {
      System.out.println("The BST is empty.");
    } else {
      printPreOrderHelper(root); // recursive algorithm
    }
  }

  /**
   * Recursive helper method to perform a pre-order traversal of the BST
   * 
   * @param currentNode
   */
  private void printPreOrderHelper(BinaryNode<T> currentNode) {
    // process the parent
    System.out.print(currentNode.getData() + " ");
    // recur on the left sub-tree if currentNode has a left child
    if (currentNode.getLeft() != null)
      printPreOrderHelper(currentNode.getLeft());
    // recur on the right sub-tree if the currentNode has a right child
    if (currentNode.getRight() != null)
      printPreOrderHelper(currentNode.getRight());
  }

  
  /**
   * Prints the Tree content in a sorted order: performs an in-order traversal of the BST
   */
  public void printTreeSortedOrder() {
    if (isEmpty())
      System.out.println("Empty BST.");
    else {
      System.out.print(printInOrderHelper(root));
    }
  }

  /**
   * Recursive helper method to perform a in-order traversal of the BST
   * 
   * @param currentNode root of the subtree
   */
  private static <T extends Comparable<T>> String printInOrderHelper(BinaryNode<T> currentNode) {
    String result = ""; // String representation of the in-order traversal of the subtree routed at
                        // currentNode, initialized to an empty String
    // recursive cases
    if (currentNode != null) {
      // recur on the left sub-tree if currentNode has a left child
      result = result + printInOrderHelper(currentNode.getLeft());
      // process the parent
      result = result + currentNode.getData().toString() + " ";
      // recur on the right sub-tree if the currentNode has a right child
      result = result + printInOrderHelper(currentNode.getRight());
    }
    // else // Base case: empty subtree (currentNode is null) --> return the empty String result
    return result;
  }

 /**
   * Checks whether the BST contains item
   * 
   * @param item: The item we're looking for
   * @return true if item is present in the Binary Search Tree, false otherwise
   */
  public boolean contains(T item) {
    // running time complexity = O(n); n represents the size of this BST
    return containsHelper(item, root);
  }

  /**
   * Helper method that checks if the subtree rooted at a given node contains item
   * 
   * @param item to look for in the subtree rooted at node
   * @param node current node in a binary search tree
   * @return true if the subtree rooted at node contains item, false otherwise
   */
  private  static <T extends Comparable<T>> boolean containsHelper(T item, BinaryNode<T> node) {
    // Recursive algorithm
    if (node == null) // reach a leaf or binary search tree empty
      return false; // unsuccessful search
    if (item.compareTo(node.getData()) == 0)
      // successful search
      return true;
    if (item.compareTo(node.getData()) < 0)
      return containsHelper(item, node.getLeft()); // recur on the left child (left sub-tree)
    return containsHelper(item, node.getRight()); // recur on the right child (right sub-tree)
  }



  /**
   * Computes and returns the number of items stored in this BST
   * 
   * @return the number of items stored in this BST
   */
  public int size() {
    return sizeHelper(root);

  }

  /**
   * Helper method that returns the number of items stored in the subtree rooted at a given
   * BinaryNode
   * 
   * @param current BinaryNode that represents a root of a subtree
   * @return the size of the subtree rooted at current
   */
  private static <T> int sizeHelper(BinaryNode<T> current) {
    // TODO Complete missing code
    if (current == null) // Base case (empty subtree --> its size is zero)
      return 0;
    else
      // recursive case (non-empty subtree)
      // Count current + the size of the subtree rooted at its left child + the size of the subtree
      // rooted at its right child
      return 1 + sizeHelper(current.getLeft()) + sizeHelper(current.getRight());
  }

  /**
   * Computes and returns the height of this BST, counting the number of nodes from root to the
   * deepest leaf in this BST.
   * 
   * @return the height of this BST
   */
  public int height() {
    return heightHelper(root);
  }

  /**
   * Helper method that computes the height of the subtree rooted at current, counting the number of
   * nodes from the specified current root to the deepest leaf in the specified subtree.
   * 
   * @param current pointer to the root of a subtree
   * @return height of the subtree rooted at current
   */
  private static <T> int heightHelper(BinaryNode<T> current) {
   // TODO Complete missing code
    if (current == null) // base case (empty subtree --> its height is zero)
      return 0;
    else // recursive case
      // The height of the non-empty subtree rooted at current is one (counting current) +
      // the maximum of the height of its left subtree and the height of its right subtree.
      return 1 + Math.max(heightHelper(current.getLeft()), heightHelper(current.getRight()));
  }

  /**
   * adds an item to this binary search tree
   * 
   * @param item to insert/add to this binary search tree (BST)
   */
  public void add(T item) {
    if (isEmpty()) // tree is empty
      root = new BinaryNode<T>(item); // add item at root position of this BST
    else
      addHelper(item, root); // make call to addHelper to recursively add item to this BST
  }

  /**
   * Utility/Helper method to insert into a subtree rooted at node
   * 
   * @param newItem the item to add.
   * @param node the node that roots the tree.
   * @throws DuplicateItemException if the newItem is already present.
   */
  private static <T extends Comparable<T>> void addHelper(T newItem, BinaryNode<T> node) {

    if (newItem.compareTo(node.getData()) < 0) {
      // add newItem to the left subtree
      if (node.getLeft() == null) // no left child
        node.setLeft(new BinaryNode<T>(newItem)); // add newItem at the left child position of node
      else // recur on the left subtree of the current node
        addHelper(newItem, node.getLeft());
    } else if (newItem.compareTo(node.getData()) > 0) {
      if (node.getRight() == null) // no right child
        node.setRight(new BinaryNode<T>(newItem)); // add newItem at the right child position of
                                                   // node
      else // recur on the right subtree of the current node
        addHelper(newItem, node.getRight());
    } else // duplicate item
      throw new DuplicateItemException(
          "WARNING! Duplicate entry " + newItem.toString() + " already present."); // Duplicate
                                                                                   // entry
  }

  /**
   * Helper method to find the smallest item in a subtree rooted at BinaryNode
   * Recursive method
   * @param node the node that roots the subtree.
   * @return node containing the smallest item.
   */
  private BinaryNode<T> getMin(BinaryNode<T> node) {
    if (node == null)
      return null; // fail to find a min of an empty subtree
    // return the most left node in the subtree rooted at node
    else if (node.getLeft() == null)
      return node;
    return getMin(node.getLeft());
  }

  /**
   * Helper method to find the largest item in a subtree.
   * Iterative version
   * @param node the node that roots the subtree.
   * @return node containing the largest item.
   * @throws NoSuchElementException if item is not found in the tree
   */
  private BinaryNode<T> getMax(BinaryNode<T> node) {
    if (node != null)// fail to find a min of an empty subtree
      // return the most right node in the subtree rooted at node
      while (node.getRight() != null)
        node = node.getRight();

    return node;
  }

  /**
   * Helper method to remove from a specific item from a subtree.
   * 
   * @param item the item to remove.
   * @param node the node that roots the subtree.
   * @return the new root of the subtree.
   * @throws NoSuchElementException if item is not found in the tree
   */
  private BinaryNode<T> removeHelper(T item, BinaryNode<T> node) {
    if (node == null)
      // item not found
      throw new NoSuchElementException("Warning: Unable to remove an item not found in this tree");
    if (item.compareTo(node.getData()) < 0)
      // recur on the left subtree rooted at node.getLeft()
      node.setLeft(removeHelper(item, node.getLeft()));

    else if (item.compareTo(node.getData()) > 0)
      // recur on the right subtree
      node.setRight(removeHelper(item, node.getRight()));
    else // item found
    if (node.getLeft() != null && node.getRight() != null) {
      // node has two children
      // replace the data of node with the data field value of the smallest element at the right
      // subtree
      node.setData(getMin(node.getRight()).getData());

      // remove that binary node (the binary node holding the smallest element at the right subtree)
      // that node should be either a leaf or a node that has only one child (right child)
      node.setRight(removeHelper(node.getData(), node.getRight()));

    } else // node has one child
    if (node.getLeft() != null) // node has a left child, adjust this node to its left child
      node = node.getLeft();
    else
      node = node.getRight(); // node has a left child, adjust this node to its left child
    return node; // return the new root of this subtree, otherwise, the changes will be lost after
                 // the method returns
  }

  /**
   * Removes item from this BST
   * 
   * @param item to be removed from this BinarySearchTree and
   * @throws NoSuchElementException if item is not found in the tree
   */
  public void remove(T item) {
    if (isEmpty())
      throw new NoSuchElementException();
    else
      removeHelper(item, root);
 
  }

}