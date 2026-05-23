public class Test3 {
 public static void main(String[] args) {
             A obj = new B();
             obj.m(new D());
             }
 }
 class A {
 final void m(C c) { System.out.println("a in a"); }
 }
 class B extends A {
 void m(C c) {System.out.println("c in b"); } //compile error: cannot override a final method (line 8)
 void m(D c) {System.out.println("d in b"); }
 }class C {}
 class D extends C {}
}
