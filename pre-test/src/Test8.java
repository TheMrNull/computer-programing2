import java.util.*;
 public class Test8 {
 public static void main(String[] a) {
         Test8 t = new Test8();
         System.out.println(t.m(5, 3));
         }
 int m(int a, int b) {
         int z = 4;
         ArrayList<Integer> l = new ArrayList<>();
         Set<Integer> s = new HashSet<>();
         for (int i = 0; i < a; i++)
             l.add(i);
         for (int i = z; i < b + z; i++)
             s.add(i);
         s.addAll(l);
         return s.size();
         }
  }



  //l = 0,1,2,3,4
// s = 4,5,6
// s = 0,1,2,3,4,4,5,6
// output = 7