interface I { public void methodI(); }

class A {
  public void methodA() { System.out.println("A.methodA() called."); }
  public void sing() { System.out.println("A.sing() called.");}
  public static <T> void printValue(T value) {System.out.println(value);} // This is a generic method
}

class B extends A {
  public void methodA() { System.out.println("B.methodA() called.");}
  public void sing() { System.out.println("B.sing() called.");}
  public static <T extends Comparable<T>> T max(T value1, T value2){
    if(value1.compareTo(value2) >= 0)
      return value1;
    return value2;
  } // max() is a generic method
}

class C extends B implements I{
  public void methodA() { System.out.println("C.methodA() called.");}
  public void methodI() { System.out.println("C.methodI() called");}
  public void fly() {System.out.println("C.fly() called");}
}

public class Review {

  public static void main(String[] args) {
    // This diagram illustrates the hierarchy of classes and interface given above
    //  +--------+
    //  + Object +   // java.lang.Object class
    //  +--------+
    //      ^
    //      |
    //  +-------+
    //  +   A   +
    //  +-------+
    //      ^
    //      |
    //  +-------+
    //  +   B   +      +-------+
    //  +-------+      +   I   +
    //      ^          +-------+
    //      |              ^         
    //  +-------+          |
    //  +   C   +----------+         
    //  +-------+                  
   
    
    // 1. Casting
    // Let's consider the following objects and their references
    B b = new C(); // create a new Object instance of C class and upcast its reference to the type B
                   // This is upcasting, its implicit and always true
                   // note here that new C() can be safely upcasted to the following types: B, A, and I
    
    // Which of the methods defined in the classes above are visible from the reference b?
    // Answer: methodA(), sing(), max(), and printValue()
    b.methodA(); // Output: C.methodA() called.
    b.sing();    // Output: B.sing() called.
    
    A a = b; // upcasting
    // Which of the methods defined in the classes above are visible from the reference a?
    // Answer: methodA(), sing(), and printValue()
    a.methodA(); // Output: C.methodA() called.
    a.sing();    // Output: B.sing() called.
    
    // Casting (Downcasting)
    C c = (C)a; // This is downcasting
    c.methodI(); // Output: C.methodI() called
    c.fly(); // Output: C.fly() called

    // 2. Generic methods
    A.printValue(true); // Output: true
    A.printValue("Hello"); // Output: Hello
    System.out.println(B.max("ABC", "ABB")); // Output: ABC
    System.out.println(B.max(10, 15)); // Output: 15
    
    //3. Iterable/ Iterator interfaces
    // You can use for-each loop only if the class implements Iterable interface
  }
}
