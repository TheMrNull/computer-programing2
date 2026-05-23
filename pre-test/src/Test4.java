public class Test4 {
    public static void main(String[] args) {
         I i = new C(3);
         System.out.println(i.m(10));
         }
 }
 interface I {
 int m(int z);
 }
 class A implements I {
 int x;
 A(int x) { this.x = x + 1; }
 public int m(int z) { return x + z; }
 }
 class B extends A {
 B(int x) { super(++x); }
 public int m(int z) { return x * z; }
 }
  class C extends B {
 C(int x) { super(++x); }
}



// New object  is created in C. C extends B, B extends A, A implements I. So actually C is in I
//So the initial 3 becomes: 3->4->5->6
//Then, C doesn't have a .m() in its code, it implements the first one that it can find so the one found in B, so x*z
//So the final output is 6 * 10 = 60
