import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

public class CampEnrollmentApp {

  public static void main(String[] args) throws IOException {
    List<String> fileLines = Files.readAllLines(Paths.get("sim.txt"));
    CampManager manager = new CampManager();

    for (String s : fileLines) {
      String[] temp = s.split(" ");
      switch (temp[0].charAt(0)) {
        case 'S':
          System.out.println("--- Camp Statistics ---");
          manager.printStatistics();
          System.out.println("-----------------------");
          break;
        case 'E':
          try {
            manager.enrollCamper(new Camper(temp[2], temp[1], Integer.parseInt(temp[3])));
            System.out.println("Enrollment of " + temp[2] + " " + temp[1] +" Successful!");
          } catch (Exception e) {
            System.out.println(e.getMessage());
          }
          break;
        case 'R':
          try {
          manager.unenrollCamper(new Camper(temp[2], temp[1], 11));
          System.out.println("Unenrollment of " + temp[2] + " " + temp[1] +" Successful!");
          } catch (Exception e) {
            System.out.println("That camper is not enrolled.");
          }
          break;
        case 'T':
          Iterator<Camper> itr = manager.traverse(temp[1]);
          System.out.println("--- " + temp[1] + " Traversal ---");
          while (itr.hasNext()) {
            System.out.println(itr.next().toString());
          }
          System.out.println("--------------------------");
          break;
        default:
          break;

      }

    }

  }


}
