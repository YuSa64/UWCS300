
public class LinkedMegaBlock {
  
  private MegaBlock block; // data field of this linkedMegaBlock
  private LinkedMegaBlock next; // link to the next linkedMegaBlock

  public LinkedMegaBlock(MegaBlock block) {
    this.block = block;
  }
  public LinkedMegaBlock(MegaBlock block, LinkedMegaBlock next) {
    this.block = block;
    this.next = next;
  }
  public MegaBlock getBlock() {
    return block;
  }
  public LinkedMegaBlock getNext() {
    return next;
  }
  public void setBlock(MegaBlock block) {
    this.block = block;
  }
  public void setNext(LinkedMegaBlock next) {
    this.next = next;
  }
}
