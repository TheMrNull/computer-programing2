class Count{
    void printNumbers(){
        for(int i=0; i<=10; i++){
            System.out.println(i);
        }
    }
}

class Bike{
    int years;
    String made;
    String color;
    void print(){
        System.out.println(this.color);
        System.out.println(this.years);
        System.out.println(this.made);
    }
}



public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Test");
        Count c = new Count();
        c.printNumbers();
        Bike first = new Bike();
        first.made = "AA";
        first.years = 10;
        first.color = "red";
        first.print();
    }
}


