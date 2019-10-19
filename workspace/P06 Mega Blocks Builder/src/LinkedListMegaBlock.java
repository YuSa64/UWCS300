import java.util.NoSuchElementException;

public class LinkedListMegaBlock {
  private LinkedMegaBlock head; // head of this list
  private LinkedMegaBlock tail; // tail of this list
  private int size; // size of this list (total number of megablocks stored in this list)
  private int redCount; // number of RED megablocks stored in this list
  private int yellowCount; // number of YELLOW megablocks stored in this list
  private int blueCount; // number of BLUE megablocks stored in this list

  public LinkedListMegaBlock() {
    clear();
  }

  public void addBlue(MegaBlock blueBlock) {
    if(blueBlock == null || blueBlock.getColor() != Color.BLUE)
      throw new IllegalArgumentException();
    if(head == null || tail == null) {
      head = new LinkedMegaBlock(blueBlock);
      tail = head;
    } else {
      tail.setNext(new LinkedMegaBlock(blueBlock));
      tail = tail.getNext();
    }
  }

  public void addRed(MegaBlock redBlock) {
    if(redBlock == null || redBlock.getColor() != Color.RED)
      throw new IllegalArgumentException();
    if(head == null || tail == null) {
      head = new LinkedMegaBlock(redBlock);
      tail = head;
    } else {
      LinkedMegaBlock current = head;
      head = new LinkedMegaBlock(redBlock);
      head.setNext(current);
    }
  }

  public void addYellow(int index, MegaBlock yellowBlock) {
    if(yellowBlock == null || yellowBlock.getColor() != Color.YELLOW)
      throw new IllegalArgumentException();
    if(head == null || tail == null) {
      head = new LinkedMegaBlock(yellowBlock);
      tail = head;
    } else {
      if(index < redCount || index > size- blueCount)
        throw new IndexOutOfBoundsException();
      LinkedMegaBlock current = head, add = new LinkedMegaBlock(yellowBlock);
      for(int i = 0; i < index-1; i++) {
        current = current.getNext();
      }
      add.setNext(current.getNext().getNext());
      current.setNext(add);
    }
  }

  public void clear() {
    head = null;
    tail = null;
    size = 0;
    redCount = 0;
    yellowCount = 0;
    blueCount = 0;
  }

  public MegaBlock get(int index) {
    if(index < 0 || index >= size)
      throw new IndexOutOfBoundsException();
    LinkedMegaBlock links = head;
    for (int i = 0; i < index; i++) {
      links = links.getNext();
    }
    return links.getBlock();
  }

  public int getBlueCount() {
    return blueCount;
  }

  public int getRedCount() {
    return redCount;
  }

  public int getYellowCount() {
    return yellowCount;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public MegaBlock removeBlue() {
    if(redCount == 0) 
      throw new NoSuchElementException();
    LinkedMegaBlock output = tail, current = head;
    while (current.getNext().getNext() != null) {
      current = current.getNext();
    }
    tail = current;
    tail.setNext(null);
    blueCount--;
    return output.getBlock();
  }

  public MegaBlock removeRed() {
    if(redCount == 0) 
      throw new NoSuchElementException();
    LinkedMegaBlock current = head;
    head = head.getNext();
    redCount--;
    return current.getBlock();
  }

  public MegaBlock removeYellow(int index) {
    if(index < redCount || index > size- blueCount)
      throw new IndexOutOfBoundsException();
    LinkedMegaBlock current = head, output;
    for (int i = 0; i < redCount - 1; i++) {
      current = current.getNext();
    }
    output = current.getNext();
    current.setNext(current.getNext().getNext());
    return output.getBlock();
  }

  public MegaBlock set(int index, MegaBlock block) {
    if(index < 0 || index >= size)
      throw new IndexOutOfBoundsException();
    LinkedMegaBlock current = head, output = null;
    for (int i = 0; i < index; i++) {
      current = current.getNext();
    }
    if (block == null || get(index).getColor() != block.getColor())
      throw new IllegalArgumentException();
    else
      output = current;
    current.setBlock(block);
    return output.getBlock();
  }

  public int size() {
    return size;
  }

  public String toString() {
    String output = "";
    LinkedMegaBlock current = head;
    while (current.getNext() != null) {
      output += current.toString();
    }
    return output;
  }
}
