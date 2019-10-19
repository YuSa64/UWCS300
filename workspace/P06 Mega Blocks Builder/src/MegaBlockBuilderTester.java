
public class MegaBlockBuilderTester {

  public static void main(String[] args) {
    System.out.println(testMegaBlockEquals());
    System.out.println(testMegaBlockToString());
    System.out.println(testLinkedMegaBlock());
  }
  public static boolean testMegaBlockEquals() {
    MegaBlock a = new MegaBlock(Color.RED, 't');
    MegaBlock b = new MegaBlock(Color.RED, 't');
    MegaBlock c = new MegaBlock(Color.YELLOW, 'T');
    return a.equals(b) && !a.equals(c);    
  }
  public static boolean testMegaBlockToString() {
    MegaBlock test = new MegaBlock(Color.BLUE, 'B');
    return test.toString().equals("BLUE B");
  }
  public static boolean testLinkedMegaBlock() {
    return false;
  }
}
