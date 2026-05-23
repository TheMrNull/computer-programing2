 public class Test6 {
 public static void main(String[] args) {
         A obj1 = new B();
         B obj2 = new B();
         B par = new B();
         System.out.println(obj2.m(par));
         }
 }
 class A {
 int x = 0;
 String m(A a) { return "a in a"; }
 }
 class B extends A {
 String m(A a) { return "a in b"; }
 String m(B b) { return "b in b"; }
 }


 //This block of code creates 3 new objects of type B.
 //Class B extends A
 //The output is a print of obj2.m(par) so the output is "b in b" because m(B b) matches the best

