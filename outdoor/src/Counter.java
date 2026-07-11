public class Counter {
    int count = 0;

    synchronized int increment(){
        return count++;
    }


}
