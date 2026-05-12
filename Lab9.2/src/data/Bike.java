package data;

public class Bike implements Comparable<Bike>{
    protected String manufacturer;

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
        return (this.getManufacturer().compareToIgnoreCase(o.getManufacturer()));
        //  return compare(this.getCost(), o.getCost());
    }

    public static int compare(int x, int y) {
        return x < y ? -1 : (x == y ? 0 : 1);
    }
    public static int compare(double x, double y) {
        return x < y ? -1 : (x == y ? 0 : 1);
    }


    static public enum bikeType {
        MTB,
        ROAD,
        CITYBIKE,
        UNKNOWN,
        EBIKE,
    }
    protected bikeType type;
    protected double cost;
    protected double wheelSize;
    protected String model;


    public Bike(){
        this.cost=-1;
        this.type= bikeType.UNKNOWN;
        this.wheelSize=0;
        this.manufacturer="NA";
        this.model="NA";
    }
    public Bike(String m,String model, double ws, double c, bikeType t){
        this.cost=c;
        this.type= t;
        this.wheelSize=ws;
        this.manufacturer=m;
        this.model=model;
        if(t == bikeType.EBIKE){
            this.cost=-1;
            this.type= bikeType.UNKNOWN;
            this.wheelSize=0;
            this.manufacturer="Shouldnotarrive here";
            this.model="shoudl not be there";
        }
    }
    public String toString(){
        return String.format("Bike: %15s Model %10s Type: %10s Cost: %7.2f WheelSize: %4.1f",
                this.manufacturer, this.getModel(),this.type.toString(), this.cost,this.wheelSize);

    }


    public static void main(String[] argv){

        Bike [] catalog = {
                new Bike(),
                new Bike("Pinarello","scorpiom",28,4500,bikeType.ROAD),
                new Bike("Coppi","dragon",29,6500,bikeType.MTB),
                new Bike("Campagnolo","Marilu",26,500,bikeType.CITYBIKE),
                // new Bike("Campagnolo","goldfinger",26,9500,bikeType.EBIKE),


        };

        for (Bike b:catalog){
            System.out.println(b);
        }
    }
}