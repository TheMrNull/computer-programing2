public class Test1 {
    public static void main(String[] args) {
         A a = new A();
         System.out.println(a);
         }
 }
 class A {
 private B b;
 public String toString() {
     return b.toString();  // runtime error: null pointer, b is not defined
 }
 }
 class B {
 public int x = 0;
 public String toString() {
     return Integer.toString(x);
 }
}
