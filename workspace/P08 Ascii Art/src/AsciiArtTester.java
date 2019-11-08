
public class AsciiArtTester {
  public static void Main(String[] args) {
    System.out.println("testStackPushPeek test: " + testStackPushPeek());
  }
  public static boolean testStackPushPeek(){
    DrawingChange testData = new DrawingChange(0,0,'\0','\0');
    DrawingStack testStack = new DrawingStack();
    testStack.push(testData);
    return testStack.peek().equals(testData);
  }
}
