import java.util.ArrayList;
import java.util.Iterator;

public class iteratortest {
  public static void main(String[] args) {
    ArrayList<String> list = new ArrayList<>();list.add("a");list.add("b");list.add("c");
    Iterator<String> iterator = list.iterator();
    for( int i = 0;i<3;i++) {
  System.out.print(iterator.next());
  }while(iterator.hasNext())
    {
      System.out.print(iterator.next() + " ");
    }
  }
  }

