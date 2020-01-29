/**
 * Generic class that models a BinaryNode of a BinarySearchTree (BST)
 * @param <T> type parameter that represents the type of data in this BinaryNode
 */

public class BinaryNode<T> {
  private T data; // data in the node field
  private BinaryNode<T> left; // reference to the left child
  private BinaryNode<T> right; // reference to the right child

  /**
   * Creates a binary node with a given data value
   * 
   * @param data
   */
  public BinaryNode(T data) {
    this.data = data;
  }

  // To use the following overloaded constructor to create a new  BinaryNode 
  // of a BinarySearchTree you should make sure that:
  // (1) the given left reference refers to a BinarySearchTree,
  // (2) the right reference refers to a BinarySearchTree as well, and
  // (3) the left.getData().compareTo(data) is negative (<0), 
  //     and right.getData().compareTo(data) is positive (>0).
  // Otherwise, the search order property for a binary search tree will
  // be violated.
  /**
   * Creates a BinaryNode with given data value, a reference to a left child (left subtree) and a
   * reference to a right child (right sub-tree)
   * 
   * @param data element held by the current binary node
   * @param left reference to the left child
   * @param right reference to the right child
   */
  public BinaryNode(T data, BinaryNode<T> left, BinaryNode<T> right) {
    this.data = data;
    this.left = left;
    this.right = right;
  }

  // Setters and Getters Methods

  /**
   * Getter of left child
   * 
   * @return the left
   */
  public BinaryNode<T> getLeft() {
    return left;
  }

  /**
   * Setter for left child
   * 
   * @param left the left to set
   */
  public void setLeft(BinaryNode<T> left) {
    this.left = left;
  }

  /**
   * Getter of the right child
   * 
   * @return the right
   */
  public BinaryNode<T> getRight() {
    return right;
  }

  /**
   * Setter for the right child
   * 
   * @param right the right to set
   */
  public void setRight(BinaryNode<T> right) {
    this.right = right;
  }

  /**
   * Getter of data field
   * 
   * @return the data
   */
  public T getData() {
    return data;
  }

  /**
   * @param data the data to set
   */
  public void setData(T data) {
    this.data = data;
  }
}
