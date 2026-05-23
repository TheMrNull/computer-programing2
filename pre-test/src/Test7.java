 public class Test7 {
 public static void main(String[] args) {
         Z a = new Z();
         a.m1(10); a.m2(5);
         System.out.println("y="+a.y);
         }
 }
 class Z {
 static int y = 1;
 void m1(int y) { m2(y++); }
 void m2(int y) { --y; }
 }

// y is static, so it belongs to the class Z, not the object a.
// m1 and m2 use local parameter y, which is a copy.
// Changes to y inside methods do not affect Z.y.
// Therefore Z.y remains 1 and output is y=1.