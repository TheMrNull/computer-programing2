public class Test2 {

    public static void main(String[] args) {
         A a = new A(); a.m();
         B b = new C(); b.m1(1); b.m2(2);
         }
 }
 interface I {
 public int m1(int a);
 }
 interface J {
 public int m2(int b);
 }
 interface K extends I,J {}
 class A {
 public String m() { return "this is A"; }
 }
 class B implements K {
 int x = 500;
 public int m1(int a) { return a * x; }
 public int m2(int b) { return b + x; }
 }
 class C extends A,B {}  //Compilation: class cannot extend more than one class


