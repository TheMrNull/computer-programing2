public class Ambush {
    static String arr[] = {"a","b","c","d","e"};
    public static void processData(String[] a){
        try{
            String last = a[0];
            int length = last.length();
        }
        catch (ArrayIndexOutOfBoundsException d){
            System.out.println("Error with array size");
        }
        catch (Exception e) {
            System.out.println("Error");
        }
    }

    static void main(String[] args) {
        processData(arr);
    }
}
