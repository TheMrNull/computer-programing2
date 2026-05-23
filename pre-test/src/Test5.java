 import java.util.*;

         public class Test5 {
 public static void main(String[] args) {
         List<A> ls = new ArrayList<>();   //An empty array list is created
         ls.add(new A("Audi")); ls.add(new A("Mazda")); ls.add(new A("Toyota")); //We add the following strings as elements
         Collections.sort(ls); // we sort them, how? sort method is defined in the lines 12-17
         for(A a: ls)
             System.out.println(a.s.length());
         }
 }
 class A implements Comparable<A> {
 String s;
 A(String s) { this.s = s; }
 public int compareTo(A a) {
         return (s.length() - a.s.length());  //We compare the 2 strings, if result is -1 first one comes first, in 0 same length, if 1 second comes first
         }
 }

 //So this code creates an array and adds "Audi" (length 4), "Mazda" (length 5), "Toyota" (Length 6)
 //They get sorted (even if they are technically already in the correct order). So 4 gets compared with 5 --> 4-5 = -1, Audi comes first. And so on
 //Final output is 4 5 6



