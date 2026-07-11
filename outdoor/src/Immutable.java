public class Immutable {
    static String message = "Hello";

    public static void appendWorld(String s){
        s = s + " World";
    }

    static void main(String[] args) {
        appendWorld(message);
        System.out.println(message);
    }
}
