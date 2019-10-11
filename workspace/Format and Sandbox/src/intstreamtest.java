import java.io.File;
import java.util.Random;

public class intstreamtest {
 public static void main(String[] args) {
   Random rand = new Random(Utility.getSeed());
   System.out.print(rand.ints(12).toString());
 }
}
