package data;

public class Bike implements Comparable<Bike>{
    protected String manufacturer;
    protected bikeType type;
    protected double cost;
    protected double wheelSize;
    protected String model;


    static public enum bikeType{
        MTB,
        ROAD,
        CITYBIKE,
        UNKNOWN,
        EBIKE
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public bikeType getType() {
        return type;
    }

    public void setType(bikeType type) {
        this.type = type;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getWheelSize() {
        return wheelSize;
    }

    public void setWheelSize(double wheelSize) {
        this.wheelSize = wheelSize;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public int compareTo(Bike o) {
        return (this.getManufacturer().compareToIgnoreCase(o.getManufacturer())); //orders them alphabetically following the manufacturers
    }

    public static int compare(int x, int y){
        return x < y ? -1 : (x==y ? 0:1);
    }

    public static int compare(double x, double y){
        return x < y ? -1 : (x==y? 0 : 1);
    }

    public Bike(){    //Default constructor
        this.cost = -1;
        this.type = bikeType.UNKNOWN;
        this.wheelSize = 0;
        this.model = "NA";
        this.manufacturer = "NA";
    }

    public Bike(double c, bikeType t, double ws, String m, String manu){ //Constructor for bikes with data
        this.cost = c;
        this.type = t;
        this.wheelSize = ws;
        this.model = m;
        this.manufacturer = manu;

        if(t == bikeType.EBIKE){
            this.cost = c;
            this.type = bikeType.UNKNOWN;
            this.wheelSize = ws;
            this.model = "should not be here";
            this.manufacturer = "Should not be here";
        }
    }


    @Override
    public String toString() {
        return String.format("Manufacturer: %15s Model: %10s BikeType: %10s Cost: %8.2f  WheelSize: %4.2f",
        this.getManufacturer(), this.getModel(), this.type, this.getCost(), this.getWheelSize());
    }


    static void main(String[] args) {
        Bike [] catalog = {
                new Bike(),
                new Bike(1500, bikeType.ROAD, 29, "dragon", "Coppi"),
                //new Bike(2000, bikeType.EBIKE, 29, "lizard", "Tesla")
        };

        for(Bike b : catalog){
            System.out.println(b);
        }

    }


}
