public class ForLoop {
    public static void main(String[] args) {
        ForLoop jj = new ForLoop();   // not explained yet
        for(int i=0; i<21; i++){
            //String rr = jj.isEven(i);
            String rr = jj.checkReminder(i, 7);
            String fmt = String.format("The index is: %2d and is %s", i, rr);
            System.out.println(fmt);
        }

        for(int h=0; h<10; h++){
            System.out.println("The index is: " + h);
        }
    }

    public String isEven(int j){
        int res=j%2;
        if(res == 0){
            return "Even";
        }
        else {
            return "Odd";
        }
    }

    public String checkReminder(int i, int d){
        int result = i%d;
        if(result == 0){
            return "The number " + i + " is divisible by: " + d;
        }
        else{
            return "The number " + i + " is not divisible by: " + d;
        }
    }

}
