
public class MemeageTests {
  public static void main(String[] args) {
    System.out.println(testFourBytesGetBits());
    System.out.println(testFourBytesSetBits());
    System.out.println(testColor());
  }

  public static boolean testFourBytesGetBits() {
    FourBytes test = new FourBytes(Integer.parseInt("11010000000000", 2)); //bitstring: 110100 00000000
    if (test.getBits(14, 0) == 13312)
      return true;
    else
      return false;
  }

  public static boolean testFourBytesSetBits() {
    FourBytes test = new FourBytes(0); //bitstring: 000 00000000
    test.setBits(3, 8, 5); // bitstring: 101 00000000
    if (test.getBits(11, 0) == 1280)
      return true;
    else
      return false;
  }

  public static boolean testColor() {
    Color test = new Color(255, 224, 255, 255); //bitstring: 1111111 11100000 11111111 11111111
    // which is equal to -2031617
    System.out.println((int)Long.parseLong("11111111111000001111111111111111", 2));
    if(test.getARGB() != -2031617)
      return false;
    
    return true;

  }

  public static boolean testImage() {

    return false;
  }
}
