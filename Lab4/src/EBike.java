public class EBike extends Bike{ // extends means that this E-Bike class is a child class of Bike
    private double kmPerCharge;

    public EBike(){
        super();//To call the constructor of the parent class
        kmPerCharge = -1;
    }

    public EBike(String m, double r, bikeType t, double k){
        super(m,r,t);
        kmPerCharge = k;
    }

    public static void main(String[] args) {
        EBike eb01 = new EBike();
        EBike eb02 = new EBike("Pinarello Gravel performance", 80.0f, bikeType.RACE,200.0f);
        Bike b03 = new Bike();
        Bike b04 = new Bike("Graziella", 15, bikeType.CITY);
        System.out.println(eb01);
        System.out.println(eb02);
        System.out.println(b03);
        System.out.println(b04);
    }

    @Override
    public String toString() {
        /*String r = String.format(" kmRange: %6.0f", kmPerCharge);
        return super.toString() + r;*/
        String r = String.format("EBike: manufacturer: %-30s, rate: %6.2f, BikeType: %s kmRange: %6.0f",
                manufacturer, dailyRate, type, kmPerCharge);
        return r;
    }
}
