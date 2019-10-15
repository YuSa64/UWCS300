import java.io.File;
import java.io.IOException;

public class MemeageTests {
  public static void main(String[] args) {
    System.out.println(testFourBytesGetBits());
    System.out.println(testFourBytesSetBits());
    System.out.println(testColor());
    System.out.println(testImage());
  }

  public static boolean testFourBytesGetBits() {
    FourBytes test = new FourBytes(Integer.parseInt("11010000000000", 2)); // bitstring:
                                                                           // 110100 00000000
    if (test.getBits(14, 0) == 13312)
      return true;
    else
      return false;
  }

  public static boolean testFourBytesSetBits() {
    FourBytes test = new FourBytes(0); // bitstring: 000 00000000
    test.setBits(3, 8, 5); // bitstring: 101 00000000
    if (test.getBits(11, 0) == 1280)
      return true;
    else
      return false;
  }

  public static boolean testColor() {
    Color test = new Color(255, 224, 255, 255); // bitstring: 1111111 11100000 11111111 11111111
    // which is equal to -2031617
    if (test.getARGB() != -2031617)
      return false;
    test.setARGB(-1073807105); //bitstring: 10111111 11111111 00000000 11111111
    if (test.getAlpha() != 191 || test.getRed() != 255 || test.getGreen() != 0
        || test.getBlue() != 255)
      return false;
    return true;

  }

  public static boolean testImage() {
    File image = new File("testImage.png");
    Image test;
    try {
      test = new Image(image);
      if(test.getHeight() !=3 || test.getWidth() != 3)
        return false;
      if(test.getColor(1, 1).getARGB() != -16711681)
        return false;
      return true;
    } catch (IOException e) {
      return false;
    } 
  }
}
