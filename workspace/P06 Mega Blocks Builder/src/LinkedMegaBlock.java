//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: Mega Blocks Builder
// Files: LinkedMegaBlock.java, LinkedListMegaBlock.java, MegaBlockBuilderTester.java
// Course: CS300 Fall 2019
//
// Author: Hyeon Jun Jeong
// Email: hjeong44@wisc.edu
// Lecturer's Name: Mouna Ayari Ben Hadj Kacem
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: (identify each person and describe their help in detail)
// Online Sources: (identify each URL and describe their assistance in detail)
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
public class LinkedMegaBlock {

  private MegaBlock block; // data field of this linkedMegaBlock
  private LinkedMegaBlock next; // link to the next linkedMegaBlock

  /**
   * Creates a new LinkedMegaBlock that has a specific MegaBlock as data and null as next reference
   * 
   * @param block - data field to be set for this new LinkedMegaBlock
   */
  public LinkedMegaBlock(MegaBlock block) {
    this.block = block;
  }

  /**
   * Creates a new LinkedMegaBlock with a specific data block and a specific reference to the next
   * LinkedMegaBlock
   * 
   * @param block - data field to be set for this new LinkedMegaBlock
   * @param next  - reference to the next LinkedMegaBlock of this LinkedMegaBlock
   */
  public LinkedMegaBlock(MegaBlock block, LinkedMegaBlock next) {
    this.block = block;
    this.next = next;
  }

  /**
   * Returns the block data field of this LinkedMegaBlock
   */
  public MegaBlock getBlock() {
    return block;
  }

  /**
   * Returns the reference to the next field of this LinkedMegaBlock
   */
  public LinkedMegaBlock getNext() {
    return next;
  }

  /**
   * Sets the block instance field of this LinkedMegaBlock
   * 
   * @param block - the block to set
   */
  public void setBlock(MegaBlock block) {
    this.block = block;
  }

  /**
   * Sets the reference to the next field of this LinkedMegaBlock
   * 
   * @param next - the next to set
   */
  public void setNext(LinkedMegaBlock next) {
    this.next = next;
  }

  /**
   * Returns a String representation of this Linked MegaBlock object. This String will be :
   * block.toString() + " -> " // if next field is not null block.toString() + " -> END" // if next
   * field is null
   */
  public String toString() {
    if (next != null)
      return block.toString() + " -> ";
    else
      return block.toString() + " -> END";
  }
}
