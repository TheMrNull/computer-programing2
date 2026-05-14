package data;

public class EBike extends Bike{
    protected double batterySize;

    public double getBatterySize() {
        return batterySize;
    }

    public void setBatterySize(double batterySize) {
        this.batterySize = batterySize;
    }

    public EBike(){ //default constructor
        super();
        this.batterySize = 0;
    }

    public EBike(double c, bikeType t, double ws, String m, String manu, double bs){
        super(c,bikeType.UNKNOWN,ws,m,manu);
        this.setType(t);
        this.setBatterySize(bs);
    }


    @Override
    public String toString() {
        return String.format("Manufacturer: %15s Model: %10s BikeType: %10s Cost: %8.2f  WheelSize: %4.2f BatterySize: %5.1f",
                this.getManufacturer(), this.getModel(), this.type.toString(), this.getCost(), this.getWheelSize(), this.getBatterySize());
    }


    static void main(String[] args) {
        Bike [] catalog = {
                new Bike(),
                new Bike(1500, bikeType.ROAD, 29, "dragon", "Coppi"),
                new Bike(2000, bikeType.EBIKE, 29, "lizard", "Tesla")
        };

        for(Bike b : catalog){
            System.out.println(b);
        }

    }
}
